package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.RuleEventType;
import com.sudosmith.aptus.pagination.Page;

public interface RuleEventTypeService {
	
    public RuleEventType addRuleEventType(RuleEventType ruleEventType) throws Exception;
	
	public RuleEventType editRuleEventType(RuleEventType ruleEventType) throws Exception;
	
	public void deleteRuleEventType(int ruleEventTypeId) throws Exception;
	
	public List<RuleEventType> findAllRuleEventTypes() throws Exception;
	
	public List<RuleEventType> findAllRuleEventTypes(Page page);
	
	public RuleEventType findRuleEventTypeById(int ruleEventTypeId) throws Exception;
	
	public List<RuleEventType> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<RuleEventType> findRuleEventTypeByRuleEventId(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();		

}
