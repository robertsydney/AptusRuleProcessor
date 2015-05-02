package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.RuleEscGroupOutputDevice;
import com.sudosmith.aptus.pagination.Page;

public interface RuleEscGroupOutputDeviceService {

    public RuleEscGroupOutputDevice addRuleOutputDevice(RuleEscGroupOutputDevice ruleOutputDevice) throws Exception;
	
	public RuleEscGroupOutputDevice editRuleOutputDevice(RuleEscGroupOutputDevice ruleOutputDevice) throws Exception;
	
	public void deleteRuleOutputDevice(int ruleOutputDeviceId) throws Exception;
	
	public List<RuleEscGroupOutputDevice> findAllRuleOutputDevices() throws Exception;
	
	public List<RuleEscGroupOutputDevice> findAllRuleOutputDevices(Page page);
	
	public RuleEscGroupOutputDevice findRuleOutputDeviceById(int ruleOutputDeviceId) throws Exception;
	
	public List<RuleEscGroupOutputDevice> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<RuleEscGroupOutputDevice> findRuleEscGroupOutputDeviceByRuleId(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();	

}
