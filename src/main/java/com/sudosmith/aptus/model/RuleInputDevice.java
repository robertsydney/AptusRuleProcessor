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
import javax.persistence.Transient;

import com.sudosmith.aptus.pagination.Page;


@Entity
@Table(name = "rule_input_device")
@NamedQueries({
@NamedQuery(name = "findRuleInputDeviceByCommonSearch", query = "SELECT inputDevice FROM RuleInputDevice inputDevice WHERE inputDevice.deviceId LIKE :queryString"),
@NamedQuery(name = "findRuleInputDeviceByDeviceId", query = "SELECT inputDevice FROM RuleInputDevice inputDevice WHERE inputDevice.deviceId= :queryString"),
@NamedQuery(name = "findRuleInputDeviceByRuleDeviceId", query = "SELECT inputDevice FROM RuleInputDevice inputDevice WHERE inputDevice.ruleId= :queryString1 AND inputDevice.deviceId= :queryString2"),
@NamedQuery(name="findAllRuleInputDevicesByPaging" , query="from RuleInputDevice")
})
public class RuleInputDevice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 223961932403675863L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "rule_id")
	private int ruleId;

	@Column(name = "device_id")
	private int deviceId;	
	
	@Transient
	private Page page;
	

	public RuleInputDevice()
	{
	
	}


	public RuleInputDevice(int id, int ruleId, int deviceId) {
		super();
		this.id = id;
		this.ruleId = ruleId;
		this.deviceId = deviceId;
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
	 * @return the ruleId
	 */
	public int getRuleId() {
		return ruleId;
	}


	/**
	 * @param ruleId the ruleId to set
	 */
	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}


	/**
	 * @return the deviceId
	 */
	public int getDeviceId() {
		return deviceId;
	}


	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}


	/**
	 * @return the page
	 */
	public Page getPage() {
		return page;
	}


	/**
	 * @param page the page to set
	 */
	public void setPage(Page page) {
		this.page = page;
	}
	
	
	
}
