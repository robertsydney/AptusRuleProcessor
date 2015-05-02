package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.EventRegisterDAO;
import com.sudosmith.aptus.model.EventRegister;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.EventRegisterService;

@Service("eventRegisterService")
public class EventRegisterServiceImpl implements EventRegisterService {

	private Logger logger = Logger.getLogger(EventRegisterServiceImpl.class);

	@Autowired
	private EventRegisterDAO eventRegisterDao;

	@Transactional
	public EventRegister addEventRegister(EventRegister eventRegister) throws Exception {
		logger.debug("in addEventRegister()");
		try {
			return eventRegisterDao.create(eventRegister);
		} catch (Exception e) {
			logger.error("Error adding eventRegister details", e);
		}
		return null;
	}

	@Transactional
	public EventRegister editEventRegister(EventRegister eventRegister) throws Exception {

		logger.debug("In editEventRegister()");
		logger.info("EventRegister  RequestId - " + eventRegister.getRequestId());
		try {
			return eventRegisterDao.merge(eventRegister);
		} catch (Exception e) {
			logger.error("Error updaing eventRegister details", e);
		}
		return null;

	}

	@Transactional
	public void deleteEventRegister(int eventRegisterId) throws Exception {
		logger.debug("In deleteEventRegister()");
		try {
			EventRegister eventRegister = eventRegisterDao.findById(eventRegisterId);
			if (eventRegister != null) {
				eventRegisterDao.delete(eventRegister);
			}
		} catch (Exception e) {
			logger.error("Error removing EventRegister by id - " + eventRegisterId, e);
		}
	}

	@Transactional
	public List<EventRegister> findAllEventRegisters() throws Exception {
		logger.debug("In findAllEventRegisters()");
		try {
			return eventRegisterDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting EventRegisters list.", e);
		}
		return null;
	}

	@Transactional
	public EventRegister findEventRegisterById(int eventRegisterId) throws Exception {
		logger.debug("In findEventRegisterById()");
		try {
			return eventRegisterDao.findById(eventRegisterId);
		} catch (Exception e) {
			logger.error("Error in finding EventRegister by id - " + eventRegisterId, e);
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
	public List<EventRegister> findAllEventRegisters(Page page){
		
		logger.debug("In findAllEventRegisters(Page page)");
		try {
			return eventRegisterDao.findAll(page, "findAllEventRegistersByPaging");
		} catch (Exception e) {
			logger.error("Error getting EventRegisters list.", e);
		}
		return null;
	
	}
	
	@Transactional
	public List<EventRegister>  findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByUid(String queryName, Map<String, Object> queryParameters)");
		List<EventRegister> eventRegisters = new ArrayList<EventRegister>();
		try {
			List<?> eventRegisterList = eventRegisterDao.findByQueryParams("findEventRegisterByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = eventRegisterList.iterator(); iterator
					.hasNext();) {
				EventRegister eventRegister = (EventRegister) iterator.next();
				eventRegisters.add(eventRegister);
			}
			return eventRegisters;
		} catch (Exception e) {
			logger.error("Error getting EventRegisters list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<EventRegister>  findEventRegisterByDeviceId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findEventRegisterByDeviceId(String queryName, Map<String, Object> queryParameters)");
		List<EventRegister> eventRegisters = new ArrayList<EventRegister>();
		try {
			List<?> eventRegisterList = eventRegisterDao.findByQueryParams("findEventRegisterByDeviceId",
					queryParameters,page);
			for (Iterator<?> iterator = eventRegisterList.iterator(); iterator
					.hasNext();) {
				EventRegister eventRegister = (EventRegister) iterator.next();
				eventRegisters.add(eventRegister);
			}
			return eventRegisters;
		} catch (Exception e) {
			logger.error("Error getting EventRegisters list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<EventRegister>  findEventRegisterByRequestId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findEventRegisterByRequestId(String queryName, Map<String, Object> queryParameters)");
		List<EventRegister> eventRegisters = new ArrayList<EventRegister>();
		try {
			List<?> eventRegisterList = eventRegisterDao.findByQueryParams("findEventRegisterByRequestId",
					queryParameters,page);
			for (Iterator<?> iterator = eventRegisterList.iterator(); iterator
					.hasNext();) {
				EventRegister eventRegister = (EventRegister) iterator.next();
				eventRegisters.add(eventRegister);
			}
			return eventRegisters;
		} catch (Exception e) {
			logger.error("Error getting EventRegisters list.", e);
		}
		return null;
	}
	


	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	//@Override
	public int totalNoOfRecord() {
		try {
			return eventRegisterDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
