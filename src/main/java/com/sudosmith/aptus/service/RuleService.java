package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.Rule;
import com.sudosmith.aptus.pagination.Page;

public interface RuleService {
	
    public Rule addRule(Rule rule) throws Exception;
	
	public Rule editRule(Rule rule) throws Exception;
	
	public void deleteRule(int ruleId) throws Exception;
	
	public List<Rule> findAllRules() throws Exception;
	
	public List<Rule> findAllRules(Page page);
	
	public Rule findRuleById(int ruleId) throws Exception;
	
	public List<Rule> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<Rule> findRuleByGroupId(Map<String, Object> queryParameters, Page page);
	
	public List<Rule> findRuleByGroupIdTime(Map<String, Object> queryParameters, Page page);	
	
	public List<Rule> findRuleByDayTime(Map<String, Object> queryParameters, Page page);		
	
	public List<Rule> findRuleByDay(Map<String, Object> queryParameters, Page page);		
	
	public int totalNoOfRecord();
	
}

