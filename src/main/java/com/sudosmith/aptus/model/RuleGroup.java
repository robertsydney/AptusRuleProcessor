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
@Table(name = "rule_group")
@NamedQueries({
@NamedQuery(name = "findRuleGroupByCommonSearch", query = "SELECT group FROM RuleGroup group WHERE group.ruleGroupName LIKE :queryString"),
@NamedQuery(name="findAllRuleGroupsByPaging" , query="from RuleGroup")})
public class RuleGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6031580742095607687L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "rule_group_name")
	private String ruleGroupName;

	@Column(name = "rule_group_desc")
	private String ruleGroupDesc;
	
	@Column(name = "rule_group_color")
	private String ruleGroupColor;
	
	@Column(name = "is_enable")
	private boolean enable;
	
	@Transient
	private Page page;
	
	public RuleGroup() {

	}

	public RuleGroup(int id, String ruleGroupName, String ruleGroupDesc,
			String ruleGroupColor, boolean enable) {
		super();
		this.id = id;
		this.ruleGroupName = ruleGroupName;
		this.ruleGroupDesc = ruleGroupDesc;
		this.ruleGroupColor = ruleGroupColor;
		this.enable = enable;
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
	 * @return the ruleGroupName
	 */
	public String getRuleGroupName() {
		return ruleGroupName;
	}

	/**
	 * @param ruleGroupName the ruleGroupName to set
	 */
	public void setRuleGroupName(String ruleGroupName) {
		this.ruleGroupName = ruleGroupName;
	}

	/**
	 * @return the ruleGroupDesc
	 */
	public String getRuleGroupDesc() {
		return ruleGroupDesc;
	}

	/**
	 * @param ruleGroupDesc the ruleGroupDesc to set
	 */
	public void setRuleGroupDesc(String ruleGroupDesc) {
		this.ruleGroupDesc = ruleGroupDesc;
	}

	/**
	 * @return the ruleGroupColor
	 */
	public String getRuleGroupColor() {
		return ruleGroupColor;
	}

	/**
	 * @param ruleGroupColor the ruleGroupColor to set
	 */
	public void setRuleGroupColor(String ruleGroupColor) {
		this.ruleGroupColor = ruleGroupColor;
	}

	/**
	 * @return the enable
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
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
