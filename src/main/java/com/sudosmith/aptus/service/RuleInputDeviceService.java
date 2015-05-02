package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.RuleInputDevice;
import com.sudosmith.aptus.pagination.Page;

public interface RuleInputDeviceService {
	
    public RuleInputDevice addRuleInputDevice(RuleInputDevice ruleInputDevice) throws Exception;
	
	public RuleInputDevice editRuleInputDevice(RuleInputDevice ruleInputDevice) throws Exception;
	
	public void deleteRuleInputDevice(int ruleInputDeviceId) throws Exception;
	
	public List<RuleInputDevice> findAllRuleInputDevices() throws Exception;
	
	public List<RuleInputDevice> findAllRuleInputDevices(Page page);
	
	public RuleInputDevice findRuleInputDeviceById(int ruleInputDeviceId) throws Exception;
	
	public List<RuleInputDevice> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<RuleInputDevice> findRuleInputDeviceByDeviceId(Map<String, Object> queryParameters, Page page);
	
	public List<RuleInputDevice> findRuleInputDeviceByRuleDeviceId(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();	

}
