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
@Table(name = "rule")
@NamedQueries({
@NamedQuery(name = "findRuleByCommonSearch", query = "SELECT rule FROM Rule rule WHERE rule.day LIKE :queryString or rule.eventStartTime like :queryString or rule.eventEndTime like :queryString"),
@NamedQuery(name = "findRuleByGroupId", query = "SELECT rule FROM Rule rule WHERE rule.ruleGroupId = :queryString"),
@NamedQuery(name = "findRuleByGroupIdTime", query = "SELECT rule FROM Rule rule WHERE rule.ruleGroupId = :queryString1 AND rule.eventStartTime = :queryString2"),
@NamedQuery(name = "findRuleByDayTime", query = "SELECT rule FROM Rule rule WHERE rule.day = :queryString1 AND rule.eventStartTime<= :queryString2 AND eventEndTime>= :queryString3"),
@NamedQuery(name = "findRuleByDay", query = "SELECT rule FROM Rule rule WHERE rule.day = :queryString"),
@NamedQuery(name="findAllRulesByPaging" , query="from Rule")
})
public class Rule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3323236577342111565L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "day")
	private int day;

	@Column(name = "auto_cancel")
	private int autoCancel;
	
	@Column(name = "rule_group_id")
	private int ruleGroupId;
	
	@Column(name = "repeat_interval")
	private int repeatInterval;
	
	@Column(name = "event_start_time")
	private String eventStartTime;
	
	@Column(name = "event_end_time")
	private String eventEndTime;
	
	@Transient
	private Page page;
	
	public Rule() {

	}

	public Rule(int id,int day,
			int autoCancel, int ruleGroupId, int repeatInterval,
			String eventStartTime, String eventEndTime, Page page) {
		super();
		this.id = id;
		this.day = day;
		this.autoCancel = autoCancel;
		this.ruleGroupId = ruleGroupId;
		this.repeatInterval = repeatInterval;
		this.eventStartTime = eventStartTime;
		this.eventEndTime = eventEndTime;
		this.page = page;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getAutoCancel() {
		return autoCancel;
	}

	public void setAutoCancel(int autoCancel) {
		this.autoCancel = autoCancel;
	}

	public int getRuleGroupId() {
		return ruleGroupId;
	}

	public void setRuleGroupId(int ruleGroupId) {
		this.ruleGroupId = ruleGroupId;
	}

	public int getRepeatInterval() {
		return repeatInterval;
	}

	public void setRepeatInterval(int repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public String getEventStartTime() {
		return eventStartTime;
	}

	public void setEventStartTime(String eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public String getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
