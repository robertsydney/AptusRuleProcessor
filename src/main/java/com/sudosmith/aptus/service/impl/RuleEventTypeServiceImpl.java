package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.RuleEventTypeDAO;
import com.sudosmith.aptus.model.RuleEventType;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.RuleEventTypeService;

@Service("ruleEventTypeService")
public class RuleEventTypeServiceImpl implements RuleEventTypeService {

	private Logger logger = Logger.getLogger(RuleEventTypeServiceImpl.class);

	@Autowired
	private RuleEventTypeDAO ruleEventTypeDao;

	@Transactional
	public RuleEventType addRuleEventType(RuleEventType ruleEventType) throws Exception {
		logger.debug("in addRuleEventType()");
		try {
			return ruleEventTypeDao.create(ruleEventType);
		} catch (Exception e) {
			logger.error("Error adding ruleEventType details", e);
		}
		return null;
	}

	@Transactional
	public RuleEventType editRuleEventType(RuleEventType ruleEventType) throws Exception {

		logger.debug("In editRuleEventType()");
		logger.info("RuleEventType  id - " + ruleEventType.getRuleId());
		try {
			return ruleEventTypeDao.merge(ruleEventType);
		} catch (Exception e) {
			logger.error("Error updaing ruleEventType details", e);
		}
		return null;

	}

	@Transactional
	public void deleteRuleEventType(int ruleEventTypeId) throws Exception {
		logger.debug("In deleteRuleEventType()");
		try {
			RuleEventType ruleEventType = ruleEventTypeDao.findById(ruleEventTypeId);
			if (ruleEventType != null) {
				ruleEventTypeDao.delete(ruleEventType);
			}
		} catch (Exception e) {
			logger.error("Error removing RuleEventType by id - " + ruleEventTypeId, e);
		}
	}

	@Transactional
	public List<RuleEventType> findAllRuleEventTypes() throws Exception {
		logger.debug("In findAllRuleEventTypes()");
		try {
			return ruleEventTypeDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting RuleEventTypes list.", e);
		}
		return null;
	}

	@Transactional
	public RuleEventType findRuleEventTypeById(int ruleEventTypeId) throws Exception {
		logger.debug("In findRuleEventTypeById()");
		try {
			return ruleEventTypeDao.findById(ruleEventTypeId);
		} catch (Exception e) {
			logger.error("Error in finding RuleEventType by id - " + ruleEventTypeId, e);
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
	public List<RuleEventType> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<RuleEventType> ruleEventTypes = new ArrayList<RuleEventType>();
		try {
			List<?> ruleEventTypeList = ruleEventTypeDao.findByQueryParams("findRuleEventTypeByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = ruleEventTypeList.iterator(); iterator
					.hasNext();) {
				RuleEventType ruleEventType = (RuleEventType) iterator.next();
				ruleEventTypes.add(ruleEventType);
			}
			return ruleEventTypes;
		} catch (Exception e) {
			logger.error("Error getting RuleEventTypes list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<RuleEventType> findRuleEventTypeByRuleEventId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<RuleEventType> ruleEventTypes = new ArrayList<RuleEventType>();
		try {
			List<?> ruleEventTypeList = ruleEventTypeDao.findByQueryParams("findRuleEventTypeByRuleEventId",
					queryParameters,page);
			for (Iterator<?> iterator = ruleEventTypeList.iterator(); iterator
					.hasNext();) {
				RuleEventType ruleEventType = (RuleEventType) iterator.next();
				ruleEventTypes.add(ruleEventType);
			}
			return ruleEventTypes;
		} catch (Exception e) {
			logger.error("Error getting RuleEventTypes list.", e);
		}
		return null;
	}	

	
	@Transactional
	public List<RuleEventType> findAllRuleEventTypes(Page page){
		
		logger.debug("In findAllRuleEventTypes(Page page)");
		try {
			return ruleEventTypeDao.findAll(page, "findAllRuleEventTypesByPaging");
		} catch (Exception e) {
			logger.error("Error getting RuleEventTypes list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return ruleEventTypeDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}		
	
}
