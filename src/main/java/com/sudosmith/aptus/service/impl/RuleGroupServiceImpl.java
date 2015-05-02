package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.RuleGroupDAO;
import com.sudosmith.aptus.model.RuleGroup;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.RuleGroupService;

@Service("ruleGroupService")
public class RuleGroupServiceImpl implements RuleGroupService {
	
	private Logger logger = Logger.getLogger(RuleGroupServiceImpl.class);

	@Autowired
	private RuleGroupDAO ruleGroupDao;

	@Transactional
	public RuleGroup addRuleGroup(RuleGroup ruleGroup) throws Exception {
		logger.debug("in addRuleGroup()");
		try {
			return ruleGroupDao.create(ruleGroup);
		} catch (Exception e) {
			logger.error("Error adding ruleGroup details", e);
		}
		return null;
	}

	@Transactional
	public RuleGroup editRuleGroup(RuleGroup ruleGroup) throws Exception {

		logger.debug("In editRuleGroup()");
		logger.info("RuleGroup Name - " + ruleGroup.getRuleGroupName());
		try {
			return ruleGroupDao.merge(ruleGroup);
		} catch (Exception e) {
			logger.error("Error updaing ruleGroup details", e);
		}
		return null;

	}

	@Transactional
	public void deleteRuleGroup(int ruleGroupId) throws Exception {
		logger.debug("In deleteRuleGroup()");
		try {
			RuleGroup ruleGroup = ruleGroupDao.findById(ruleGroupId);
			if (ruleGroup != null) {
				ruleGroupDao.delete(ruleGroup);
			}
		} catch (Exception e) {
			logger.error("Error removing RuleGroup by id - " + ruleGroupId, e);
		}
	}

	@Transactional
	public List<RuleGroup> findAllRuleGroups() throws Exception {
		logger.debug("In findAllRuleGroups()");
		try {
			return ruleGroupDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting RuleGroups list.", e);
		}
		return null;
	}

	@Transactional
	public RuleGroup findRuleGroupById(int ruleGroupId) throws Exception {
		logger.debug("In findRuleGroupById()");
		try {
			return ruleGroupDao.findById(ruleGroupId);
		} catch (Exception e) {
			logger.error("Error in finding RuleGroup by id - " + ruleGroupId, e);
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
	public List<RuleGroup> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<RuleGroup> ruleGroups = new ArrayList<RuleGroup>();
		try {
			List<?> ruleGroupList = ruleGroupDao.findByQueryParams("findRuleGroupByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = ruleGroupList.iterator(); iterator
					.hasNext();) {
				RuleGroup ruleGroup = (RuleGroup) iterator.next();
				ruleGroups.add(ruleGroup);
			}
			return ruleGroups;
		} catch (Exception e) {
			logger.error("Error getting RuleGroups list.", e);
		}
		return null;
	}
	
	@Transactional
	public List<RuleGroup> findAllRuleGroups(Page page){
		
		logger.debug("In findAllRuleGroups(Page page)");
		try {
			return ruleGroupDao.findAll(page, "findAllRuleGroupsByPaging");
		} catch (Exception e) {
			logger.error("Error getting RuleGroups list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return ruleGroupDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	

}
