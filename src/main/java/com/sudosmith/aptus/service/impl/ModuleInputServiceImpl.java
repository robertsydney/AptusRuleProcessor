package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.ModuleInputDAO;
import com.sudosmith.aptus.model.ModuleInput;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.ModuleInputService;

@Service("moduleInputService")
public class ModuleInputServiceImpl implements ModuleInputService{
	
	private Logger logger = Logger.getLogger(ModuleInputServiceImpl.class);

	@Autowired
	private ModuleInputDAO moduleInputDao;

	@Transactional
	public ModuleInput addModuleInput(ModuleInput moduleInput) throws Exception {
		logger.debug("in addModuleInput()");
		try {
			return moduleInputDao.create(moduleInput);
		} catch (Exception e) {
			logger.error("Error adding moduleInput details", e);
		}
		return null;
	}

	@Transactional
	public ModuleInput editModuleInput(ModuleInput moduleInput) throws Exception {

		logger.debug("In editModuleInput()");
		logger.info("ModuleInput  EventId - " + moduleInput.getEventId());
		try {
			return moduleInputDao.merge(moduleInput);
		} catch (Exception e) {
			logger.error("Error updaing moduleInput details", e);
		}
		return null;

	}

	@Transactional
	public void deleteModuleInput(int moduleInputId) throws Exception {
		logger.debug("In deleteModuleInput()");
		try {
			ModuleInput moduleInput = moduleInputDao.findById(moduleInputId);
			if (moduleInput != null) {
				moduleInputDao.delete(moduleInput);
			}
		} catch (Exception e) {
			logger.error("Error removing ModuleInput by id - " + moduleInputId, e);
		}
	}

	@Transactional
	public List<ModuleInput> findAllModuleInputs() throws Exception {
		logger.debug("In findAllModuleInputs()");
		try {
			return moduleInputDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting ModuleInputs list.", e);
		}
		return null;
	}

	@Transactional
	public ModuleInput findModuleInputById(int moduleInputId) throws Exception {
		logger.debug("In findModuleInputById()");
		try {
			return moduleInputDao.findById(moduleInputId);
		} catch (Exception e) {
			logger.error("Error in finding ModuleInput by id - " + moduleInputId, e);
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
	public List<ModuleInput> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<ModuleInput> moduleInputs = new ArrayList<ModuleInput>();
		try {
			List<?> moduleInputList = moduleInputDao.findByQueryParams("findModuleInputByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = moduleInputList.iterator(); iterator
					.hasNext();) {
				ModuleInput moduleInput = (ModuleInput) iterator.next();
				moduleInputs.add(moduleInput);
			}
			return moduleInputs;
		} catch (Exception e) {
			logger.error("Error getting ModuleInputs list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<ModuleInput> findModuleInputByModuleDeviceId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findModuleInputByModuleDeviceId(String queryName, Map<String, Object> queryParameters)");
		List<ModuleInput> moduleInputs = new ArrayList<ModuleInput>();
		try {
			List<?> moduleInputList = moduleInputDao.findByQueryParams("findModuleInputByModuleDeviceId",
					queryParameters,page);
			for (Iterator<?> iterator = moduleInputList.iterator(); iterator
					.hasNext();) {
				ModuleInput moduleInput = (ModuleInput) iterator.next();
				moduleInputs.add(moduleInput);
			}
			return moduleInputs;
		} catch (Exception e) {
			logger.error("Error getting ModuleInputs list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<ModuleInput> findModuleInputByModuleDeviceEventId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findModuleInputByModuleDeviceId(String queryName, Map<String, Object> queryParameters)");
		List<ModuleInput> moduleInputs = new ArrayList<ModuleInput>();
		try {
			List<?> moduleInputList = moduleInputDao.findByQueryParams("findModuleInputByModuleDeviceEventId",
					queryParameters,page);
			for (Iterator<?> iterator = moduleInputList.iterator(); iterator
					.hasNext();) {
				ModuleInput moduleInput = (ModuleInput) iterator.next();
				moduleInputs.add(moduleInput);
			}
			return moduleInputs;
		} catch (Exception e) {
			logger.error("Error getting ModuleInputs list.", e);
		}
		return null;
	}	
	
	
	@Transactional
	public List<ModuleInput> findAllModuleInputs(Page page){
		
		logger.debug("In findAllModuleInputs(Page page)");
		try {
			return moduleInputDao.findAll(page, "findAllModuleInputsByPaging");
		} catch (Exception e) {
			logger.error("Error getting ModuleInputs list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return moduleInputDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}		

}
