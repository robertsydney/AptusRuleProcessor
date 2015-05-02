package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.MessageDAO;
import com.sudosmith.aptus.model.Message;

@Repository("messageDao")
public class MessageDAOImpl extends GenericDAOImpl<Message, Long>
implements MessageDAO {
	public MessageDAOImpl(){
		super(Message.class);
	}
}