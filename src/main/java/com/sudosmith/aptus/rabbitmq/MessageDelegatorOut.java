package com.sudosmith.aptus.rabbitmq;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudosmith.aptus.rabbitmq.transmitter.MessageTransmitter;
import com.sudosmith.aptus.util.Constant;

@Service
public class MessageDelegatorOut {

	@Autowired MessageTransmitter messageTransmitter;
	
	/**
	 * Message will be push to message queues.
	 */
	public void processMessageOut(byte[] message) throws IOException{	
		try {
			messageTransmitter.transmit(message, Constant.CEN_OUT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
