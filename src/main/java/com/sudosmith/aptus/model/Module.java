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
@Table(name = "module")
@NamedQueries({
@NamedQuery(name = "findModuleByCommonSearch", query = "SELECT module FROM Module module WHERE module.assignedName LIKE :queryString or module.moduleAddress like :queryString"),
@NamedQuery(name = "findModuleByName", query = "SELECT module FROM Module module WHERE module.assignedName = :queryString"),
@NamedQuery(name = "findModuleByAdapterId", query = "SELECT module FROM Module module WHERE module.adapterId = :queryString"),
@NamedQuery(name="findAllModulesByPaging" , query="from Module")
})
public class Module implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4861400123795834662L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "assigned_name")
	private String assignedName;

	@Column(name = "module_address")
	private String moduleAddress;
	
	@Column(name = "adapter_id")
	private int adapterId;
	
	@Column(name = "location_id")
	private int locationId;
	
	public Module()
	{
		
	}

	public Module(int id, String assignedName, String moduleAddress,
			int adapterId, int locationId) {
		super();
		this.id = id;
		this.assignedName = assignedName;
		this.moduleAddress = moduleAddress;
		this.adapterId = adapterId;
		this.locationId = locationId;
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
	 * @return the moduleAddress
	 */
	public String getModuleAddress() {
		return moduleAddress;
	}

	/**
	 * @param moduleAddress the moduleAddress to set
	 */
	public void setModuleAddress(String moduleAddress) {
		this.moduleAddress = moduleAddress;
	}

	/**
	 * @return the adapterId
	 */
	public int getAdapterId() {
		return adapterId;
	}

	/**
	 * @param adapterId the adapterId to set
	 */
	public void setAdapterId(int adapterId) {
		this.adapterId = adapterId;
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

	
}
