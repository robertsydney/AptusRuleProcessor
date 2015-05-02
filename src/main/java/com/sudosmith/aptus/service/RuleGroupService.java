package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.RuleGroup;
import com.sudosmith.aptus.pagination.Page;

public interface RuleGroupService {
	
    public RuleGroup addRuleGroup(RuleGroup ruleGroup) throws Exception;
	
	public RuleGroup editRuleGroup(RuleGroup ruleGroup) throws Exception;
	
	public void deleteRuleGroup(int ruleGroupId) throws Exception;
	
	public List<RuleGroup> findAllRuleGroups() throws Exception;
	
	public List<RuleGroup> findAllRuleGroups(Page page);
	
	public RuleGroup findRuleGroupById(int ruleGroupId) throws Exception;
	
	public List<RuleGroup> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();	

}
