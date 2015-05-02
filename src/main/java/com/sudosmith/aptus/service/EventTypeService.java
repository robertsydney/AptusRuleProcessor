package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.EventType;
import com.sudosmith.aptus.pagination.Page;

public interface EventTypeService {

    public EventType addEventType(EventType eventType) throws Exception;
	
	public EventType editEventType(EventType eventType) throws Exception;
	
	public void deleteEventType(int eventTypeId) throws Exception;
	
	public List<EventType> findAllEventTypes() throws Exception;
	
	public List<EventType> findAllEventTypes(Page page);
	
	public EventType findEventTypeById(int eventTypeId) throws Exception;
	
	public List<EventType> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<EventType> findEventTypeByName(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();	

}
