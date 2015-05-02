package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.RuleEsc;
import com.sudosmith.aptus.pagination.Page;

public interface RuleEscService {

    public RuleEsc addRuleEsc(RuleEsc ruleEsc) throws Exception;
	
	public RuleEsc editRuleEsc(RuleEsc ruleEsc) throws Exception;
	
	public void deleteRuleEsc(int ruleEscId) throws Exception;
	
	public List<RuleEsc> findAllRuleEscs() throws Exception;
	
	public List<RuleEsc> findAllRuleEscs(Page page);
	
	public RuleEsc findRuleEscById(int ruleEscId) throws Exception;
	
	public List<RuleEsc> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<RuleEsc> findRuleEscByRuleId(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();	
	
}
