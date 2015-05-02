package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.ModuleDAO;
import com.sudosmith.aptus.model.Module;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.ModuleService;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService{

	private Logger logger = Logger.getLogger(ModuleServiceImpl.class);

	@Autowired
	private ModuleDAO moduleDao;

	@Transactional
	public Module addModule(Module module) throws Exception {
		logger.debug("in addModule()");
		try {
			return moduleDao.create(module);
		} catch (Exception e) {
			logger.error("Error adding module details", e);
		}
		return null;
	}

	@Transactional
	public Module editModule(Module module) throws Exception {

		logger.debug("In editModule()");
		logger.info("Module  Name - " + module.getAssignedName());
		try {
			return moduleDao.merge(module);
		} catch (Exception e) {
			logger.error("Error updaing module details", e);
		}
		return null;

	}

	@Transactional
	public void deleteModule(int moduleId) throws Exception {
		logger.debug("In deleteModule()");
		try {
			Module module = moduleDao.findById(moduleId);
			if (module != null) {
				moduleDao.delete(module);
			}
		} catch (Exception e) {
			logger.error("Error removing Module by id - " + moduleId, e);
		}
	}

	@Transactional
	public List<Module> findAllModules() throws Exception {
		logger.debug("In findAllModules()");
		try {
			return moduleDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting Modules list.", e);
		}
		return null;
	}

	@Transactional
	public Module findModuleById(int moduleId) throws Exception {
		logger.debug("In findModuleById()");
		try {
			return moduleDao.findById(moduleId);
		} catch (Exception e) {
			logger.error("Error in finding Module by id - " + moduleId, e);
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
	public List<Module> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Module> modules = new ArrayList<Module>();
		try {
			List<?> moduleList = moduleDao.findByQueryParams("findModuleByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = moduleList.iterator(); iterator
					.hasNext();) {
				Module module = (Module) iterator.next();
				modules.add(module);
			}
			return modules;
		} catch (Exception e) {
			logger.error("Error getting Modules list.", e);
		}
		return null;
	}
	

	@Transactional
	public List<Module> findModuleByName(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Module> modules = new ArrayList<Module>();
		try {
			List<?> moduleList = moduleDao.findByQueryParams("findModuleByName",
					queryParameters,page);
			for (Iterator<?> iterator = moduleList.iterator(); iterator
					.hasNext();) {
				Module module = (Module) iterator.next();
				modules.add(module);
			}
			return modules;
		} catch (Exception e) {
			logger.error("Error getting Modules list.", e);
		}
		return null;
	}	
	
	
	@Transactional
	public List<Module> findModuleByAdapterId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Module> modules = new ArrayList<Module>();
		try {
			List<?> moduleList = moduleDao.findByQueryParams("findModuleByAdapterId",
					queryParameters,page);
			for (Iterator<?> iterator = moduleList.iterator(); iterator
					.hasNext();) {
				Module module = (Module) iterator.next();
				modules.add(module);
			}
			return modules;
		} catch (Exception e) {
			logger.error("Error getting Modules list.", e);
		}
		return null;
	}		
	
	
	@Transactional
	public List<Module> findAllModules(Page page){
		
		logger.debug("In findAllModules(Page page)");
		try {
			return moduleDao.findAll(page, "findAllModulesByPaging");
		} catch (Exception e) {
			logger.error("Error getting Modules list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	//@Override
	public int totalNoOfRecord() {
		try {
			return moduleDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	

}
