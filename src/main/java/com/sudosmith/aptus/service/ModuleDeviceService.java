package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.ModuleDevice;
import com.sudosmith.aptus.pagination.Page;


public interface ModuleDeviceService {
	
    public ModuleDevice addModuleDevice(ModuleDevice moduleDevice) throws Exception;
	
	public ModuleDevice editModuleDevice(ModuleDevice moduleDevice) throws Exception;
	
	public void deleteModuleDevice(int moduleDeviceId) throws Exception;
	
	public List<ModuleDevice> findAllModuleDevices() throws Exception;
	
	public List<ModuleDevice> findAllModuleDevices(Page page);
	
	public ModuleDevice findModuleDeviceById(int moduleDeviceId) throws Exception;
	
	public List<ModuleDevice> findByQueryParams(Map<String, Object> queryParameters, Page page);	
	
	public List<ModuleDevice> findModuleDeviceByModuleId(Map<String, Object> queryParameters, Page page);
	
	public List<ModuleDevice> findModuleDeviceByDeviceId(Map<String, Object> queryParameters, Page page);	
	
	public List<ModuleDevice> findModuleDeviceByLocationId(Map<String, Object> queryParameters, Page page);	
	
	public int totalNoOfRecord();		
	
}
