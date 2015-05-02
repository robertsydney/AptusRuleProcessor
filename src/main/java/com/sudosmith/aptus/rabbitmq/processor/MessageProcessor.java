package com.sudosmith.aptus.rabbitmq.processor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.sudosmith.aptus.util.Constant;


@Service
public class MessageProcessor {

	protected QueueingConsumer consumer;
	protected Channel channel;

	public Connection getConnection() throws IOException {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			 return factory.newConnection();
	}
	
	/**
	 * Initiate processor with basic configurations.
	 */
	
	public Map<String, String> initiate(){
		Map<String, String> message = null;
		try {
			channel =getConnection().createChannel();
			channel.queueDeclare(Constant.IN_CEN, false, false, false, null);
			channel.basicQos(0);
			consumer = new QueueingConsumer(channel);
			channel.basicConsume(Constant.IN_CEN, false, consumer);
			message=deliveryHandler();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	/**
	 * Fetch Delivery one by one & acknowledge relevant queue once done with process.
	 * @throws Exception
	 */
	private Map<String, String> deliveryHandler(){
		Map<String, String> message = null;
		boolean flg=false;
		while(!flg) 
		{
			try
			{
			Delivery delivery = consumer.nextDelivery(3000);
		    if(delivery.equals(null))
		    {	
		         flg=true;
		         System.out.println("End Reached");
		         break;
		    }
		    else
		    {
		    	byte[] byteArray = delivery.getBody();
		    	ByteArrayInputStream byteIn = new ByteArrayInputStream(byteArray);
			    ObjectInputStream in = new ObjectInputStream(byteIn);
			    message = (Map<String, String>) in.readObject();
				channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		    }
		    }catch (Exception e) {
		     flg=true;	
			 break;
			}    
	    }
		return message;
	}
}
