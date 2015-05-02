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
@Table(name = "rule_event_type")
@NamedQueries({
@NamedQuery(name = "findRuleEventTypeByCommonSearch", query = "SELECT eventType FROM RuleEventType eventType WHERE eventType.ruleId LIKE :queryString"),
@NamedQuery(name = "findRuleEventTypeByRuleEventId", query = "SELECT eventType FROM RuleEventType eventType WHERE eventType.ruleId =:queryString1 AND eventType.eventId =:queryString2"),
@NamedQuery(name="findAllRuleEventTypesByPaging" , query="from RuleEventType")
})
public class RuleEventType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6141637731926794071L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "rule_id")
	private int ruleId;

	@Column(name = "event_id")
	private int eventId;	
	
	@Transient
	private Page page;
	
	public RuleEventType(){
		
	}

	public RuleEventType(int id, int ruleId, int eventId) {
		super();
		this.id = id;
		this.ruleId = ruleId;
		this.eventId = eventId;
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
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
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
