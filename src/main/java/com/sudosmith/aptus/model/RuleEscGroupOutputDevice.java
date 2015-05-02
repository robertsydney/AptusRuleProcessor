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
@Table(name = "rule_esc_group_output_device")
@NamedQueries({
@NamedQuery(name = "findRuleEscGroupOutputDeviceByCommonSearch", query = "SELECT device FROM RuleEscGroupOutputDevice device WHERE device.deviceId LIKE :queryString"),
@NamedQuery(name = "findRuleEscGroupOutputDeviceByRuleId", query = "SELECT device FROM RuleEscGroupOutputDevice device WHERE device.ruleId = :queryString1 AND device.ruleEscId = :queryString2"),
@NamedQuery(name="findAllRuleEscGroupOutputDevicesByPaging" , query="from RuleEscGroupOutputDevice")})
public class RuleEscGroupOutputDevice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7866613490961276066L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "device_id")
	private int deviceId;	

	@Column(name = "rule_esc_id")
	private int ruleEscId;
	
	@Column(name = "rule_id")
	private int ruleId;
	
	@Transient
	private Page page;
	
	public RuleEscGroupOutputDevice() {

	}

	public RuleEscGroupOutputDevice(int id, int deviceId, int ruleEscId,
			int ruleId) {
		super();
		this.id = id;
		this.deviceId = deviceId;
		this.ruleEscId = ruleEscId;
		this.ruleId = ruleId;
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
	 * @return the escGroupId
	 */
	public int getRuleEscId() {
		return ruleEscId;
	}

	/**
	 * @param escGroupId the escGroupId to set
	 */
	public void setRuleEscId(int ruleEscId) {
		this.ruleEscId = ruleEscId;
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
