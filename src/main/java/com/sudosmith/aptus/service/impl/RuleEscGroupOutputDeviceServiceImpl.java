package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.RuleEscGroupOutputDeviceDAO;
import com.sudosmith.aptus.model.RuleEscGroupOutputDevice;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.RuleEscGroupOutputDeviceService;

@Service("ruleEscGroupOutputDeviceService")
public class RuleEscGroupOutputDeviceServiceImpl implements RuleEscGroupOutputDeviceService {
	
	private Logger logger = Logger.getLogger(RuleEscGroupOutputDeviceServiceImpl.class);

	@Autowired
	private RuleEscGroupOutputDeviceDAO ruleOutputDeviceDao;

	@Transactional
	public RuleEscGroupOutputDevice addRuleOutputDevice(RuleEscGroupOutputDevice ruleOutputDevice) throws Exception {
		logger.debug("in addRuleOutputDevice()");
		try {
			return ruleOutputDeviceDao.create(ruleOutputDevice);
		} catch (Exception e) {
			logger.error("Error adding ruleOutputDevice details", e);
		}
		return null;
	}

	@Transactional
	public RuleEscGroupOutputDevice editRuleOutputDevice(RuleEscGroupOutputDevice ruleOutputDevice) throws Exception {

		logger.debug("In editRuleOutputDevice()");
		logger.info("RuleOutputDevice Id - " + ruleOutputDevice.getDeviceId());
		try {
			return ruleOutputDeviceDao.merge(ruleOutputDevice);
		} catch (Exception e) {
			logger.error("Error updaing ruleOutputDevice details", e);
		}
		return null;

	}

	@Transactional
	public void deleteRuleOutputDevice(int ruleOutputDeviceId) throws Exception {
		logger.debug("In deleteRuleOutputDevice()");
		try {
			RuleEscGroupOutputDevice ruleOutputDevice = ruleOutputDeviceDao.findById(ruleOutputDeviceId);
			if (ruleOutputDevice != null) {
				ruleOutputDeviceDao.delete(ruleOutputDevice);
			}
		} catch (Exception e) {
			logger.error("Error removing RuleOutputDevice by id - " + ruleOutputDeviceId, e);
		}
	}

	@Transactional
	public List<RuleEscGroupOutputDevice> findAllRuleOutputDevices() throws Exception {
		logger.debug("In findAllRuleOutputDevices()");
		try {
			return ruleOutputDeviceDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting RuleOutputDevices list.", e);
		}
		return null;
	}

	@Transactional
	public RuleEscGroupOutputDevice findRuleOutputDeviceById(int ruleOutputDeviceId) throws Exception {
		logger.debug("In findRuleOutputDeviceById()");
		try {
			return ruleOutputDeviceDao.findById(ruleOutputDeviceId);
		} catch (Exception e) {
			logger.error("Error in finding RuleOutputDevice by id - " + ruleOutputDeviceId, e);
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
	public List<RuleEscGroupOutputDevice> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<RuleEscGroupOutputDevice> ruleOutputDevices = new ArrayList<RuleEscGroupOutputDevice>();
		try {
			List<?> ruleOutputDeviceList = ruleOutputDeviceDao.findByQueryParams("findRuleOutputDeviceByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = ruleOutputDeviceList.iterator(); iterator
					.hasNext();) {
				RuleEscGroupOutputDevice ruleOutputDevice = (RuleEscGroupOutputDevice) iterator.next();
				ruleOutputDevices.add(ruleOutputDevice);
			}
			return ruleOutputDevices;
		} catch (Exception e) {
			logger.error("Error getting RuleOutputDevices list.", e);
		}
		return null;
	}
	
	@Transactional
	public List<RuleEscGroupOutputDevice> findRuleEscGroupOutputDeviceByRuleId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<RuleEscGroupOutputDevice> ruleOutputDevices = new ArrayList<RuleEscGroupOutputDevice>();
		try {
			List<?> ruleOutputDeviceList = ruleOutputDeviceDao.findByQueryParams("findRuleEscGroupOutputDeviceByRuleId",
					queryParameters,page);
			for (Iterator<?> iterator = ruleOutputDeviceList.iterator(); iterator
					.hasNext();) {
				RuleEscGroupOutputDevice ruleOutputDevice = (RuleEscGroupOutputDevice) iterator.next();
				ruleOutputDevices.add(ruleOutputDevice);
			}
			return ruleOutputDevices;
		} catch (Exception e) {
			logger.error("Error getting RuleOutputDevices list.", e);
		}
		return null;
	}	
	
	@Transactional
	public List<RuleEscGroupOutputDevice> findAllRuleOutputDevices(Page page){
		
		logger.debug("In findAllRuleOutputDevices(Page page)");
		try {
			return ruleOutputDeviceDao.findAll(page, "findAllRuleOutputDevicesByPaging");
		} catch (Exception e) {
			logger.error("Error getting RuleOutputDevices list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return ruleOutputDeviceDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}		
	

}
