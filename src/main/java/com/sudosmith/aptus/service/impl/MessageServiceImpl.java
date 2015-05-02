package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.MessageDAO;
import com.sudosmith.aptus.model.Message;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.MessageService;


@Service("messageService")
public class MessageServiceImpl implements MessageService{

	private Logger logger = Logger.getLogger(MessageServiceImpl.class);

	@Autowired
	private MessageDAO messageDao;

	@Transactional
	public Message addMessage(Message message) throws Exception {
		logger.debug("in addMessage()");
		try {
			return messageDao.create(message);
		} catch (Exception e) {
			logger.error("Error adding message details", e);
		}
		return null;
	}

	@Transactional
	public Message editMessage(Message message) throws Exception {

		logger.debug("In editMessage()");
		logger.info("Message  RequestId - " + message.getRequestId());
		try {
			return messageDao.merge(message);
		} catch (Exception e) {
			logger.error("Error updaing message details", e);
		}
		return null;

	}

	@Transactional
	public void deleteMessage(int messageId) throws Exception {
		logger.debug("In deleteMessage()");
		try {
			Message message = messageDao.findById(messageId);
			if (message != null) {
				messageDao.delete(message);
			}
		} catch (Exception e) {
			logger.error("Error removing Message by id - " + messageId, e);
		}
	}

	@Transactional
	public List<Message> findAllMessages() throws Exception {
		logger.debug("In findAllMessages()");
		try {
			return messageDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting Messages list.", e);
		}
		return null;
	}

	@Transactional
	public Message findMessageById(int messageId) throws Exception {
		logger.debug("In findMessageById()");
		try {
			return messageDao.findById(messageId);
		} catch (Exception e) {
			logger.error("Error in finding Message by id - " + messageId, e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.crud.service.SupportedDeviceService#findByQueryParams(java.lang.String
	 * , java.util.Map)
	 */
	@Transactional
	public List<Message> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Message> messages = new ArrayList<Message>();
		try {
			List<?> messageList = messageDao.findByQueryParams("findMessageByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = messageList.iterator(); iterator
					.hasNext();) {
				Message message = (Message) iterator.next();
				messages.add(message);
			}
			return messages;
		} catch (Exception e) {
			logger.error("Error getting Messages list.", e);
		}
		return null;
	}
	

	@Transactional
	public List<Message> findMessageByRequestId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Message> messages = new ArrayList<Message>();
		try {
			List<?> messageList = messageDao.findByQueryParams("findMessageByRequestId",
					queryParameters,page);
			for (Iterator<?> iterator = messageList.iterator(); iterator
					.hasNext();) {
				Message message = (Message) iterator.next();
				messages.add(message);
			}
			return messages;
		} catch (Exception e) {
			logger.error("Error getting Messages list.", e);
		}
		return null;
	}		
	
	
	@Transactional
	public List<Message> findAllMessages(Page page){
		
		logger.debug("In findAllMessages(Page page)");
		try {
			return messageDao.findAll(page, "findAllMessagesByPaging");
		} catch (Exception e) {
			logger.error("Error getting Messages list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	//@Override
	public int totalNoOfRecord() {
		try {
			return messageDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	

}
