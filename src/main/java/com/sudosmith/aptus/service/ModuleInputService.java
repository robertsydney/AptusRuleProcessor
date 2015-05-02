package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.ModuleInput;
import com.sudosmith.aptus.pagination.Page;

public interface ModuleInputService {
	
    public ModuleInput addModuleInput(ModuleInput moduleInput) throws Exception;
	
	public ModuleInput editModuleInput(ModuleInput moduleInput) throws Exception;
	
	public void deleteModuleInput(int moduleInputId) throws Exception;
	
	public List<ModuleInput> findAllModuleInputs() throws Exception;
	
	public List<ModuleInput> findAllModuleInputs(Page page);
	
	public ModuleInput findModuleInputById(int moduleInputId) throws Exception;
	
	public List<ModuleInput> findByQueryParams(Map<String, Object> queryParameters, Page page);		
	
	public List<ModuleInput> findModuleInputByModuleDeviceId(Map<String, Object> queryParameters, Page page);
	
	public List<ModuleInput> findModuleInputByModuleDeviceEventId(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();			

}
