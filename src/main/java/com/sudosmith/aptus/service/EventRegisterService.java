package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.EventRegister;
import com.sudosmith.aptus.pagination.Page;


public interface EventRegisterService {

    public EventRegister addEventRegister(EventRegister eventRegister) throws Exception;
	
	public EventRegister editEventRegister(EventRegister eventRegister) throws Exception;
	
	public void deleteEventRegister(int eventRegisterId) throws Exception;
	
	public List<EventRegister> findAllEventRegisters() throws Exception;
	
	public List<EventRegister> findAllEventRegisters(Page page);
	
	public EventRegister findEventRegisterById(int eventRegisterId) throws Exception;
	
	public List<EventRegister> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<EventRegister> findEventRegisterByDeviceId(Map<String, Object> queryParameters, Page page);
	
	public List<EventRegister> findEventRegisterByRequestId(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();	

}
