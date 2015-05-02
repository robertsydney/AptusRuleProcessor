package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.RuleDAO;
import com.sudosmith.aptus.model.Rule;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.RuleService;


@Service("ruleService")
public class RuleServiceImpl implements RuleService {
	
	private Logger logger = Logger.getLogger(RuleServiceImpl.class);

	@Autowired
	private RuleDAO ruleDao;

	@Transactional
	public Rule addRule(Rule rule) throws Exception {
		logger.debug("in addRule()");
		try {
			return ruleDao.create(rule);
		} catch (Exception e) {
			logger.error("Error adding rule details", e);
		}
		return null;
	}

	@Transactional
	public Rule editRule(Rule rule) throws Exception {

		logger.debug("In editRule()");
		logger.info("Rule  Day - " + rule.getDay());
		try {
			return ruleDao.merge(rule);
		} catch (Exception e) {
			logger.error("Error updaing rule details", e);
		}
		return null;

	}

	@Transactional
	public void deleteRule(int ruleId) throws Exception {
		logger.debug("In deleteRule()");
		try {
			Rule rule = ruleDao.findById(ruleId);
			if (rule != null) {
				ruleDao.delete(rule);
			}
		} catch (Exception e) {
			logger.error("Error removing Rule by id - " + ruleId, e);
		}
	}

	@Transactional
	public List<Rule> findAllRules() throws Exception {
		logger.debug("In findAllRules()");
		try {
			return ruleDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting Rules list.", e);
		}
		return null;
	}

	@Transactional
	public Rule findRuleById(int ruleId) throws Exception {
		logger.debug("In findRuleById()");
		try {
			return ruleDao.findById(ruleId);
		} catch (Exception e) {
			logger.error("Error in finding Rule by id - " + ruleId, e);
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
	public List<Rule> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Rule> rules = new ArrayList<Rule>();
		try {
			List<?> ruleList = ruleDao.findByQueryParams("findRuleByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = ruleList.iterator(); iterator
					.hasNext();) {
				Rule rule = (Rule) iterator.next();
				rules.add(rule);
			}
			return rules;
		} catch (Exception e) {
			logger.error("Error getting Rules list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<Rule> findRuleByGroupId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Rule> rules = new ArrayList<Rule>();
		try {
			List<?> ruleList = ruleDao.findByQueryParams("findRuleByGroupId",
					queryParameters,page);
			for (Iterator<?> iterator = ruleList.iterator(); iterator
					.hasNext();) {
				Rule rule = (Rule) iterator.next();
				rules.add(rule);
			}
			return rules;
		} catch (Exception e) {
			logger.error("Error getting Rules list.", e);
		}
		return null;
	}	
	
	
	@Transactional
	public List<Rule> findRuleByGroupIdTime(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Rule> rules = new ArrayList<Rule>();
		try {
			List<?> ruleList = ruleDao.findByQueryParams("findRuleByGroupIdTime",
					queryParameters,page);
			for (Iterator<?> iterator = ruleList.iterator(); iterator
					.hasNext();) {
				Rule rule = (Rule) iterator.next();
				rules.add(rule);
			}
			return rules;
		} catch (Exception e) {
			logger.error("Error getting Rules list.", e);
		}
		return null;
	}		
	
	
	@Transactional
	public List<Rule> findRuleByDayTime(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Rule> rules = new ArrayList<Rule>();
		try {
			List<?> ruleList = ruleDao.findByQueryParams("findRuleByDayTime",
					queryParameters,page);
			for (Iterator<?> iterator = ruleList.iterator(); iterator
					.hasNext();) {
				Rule rule = (Rule) iterator.next();
				rules.add(rule);
			}
			return rules;
		} catch (Exception e) {
			logger.error("Error getting Rules list.", e);
		}
		return null;
	}	
	
	
	@Transactional
	public List<Rule> findRuleByDay(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Rule> rules = new ArrayList<Rule>();
		try {
			List<?> ruleList = ruleDao.findByQueryParams("findRuleByDay",
					queryParameters,page);
			for (Iterator<?> iterator = ruleList.iterator(); iterator
					.hasNext();) {
				Rule rule = (Rule) iterator.next();
				rules.add(rule);
			}
			return rules;
		} catch (Exception e) {
			logger.error("Error getting Rules list.", e);
		}
		return null;
	}	
	
	
	
	@Transactional
	public List<Rule> findRuleByDeviceId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Rule> rules = new ArrayList<Rule>();
		try {
			List<?> ruleList = ruleDao.findByQueryParams("findRuleByDeviceId",
					queryParameters,page);
			for (Iterator<?> iterator = ruleList.iterator(); iterator
					.hasNext();) {
				Rule rule = (Rule) iterator.next();
				rules.add(rule);
			}
			return rules;
		} catch (Exception e) {
			logger.error("Error getting Rules list.", e);
		}
		return null;
	}
	
	@Transactional
	public List<Rule> findAllRules(Page page){
		
		logger.debug("In findAllRules(Page page)");
		try {
			return ruleDao.findAll(page, "findAllRulesByPaging");
		} catch (Exception e) {
			logger.error("Error getting Rules list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return ruleDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
