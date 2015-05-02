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
@Table(name = "rule_esc")
@NamedQueries({
@NamedQuery(name = "findRuleEscByCommonSearch", query = "SELECT esc FROM RuleEsc esc WHERE esc.ruleId LIKE :queryString"),
@NamedQuery(name = "findRuleEscByRuleId", query = "SELECT esc FROM RuleEsc esc WHERE esc.ruleId = :queryString"),
@NamedQuery(name="findAllRuleEscsByPaging" , query="from RuleEsc")})
public class RuleEsc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6169323856899152282L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "rule_id")
	private int ruleId;
	
	@Column(name = "esc_level")
	private int escLevel;
	
	@Column(name = "activate_at")
	private int activateAt;
	
	@Column(name = "esc_group_name")
	private String escGroupName;
	
	@Transient
	private Page page;
	
	public RuleEsc() {

	}

	public RuleEsc(int id, int ruleId, int escLevel, String escGroupName,
			int activateAt) {
		super();
		this.id = id;
		this.ruleId = ruleId;
		this.escLevel = escLevel;
		this.escGroupName = escGroupName;
		this.activateAt = activateAt;
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
	 * @return the escLevel
	 */
	public int getEscLevel() {
		return escLevel;
	}

	/**
	 * @param escLevel the escLevel to set
	 */
	public void setEscLevel(int escLevel) {
		this.escLevel = escLevel;
	}

	/**
	 * @return the escGroupName
	 */
	public String getEscGroupName() {
		return escGroupName;
	}

	/**
	 * @param escGroupName the escGroupName to set
	 */
	public void setEscGroupName(String escGroupName) {
		this.escGroupName = escGroupName;
	}

	/**
	 * @return the activateAt
	 */
	public int getActivateAt() {
		return activateAt;
	}

	/**
	 * @param activateAt the activateAt to set
	 */
	public void setActivateAt(int activateAt) {
		this.activateAt = activateAt;
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
