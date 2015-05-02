package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.Message;
import com.sudosmith.aptus.pagination.Page;

public interface MessageService {
	
    public Message addMessage(Message message) throws Exception;
	
	public Message editMessage(Message message) throws Exception;
	
	public void deleteMessage(int messageId) throws Exception;
	
	public List<Message> findAllMessages() throws Exception;
	
	public List<Message> findAllMessages(Page page);
	
	public Message findMessageById(int messageId) throws Exception;
	
	public List<Message> findByQueryParams(Map<String, Object> queryParameters, Page page);	
	
	public List<Message> findMessageByRequestId(Map<String, Object> queryParameters, Page page);	
	
	public int totalNoOfRecord();		

}
