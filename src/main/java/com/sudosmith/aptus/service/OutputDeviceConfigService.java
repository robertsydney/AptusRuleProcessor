package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.OutputDeviceConfig;
import com.sudosmith.aptus.pagination.Page;

public interface OutputDeviceConfigService {

    public OutputDeviceConfig addConfig(OutputDeviceConfig config) throws Exception;
	
	public OutputDeviceConfig editConfig(OutputDeviceConfig config) throws Exception;
	
	public void deleteConfig(int configId) throws Exception;
	
	public List<OutputDeviceConfig> findAllConfigs() throws Exception;
	
	public List<OutputDeviceConfig> findAllConfigs(Page page);
	
	public OutputDeviceConfig findConfigById(int configId) throws Exception;
	
	public List<OutputDeviceConfig> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<OutputDeviceConfig> findByDeviceId(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();	

}
