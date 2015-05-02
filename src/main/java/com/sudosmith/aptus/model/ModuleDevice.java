package com.sudosmith.aptus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "module_device")
@NamedQueries({
@NamedQuery(name ="findModuleDeviceByCommonSearch", query = "SELECT device FROM ModuleDevice device WHERE device.moduleId LIKE :queryString or device.supportedDeviceId like :queryString"),
@NamedQuery(name ="findModuleDeviceByModuleId", query = "SELECT device FROM ModuleDevice device WHERE device.moduleId = :queryString"),
@NamedQuery(name ="findModuleDeviceByDeviceId", query = "SELECT device FROM ModuleDevice device WHERE device.supportedDeviceId = :queryString"),
@NamedQuery(name ="findModuleDeviceByLocationId", query = "SELECT device FROM ModuleDevice device WHERE device.locationId = :queryString"),
@NamedQuery(name ="findAllModuleDevicesByPaging" , query="from ModuleDevice")
})
public class ModuleDevice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1693592148975268074L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "location_id")
	private int locationId;	
	
	@Column(name = "assigned_name")
	private String assignedName;
	
	@Column(name = "is_active")
	private boolean active;	
	
	@Column(name = "module_id")
	private int moduleId;
	
	@Column(name = "supported_device_id")
	private int supportedDeviceId;	
	
	@Column(name = "module_device_address")
	private String moduleDeviceAddress;	
		
	
	public ModuleDevice()
	{
		
	}


	public ModuleDevice(int id, int locationId, String assignedName,
			boolean active, int moduleId, int supportedDeviceId,
			String moduleDeviceAddress) {
		super();
		this.id = id;
		this.locationId = locationId;
		this.assignedName = assignedName;
		this.active = active;
		this.moduleId = moduleId;
		this.supportedDeviceId = supportedDeviceId;
		this.moduleDeviceAddress = moduleDeviceAddress;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the locationId
	 */
	public int getLocationId() {
		return locationId;
	}


	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


	/**
	 * @return the assignedName
	 */
	public String getAssignedName() {
		return assignedName;
	}


	/**
	 * @param assignedName the assignedName to set
	 */
	public void setAssignedName(String assignedName) {
		this.assignedName = assignedName;
	}


	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}


	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}


	/**
	 * @return the moduleId
	 */
	public int getModuleId() {
		return moduleId;
	}


	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}


	/**
	 * @return the supportedDeviceId
	 */
	public int getSupportedDeviceId() {
		return supportedDeviceId;
	}


	/**
	 * @param supportedDeviceId the supportedDeviceId to set
	 */
	public void setSupportedDeviceId(int supportedDeviceId) {
		this.supportedDeviceId = supportedDeviceId;
	}


	/**
	 * @return the moduleDeviceAddress
	 */
	public String getModuleDeviceAddress() {
		return moduleDeviceAddress;
	}


	/**
	 * @param moduleDeviceAddress the moduleDeviceAddress to set
	 */
	public void setModuleDeviceAddress(String moduleDeviceAddress) {
		this.moduleDeviceAddress = moduleDeviceAddress;
	}

	

}
