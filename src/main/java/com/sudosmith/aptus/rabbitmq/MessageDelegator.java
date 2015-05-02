package com.sudosmith.aptus.rabbitmq;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudosmith.aptus.rabbitmq.transmitter.MessageTransmitter;
import com.sudosmith.aptus.util.Constant;

/**
 * Message handling asynchronously by message queuing.
 */

@Service
public class MessageDelegator {
	
	@Autowired MessageTransmitter messageTransmitter;
	
	/**
	 * Message will be push to message queues.
	 */
	public void processMessage(byte[] message) throws IOException{	
		try {
			messageTransmitter.transmit(message, Constant.IN_CEN);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
