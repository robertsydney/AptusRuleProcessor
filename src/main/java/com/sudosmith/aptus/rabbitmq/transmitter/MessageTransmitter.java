package com.sudosmith.aptus.rabbitmq.transmitter;

import java.io.IOException;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 
 * Base class for rabbitMQ message transmitter implementation.
 * Send message on the basis of <queueName>
 * 
 */
@Service
public class MessageTransmitter{
	
	protected Connection connection;
	
	@PostConstruct
	public void init() {
		connection = getConnection();
	}
	
	public Connection getConnection() {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			connection = factory.newConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	/**
	 * Send message with rabbitMQ.
	 */
	public void transmit(byte[] message, String queueName) throws Exception {
		transmit(message, queueName, false, false, false, null);
	}
	
	/**
	 * Send message with rabbitMQ.
	 */
	public void transmit(byte[] message, String queueName, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments) {

		Channel channel = null;
		try {
			channel = connection.createChannel();
			channel.queueDeclare(queueName, durable, exclusive, autoDelete, null);
		    channel.basicPublish("", queueName, null, message);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != channel){
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
