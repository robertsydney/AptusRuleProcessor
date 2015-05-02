package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.Module;
import com.sudosmith.aptus.pagination.Page;


public interface ModuleService {
	
    public Module addModule(Module module) throws Exception;
	
	public Module editModule(Module module) throws Exception;
	
	public void deleteModule(int moduleId) throws Exception;
	
	public List<Module> findAllModules() throws Exception;
	
	public List<Module> findAllModules(Page page);
	
	public Module findModuleById(int moduleId) throws Exception;
	
	public List<Module> findByQueryParams(Map<String, Object> queryParameters, Page page);	
	
	public List<Module> findModuleByName(Map<String, Object> queryParameters, Page page);	
	
	public List<Module> findModuleByAdapterId(Map<String, Object> queryParameters, Page page);	
	
	public int totalNoOfRecord();	

}
