package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.RuleInputDeviceDAO;
import com.sudosmith.aptus.model.RuleInputDevice;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.RuleInputDeviceService;

@Service("ruleInputDeviceService")
public class RuleInputDeviceServiceImpl implements RuleInputDeviceService  {
	
	private Logger logger = Logger.getLogger(RuleInputDeviceServiceImpl.class);

	@Autowired
	private RuleInputDeviceDAO ruleInputDeviceDao;

	@Transactional
	public RuleInputDevice addRuleInputDevice(RuleInputDevice ruleInputDevice) throws Exception {
		logger.debug("in addRuleInputDevice()");
		try {
			return ruleInputDeviceDao.create(ruleInputDevice);
		} catch (Exception e) {
			logger.error("Error adding ruleInputDevice details", e);
		}
		return null;
	}

	@Transactional
	public RuleInputDevice editRuleInputDevice(RuleInputDevice ruleInputDevice) throws Exception {

		logger.debug("In editRuleInputDevice()");
		logger.info("RuleInputDevice  id - " + ruleInputDevice.getDeviceId());
		try {
			return ruleInputDeviceDao.merge(ruleInputDevice);
		} catch (Exception e) {
			logger.error("Error updaing ruleInputDevice details", e);
		}
		return null;

	}

	@Transactional
	public void deleteRuleInputDevice(int ruleInputDeviceId) throws Exception {
		logger.debug("In deleteRuleInputDevice()");
		try {
			RuleInputDevice ruleInputDevice = ruleInputDeviceDao.findById(ruleInputDeviceId);
			if (ruleInputDevice != null) {
				ruleInputDeviceDao.delete(ruleInputDevice);
			}
		} catch (Exception e) {
			logger.error("Error removing RuleInputDevice by id - " + ruleInputDeviceId, e);
		}
	}

	@Transactional
	public List<RuleInputDevice> findAllRuleInputDevices() throws Exception {
		logger.debug("In findAllRuleInputDevices()");
		try {
			return ruleInputDeviceDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting RuleInputDevices list.", e);
		}
		return null;
	}

	@Transactional
	public RuleInputDevice findRuleInputDeviceById(int ruleInputDeviceId) throws Exception {
		logger.debug("In findRuleInputDeviceById()");
		try {
			return ruleInputDeviceDao.findById(ruleInputDeviceId);
		} catch (Exception e) {
			logger.error("Error in finding RuleInputDevice by id - " + ruleInputDeviceId, e);
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
	public List<RuleInputDevice> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<RuleInputDevice> ruleInputDevices = new ArrayList<RuleInputDevice>();
		try {
			List<?> ruleInputDeviceList = ruleInputDeviceDao.findByQueryParams("findRuleInputDeviceByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = ruleInputDeviceList.iterator(); iterator
					.hasNext();) {
				RuleInputDevice ruleInputDevice = (RuleInputDevice) iterator.next();
				ruleInputDevices.add(ruleInputDevice);
			}
			return ruleInputDevices;
		} catch (Exception e) {
			logger.error("Error getting RuleInputDevices list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<RuleInputDevice> findRuleInputDeviceByRuleDeviceId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<RuleInputDevice> ruleInputDevices = new ArrayList<RuleInputDevice>();
		try {
			List<?> ruleInputDeviceList = ruleInputDeviceDao.findByQueryParams("findRuleInputDeviceByRuleDeviceId",
					queryParameters,page);
			for (Iterator<?> iterator = ruleInputDeviceList.iterator(); iterator
					.hasNext();) {
				RuleInputDevice ruleInputDevice = (RuleInputDevice) iterator.next();
				ruleInputDevices.add(ruleInputDevice);
			}
			return ruleInputDevices;
		} catch (Exception e) {
			logger.error("Error getting RuleInputDevices list.", e);
		}
		return null;
	}	
	
	@Transactional
	public List<RuleInputDevice> findRuleInputDeviceByDeviceId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<RuleInputDevice> ruleInputDevices = new ArrayList<RuleInputDevice>();
		try {
			List<?> ruleInputDeviceList = ruleInputDeviceDao.findByQueryParams("findRuleInputDeviceByDeviceId",
					queryParameters,page);
			for (Iterator<?> iterator = ruleInputDeviceList.iterator(); iterator
					.hasNext();) {
				RuleInputDevice ruleInputDevice = (RuleInputDevice) iterator.next();
				ruleInputDevices.add(ruleInputDevice);
			}
			return ruleInputDevices;
		} catch (Exception e) {
			logger.error("Error getting RuleInputDevices list.", e);
		}
		return null;
	}
	
	@Transactional
	public List<RuleInputDevice> findAllRuleInputDevices(Page page){
		
		logger.debug("In findAllRuleInputDevices(Page page)");
		try {
			return ruleInputDeviceDao.findAll(page, "findAllRuleInputDevicesByPaging");
		} catch (Exception e) {
			logger.error("Error getting RuleInputDevices list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return ruleInputDeviceDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	

}
