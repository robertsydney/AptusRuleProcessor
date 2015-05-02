package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.EventTypeDAO;
import com.sudosmith.aptus.model.EventType;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.EventTypeService;


@Service("eventTypeService")
public class EventTypeServiceImpl implements EventTypeService {

	private Logger logger = Logger.getLogger(EventTypeServiceImpl.class);

	@Autowired
	private EventTypeDAO eventTypeDao;

	@Transactional
	public EventType addEventType(EventType eventType) throws Exception {
		logger.debug("in addEventType()");
		try {
			return eventTypeDao.create(eventType);
		} catch (Exception e) {
			logger.error("Error adding eventType details", e);
		}
		return null;
	}

	@Transactional
	public EventType editEventType(EventType eventType) throws Exception {

		logger.debug("In editEventType()");
		logger.info("EventType  Name - " + eventType.getEventName());
		try {
			return eventTypeDao.merge(eventType);
		} catch (Exception e) {
			logger.error("Error updaing eventType details", e);
		}
		return null;

	}

	@Transactional
	public void deleteEventType(int eventTypeId) throws Exception {
		logger.debug("In deleteEventType()");
		try {
			EventType eventType = eventTypeDao.findById(eventTypeId);
			if (eventType != null) {
				eventTypeDao.delete(eventType);
			}
		} catch (Exception e) {
			logger.error("Error removing EventType by id - " + eventTypeId, e);
		}
	}

	@Transactional
	public List<EventType> findAllEventTypes() throws Exception {
		logger.debug("In findAllEventTypes()");
		try {
			return eventTypeDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting EventTypes list.", e);
		}
		return null;
	}

	@Transactional
	public EventType findEventTypeById(int eventTypeId) throws Exception {
		logger.debug("In findEventTypeById()");
		try {
			return eventTypeDao.findById(eventTypeId);
		} catch (Exception e) {
			logger.error("Error in finding EventType by id - " + eventTypeId, e);
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
	public List<EventType> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<EventType> eventTypes = new ArrayList<EventType>();
		try {
			List<?> eventTypeList = eventTypeDao.findByQueryParams("findEventTypeByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = eventTypeList.iterator(); iterator
					.hasNext();) {
				EventType eventType = (EventType) iterator.next();
				eventTypes.add(eventType);
			}
			return eventTypes;
		} catch (Exception e) {
			logger.error("Error getting EventTypes list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<EventType> findEventTypeByName(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findEventTypeByName(String queryName, Map<String, Object> queryParameters)");
		List<EventType> eventTypes = new ArrayList<EventType>();
		try {
			List<?> eventTypeList = eventTypeDao.findByQueryParams("findEventTypeByName",
					queryParameters,page);
			for (Iterator<?> iterator = eventTypeList.iterator(); iterator
					.hasNext();) {
				EventType eventType = (EventType) iterator.next();
				eventTypes.add(eventType);
			}
			return eventTypes;
		} catch (Exception e) {
			logger.error("Error getting EventTypes list.", e);
		}
		return null;
	}
	
	@Transactional
	public List<EventType> findAllEventTypes(Page page){
		
		logger.debug("In findAllEventTypes(Page page)");
		try {
			return eventTypeDao.findAll(page, "findAllEventTypesByPaging");
		} catch (Exception e) {
			logger.error("Error getting EventTypes list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	//@Override
	public int totalNoOfRecord() {
		try {
			return eventTypeDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
