package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.ModuleDeviceDAO;
import com.sudosmith.aptus.model.ModuleDevice;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.ModuleDeviceService;


@Service("moduleDeviceService")
public class ModuleDeviceServiceImpl implements ModuleDeviceService{

	private Logger logger = Logger.getLogger(ModuleDeviceServiceImpl.class);

	@Autowired
	private ModuleDeviceDAO moduleDeviceDao;

	@Transactional
	public ModuleDevice addModuleDevice(ModuleDevice moduleDevice) throws Exception {
		logger.debug("in addModuleDevice()");
		try {
			return moduleDeviceDao.create(moduleDevice);
		} catch (Exception e) {
			logger.error("Error adding moduleDevice details", e);
		}
		return null;
	}

	@Transactional
	public ModuleDevice editModuleDevice(ModuleDevice moduleDevice) throws Exception {

		logger.debug("In editModuleDevice()");
		logger.info("ModuleDevice  moduleId - " + moduleDevice.getModuleId());
		try {
			return moduleDeviceDao.merge(moduleDevice);
		} catch (Exception e) {
			logger.error("Error updaing moduleDevice details", e);
		}
		return null;

	}

	@Transactional
	public void deleteModuleDevice(int moduleDeviceId) throws Exception {
		logger.debug("In deleteModuleDevice()");
		try {
			ModuleDevice moduleDevice = moduleDeviceDao.findById(moduleDeviceId);
			if (moduleDevice != null) {
				moduleDeviceDao.delete(moduleDevice);
			}
		} catch (Exception e) {
			logger.error("Error removing ModuleDevice by id - " + moduleDeviceId, e);
		}
	}

	@Transactional
	public List<ModuleDevice> findAllModuleDevices() throws Exception {
		logger.debug("In findAllModuleDevices()");
		try {
			return moduleDeviceDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting ModuleDevices list.", e);
		}
		return null;
	}

	@Transactional
	public ModuleDevice findModuleDeviceById(int moduleDeviceId) throws Exception {
		logger.debug("In findModuleDeviceById()");
		try {
			return moduleDeviceDao.findById(moduleDeviceId);
		} catch (Exception e) {
			logger.error("Error in finding ModuleDevice by id - " + moduleDeviceId, e);
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
	public List<ModuleDevice> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<ModuleDevice> moduleDevices = new ArrayList<ModuleDevice>();
		try {
			List<?> moduleDeviceList = moduleDeviceDao.findByQueryParams("findModuleDeviceByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = moduleDeviceList.iterator(); iterator
					.hasNext();) {
				ModuleDevice moduleDevice = (ModuleDevice) iterator.next();
				moduleDevices.add(moduleDevice);
			}
			return moduleDevices;
		} catch (Exception e) {
			logger.error("Error getting ModuleDevices list.", e);
		}
		return null;
	}
	

	@Transactional
	public List<ModuleDevice> findModuleDeviceByModuleId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<ModuleDevice> moduleDevices = new ArrayList<ModuleDevice>();
		try {
			List<?> moduleDeviceList = moduleDeviceDao.findByQueryParams("findModuleDeviceByModuleId",
					queryParameters,page);
			for (Iterator<?> iterator = moduleDeviceList.iterator(); iterator
					.hasNext();) {
				ModuleDevice moduleDevice = (ModuleDevice) iterator.next();
				moduleDevices.add(moduleDevice);
			}
			return moduleDevices;
		} catch (Exception e) {
			logger.error("Error getting ModuleDevices list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<ModuleDevice> findModuleDeviceByDeviceId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<ModuleDevice> moduleDevices = new ArrayList<ModuleDevice>();
		try {
			List<?> moduleDeviceList = moduleDeviceDao.findByQueryParams("findModuleDeviceByDeviceId",
					queryParameters,page);
			for (Iterator<?> iterator = moduleDeviceList.iterator(); iterator
					.hasNext();) {
				ModuleDevice moduleDevice = (ModuleDevice) iterator.next();
				moduleDevices.add(moduleDevice);
			}
			return moduleDevices;
		} catch (Exception e) {
			logger.error("Error getting ModuleDevices list.", e);
		}
		return null;
	}	
	
	
	@Transactional
	public List<ModuleDevice> findModuleDeviceByLocationId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<ModuleDevice> moduleDevices = new ArrayList<ModuleDevice>();
		try {
			List<?> moduleDeviceList = moduleDeviceDao.findByQueryParams("findModuleDeviceByLocationId",
					queryParameters,page);
			for (Iterator<?> iterator = moduleDeviceList.iterator(); iterator
					.hasNext();) {
				ModuleDevice moduleDevice = (ModuleDevice) iterator.next();
				moduleDevices.add(moduleDevice);
			}
			return moduleDevices;
		} catch (Exception e) {
			logger.error("Error getting ModuleDevices list.", e);
		}
		return null;
	}		
	
	
	@Transactional
	public List<ModuleDevice> findAllModuleDevices(Page page){
		
		logger.debug("In findAllModuleDevices(Page page)");
		try {
			return moduleDeviceDao.findAll(page, "findAllModuleDevicesByPaging");
		} catch (Exception e) {
			logger.error("Error getting ModuleDevices list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	//@Override
	public int totalNoOfRecord() {
		try {
			return moduleDeviceDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	

}
