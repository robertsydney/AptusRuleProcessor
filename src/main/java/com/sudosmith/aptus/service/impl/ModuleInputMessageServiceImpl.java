package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.ModuleInputMessageDAO;
import com.sudosmith.aptus.model.ModuleInputMessage;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.ModuleInputMessageService;

@Service("moduleInputMessageService")
public class ModuleInputMessageServiceImpl implements ModuleInputMessageService{
	
	private Logger logger = Logger.getLogger(ModuleInputMessageServiceImpl.class);

	@Autowired
	private ModuleInputMessageDAO moduleInputMessageDao;

	@Transactional
	public ModuleInputMessage addModuleInputMessage(ModuleInputMessage moduleInputMessage) throws Exception {
		logger.debug("in addModuleInputMessage()");
		try {
			return moduleInputMessageDao.create(moduleInputMessage);
		} catch (Exception e) {
			logger.error("Error adding moduleInputMessage details", e);
		}
		return null;
	}

	@Transactional
	public ModuleInputMessage editModuleInputMessage(ModuleInputMessage moduleInputMessage) throws Exception {

		logger.debug("In editModuleInputMessage()");
		logger.info("ModuleInputMessage  EventId - " + moduleInputMessage.getId());
		try {
			return moduleInputMessageDao.merge(moduleInputMessage);
		} catch (Exception e) {
			logger.error("Error updaing moduleInputMessage details", e);
		}
		return null;

	}

	@Transactional
	public void deleteModuleInputMessage(int moduleInputMessageId) throws Exception {
		logger.debug("In deleteModuleInputMessage()");
		try {
			ModuleInputMessage moduleInputMessage = moduleInputMessageDao.findById(moduleInputMessageId);
			if (moduleInputMessage != null) {
				moduleInputMessageDao.delete(moduleInputMessage);
			}
		} catch (Exception e) {
			logger.error("Error removing ModuleInputMessage by id - " + moduleInputMessageId, e);
		}
	}

	@Transactional
	public List<ModuleInputMessage> findAllModuleInputMessages() throws Exception {
		logger.debug("In findAllModuleInputMessages()");
		try {
			return moduleInputMessageDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting ModuleInputMessages list.", e);
		}
		return null;
	}

	@Transactional
	public ModuleInputMessage findModuleInputMessageById(int moduleInputMessageId) throws Exception {
		logger.debug("In findModuleInputMessageById()");
		try {
			return moduleInputMessageDao.findById(moduleInputMessageId);
		} catch (Exception e) {
			logger.error("Error in finding ModuleInputMessage by id - " + moduleInputMessageId, e);
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
	public List<ModuleInputMessage> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<ModuleInputMessage> moduleInputMessages = new ArrayList<ModuleInputMessage>();
		try {
			List<?> moduleInputMessageList = moduleInputMessageDao.findByQueryParams("findModuleInputMessageByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = moduleInputMessageList.iterator(); iterator
					.hasNext();) {
				ModuleInputMessage moduleInputMessage = (ModuleInputMessage) iterator.next();
				moduleInputMessages.add(moduleInputMessage);
			}
			return moduleInputMessages;
		} catch (Exception e) {
			logger.error("Error getting ModuleInputMessages list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<ModuleInputMessage> findModuleInputMessageByInputId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findModuleInputMessageByInputId(String queryName, Map<String, Object> queryParameters)");
		List<ModuleInputMessage> moduleInputMessages = new ArrayList<ModuleInputMessage>();
		try {
			List<?> moduleInputMessageList = moduleInputMessageDao.findByQueryParams("findModuleInputMessageByInputId",
					queryParameters,page);
			for (Iterator<?> iterator = moduleInputMessageList.iterator(); iterator
					.hasNext();) {
				ModuleInputMessage moduleInputMessage = (ModuleInputMessage) iterator.next();
				moduleInputMessages.add(moduleInputMessage);
			}
			return moduleInputMessages;
		} catch (Exception e) {
			logger.error("Error getting ModuleInputMessages list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<ModuleInputMessage> findAllModuleInputMessages(Page page){
		
		logger.debug("In findAllModuleInputMessages(Page page)");
		try {
			return moduleInputMessageDao.findAll(page, "findAllModuleInputMessagesByPaging");
		} catch (Exception e) {
			logger.error("Error getting ModuleInputMessages list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return moduleInputMessageDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}		

}
