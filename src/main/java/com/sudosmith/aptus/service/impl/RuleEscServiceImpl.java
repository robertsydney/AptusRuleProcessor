package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.RuleEscDAO;
import com.sudosmith.aptus.model.RuleEsc;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.RuleEscService;

@Service("ruleEscService")
public class RuleEscServiceImpl implements RuleEscService {
	
	private Logger logger = Logger.getLogger(RuleEscServiceImpl.class);

	@Autowired
	private RuleEscDAO ruleEscDao;

	@Transactional
	public RuleEsc addRuleEsc(RuleEsc ruleEsc) throws Exception {
		logger.debug("in addRuleEsc()");
		try {
			return ruleEscDao.create(ruleEsc);
		} catch (Exception e) {
			logger.error("Error adding ruleEsc details", e);
		}
		return null;
	}

	@Transactional
	public RuleEsc editRuleEsc(RuleEsc ruleEsc) throws Exception {

		logger.debug("In editRuleEsc()");
		logger.info("RuleEsc Group - " + ruleEsc.getEscGroupName());
		try {
			return ruleEscDao.merge(ruleEsc);
		} catch (Exception e) {
			logger.error("Error updaing ruleEsc details", e);
		}
		return null;

	}

	@Transactional
	public void deleteRuleEsc(int ruleEscId) throws Exception {
		logger.debug("In deleteRuleEsc()");
		try {
			RuleEsc ruleEsc = ruleEscDao.findById(ruleEscId);
			if (ruleEsc != null) {
				ruleEscDao.delete(ruleEsc);
			}
		} catch (Exception e) {
			logger.error("Error removing RuleEsc by id - " + ruleEscId, e);
		}
	}

	@Transactional
	public List<RuleEsc> findAllRuleEscs() throws Exception {
		logger.debug("In findAllRuleEscs()");
		try {
			return ruleEscDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting RuleEscs list.", e);
		}
		return null;
	}

	@Transactional
	public RuleEsc findRuleEscById(int ruleEscId) throws Exception {
		logger.debug("In findRuleEscById()");
		try {
			return ruleEscDao.findById(ruleEscId);
		} catch (Exception e) {
			logger.error("Error in finding RuleEsc by id - " + ruleEscId, e);
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
	public List<RuleEsc> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<RuleEsc> ruleEscs = new ArrayList<RuleEsc>();
		try {
			List<?> ruleEscList = ruleEscDao.findByQueryParams("findRuleEscByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = ruleEscList.iterator(); iterator
					.hasNext();) {
				RuleEsc ruleEsc = (RuleEsc) iterator.next();
				ruleEscs.add(ruleEsc);
			}
			return ruleEscs;
		} catch (Exception e) {
			logger.error("Error getting RuleEscs list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<RuleEsc> findRuleEscByRuleId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<RuleEsc> ruleEscs = new ArrayList<RuleEsc>();
		try {
			List<?> ruleEscList = ruleEscDao.findByQueryParams("findRuleEscByRuleId",
					queryParameters,page);
			for (Iterator<?> iterator = ruleEscList.iterator(); iterator
					.hasNext();) {
				RuleEsc ruleEsc = (RuleEsc) iterator.next();
				ruleEscs.add(ruleEsc);
			}
			return ruleEscs;
		} catch (Exception e) {
			logger.error("Error getting RuleEscs list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<RuleEsc> findAllRuleEscs(Page page){
		
		logger.debug("In findAllRuleEscs(Page page)");
		try {
			return ruleEscDao.findAll(page, "findAllRuleEscsByPaging");
		} catch (Exception e) {
			logger.error("Error getting RuleEscs list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return ruleEscDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	

}
