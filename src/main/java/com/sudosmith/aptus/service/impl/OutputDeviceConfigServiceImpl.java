package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.OutputDeviceConfigDAO;
import com.sudosmith.aptus.model.OutputDeviceConfig;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.OutputDeviceConfigService;

@Service("outputDeviceConfigService")
public class OutputDeviceConfigServiceImpl implements  OutputDeviceConfigService {
	
	private Logger logger = Logger.getLogger(OutputDeviceConfigServiceImpl.class);

	@Autowired
	private OutputDeviceConfigDAO configDao;

	@Transactional
	public OutputDeviceConfig addConfig(OutputDeviceConfig config) throws Exception {
		logger.debug("in addOutputDeviceConfig()");
		try {
			return configDao.create(config);
		} catch (Exception e) {
			logger.error("Error adding config details", e);
		}
		return null;
	}

	@Transactional
	public OutputDeviceConfig editConfig(OutputDeviceConfig config) throws Exception {

		logger.debug("In editOutputDeviceConfig()");
		logger.info("OutputDevice Id - " + config.getDeviceId());
		try {
			return configDao.merge(config);
		} catch (Exception e) {
			logger.error("Error updaing config details", e);
		}
		return null;

	}

	@Transactional
	public void deleteConfig(int configId) throws Exception {
		logger.debug("In deleteOutputDeviceConfig()");
		try {
			OutputDeviceConfig config = configDao.findById(configId);
			if (config != null) {
				configDao.delete(config);
			}
		} catch (Exception e) {
			logger.error("Error removing OutputDeviceConfig by id - " + configId, e);
		}
	}

	@Transactional
	public List<OutputDeviceConfig> findAllConfigs() throws Exception {
		logger.debug("In findAllOutputDeviceConfigs()");
		try {
			return configDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting OutputDeviceConfigs list.", e);
		}
		return null;
	}

	@Transactional
	public OutputDeviceConfig findConfigById(int configId) throws Exception {
		logger.debug("In findOutputDeviceConfigById()");
		try {
			return configDao.findById(configId);
		} catch (Exception e) {
			logger.error("Error in finding OutputDeviceConfig by id - " + configId, e);
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
	public List<OutputDeviceConfig> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<OutputDeviceConfig> configs = new ArrayList<OutputDeviceConfig>();
		try {
			List<?> configList = configDao.findByQueryParams("findOutputDeviceConfigByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = configList.iterator(); iterator
					.hasNext();) {
				OutputDeviceConfig config = (OutputDeviceConfig) iterator.next();
				configs.add(config);
			}
			return configs;
		} catch (Exception e) {
			logger.error("Error getting OutputDeviceConfigs list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<OutputDeviceConfig> findByDeviceId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<Integer, Object> queryParameters)");
		List<OutputDeviceConfig> configs = new ArrayList<OutputDeviceConfig>();
		try {
			List<?> configList = configDao.findByQueryParams("findOutputDeviceConfigByDeviceId",
					queryParameters,page);
			for (Iterator<?> iterator = configList.iterator(); iterator
					.hasNext();) {
				OutputDeviceConfig config = (OutputDeviceConfig) iterator.next();
				configs.add(config);
			}
			return configs;
		} catch (Exception e) {
			logger.error("Error getting OutputDeviceConfigs list.", e);
		}
		return null;
	}
	
	
	
	@Transactional
	public List<OutputDeviceConfig> findAllConfigs(Page page){
		
		logger.debug("In findAllOutputDeviceConfigs(Page page)");
		try {
			return configDao.findAll(page, "findAllOutputDeviceConfigsByPaging");
		} catch (Exception e) {
			logger.error("Error getting OutputDeviceConfigs list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return configDao.totalNoOfRecord();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return 0;
	}		

}
