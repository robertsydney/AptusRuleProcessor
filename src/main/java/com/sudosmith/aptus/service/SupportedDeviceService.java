/**
 * 
 */
package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.SupportedDevice;
import com.sudosmith.aptus.pagination.Page;

/**

 *
 */
public interface SupportedDeviceService {

	
	public SupportedDevice addDevice(SupportedDevice device) throws Exception;
	
	public SupportedDevice editDevice(SupportedDevice device) throws Exception;
	
	public void deleteDevice(int deviceId) throws Exception;
	
	public List<SupportedDevice> findAllDevices() throws Exception;
	
	public List<SupportedDevice> findAllDevices(Page page);

	public List<SupportedDevice> findAllOutputDevices(Page page);
	
	public List<SupportedDevice> findAllInputDevices(Page page);	
	
	public SupportedDevice findDeviceById(int deviceId) throws Exception;
	
	public List<SupportedDevice> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<SupportedDevice> findSupportedDeviceByDeviceAdapter(Map<String, Object> queryParameters, Page page);
	
	public List<SupportedDevice> findSupportedDeviceByDeviceInput(Map<String, Object> queryParameters, Page page);
	
	public List<SupportedDevice> findSupportedDeviceByDeviceOutput(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();
	
}
