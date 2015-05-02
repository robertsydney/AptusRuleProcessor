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
@Table(name = "event_type")
@NamedQueries({
@NamedQuery(name = "findEventTypeByCommonSearch", query = "SELECT event FROM EventType event WHERE event.eventName LIKE :queryString"),
@NamedQuery(name = "findEventTypeByName", query = "SELECT event FROM EventType event WHERE event.eventName LIKE :queryString"),
@NamedQuery(name="findAllEventTypesByPaging" , query="from EventType")})
public class EventType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7365025532871391220L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_description")
	private String eventDescription;
	
	@Column(name = "event_color_code")
	private String eventColorCode;
	
	@Column(name = "event_priority")
	private int eventPriority;
	
	@Column(name = "short_msg")
	private String shortMsg;	
	
	@Column(name = "long_msg")
	private String longMsg;	
	
	@Column(name = "cancel_msg")
	private String cancelMsg;
	
	@Column(name = "boolean_msg")
	private boolean booleanMsg;
	
	@Column(name = "is_dementia")
	private boolean dementia;
	
	@Column(name = "event_vol_level")
	private String eventVolLevel;	
		
	@Transient
	private Page page;
	
	public EventType() {

	}

	public EventType(int id, String eventName, String eventDescription,
			String eventColorCode, int eventPriority, String shortMsg,
			String longMsg, String cancelMsg, boolean booleanMsg,
			boolean dementia, String eventVolLevel) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventColorCode = eventColorCode;
		this.eventPriority = eventPriority;
		this.shortMsg = shortMsg;
		this.longMsg = longMsg;
		this.cancelMsg = cancelMsg;
		this.booleanMsg = booleanMsg;
		this.dementia = dementia;
		this.eventVolLevel = eventVolLevel;
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
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}

	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	/**
	 * @return the eventColorCode
	 */
	public String getEventColorCode() {
		return eventColorCode;
	}

	/**
	 * @param eventColorCode the eventColorCode to set
	 */
	public void setEventColorCode(String eventColorCode) {
		this.eventColorCode = eventColorCode;
	}

	/**
	 * @return the eventPriority
	 */
	public int getEventPriority() {
		return eventPriority;
	}

	/**
	 * @param eventPriority the eventPriority to set
	 */
	public void setEventPriority(int eventPriority) {
		this.eventPriority = eventPriority;
	}

	/**
	 * @return the shortMsg
	 */
	public String getShortMsg() {
		return shortMsg;
	}

	/**
	 * @param shortMsg the shortMsg to set
	 */
	public void setShortMsg(String shortMsg) {
		this.shortMsg = shortMsg;
	}

	/**
	 * @return the longMsg
	 */
	public String getLongMsg() {
		return longMsg;
	}

	/**
	 * @param longMsg the longMsg to set
	 */
	public void setLongMsg(String longMsg) {
		this.longMsg = longMsg;
	}

	/**
	 * @return the cancelMsg
	 */
	public String getCancelMsg() {
		return cancelMsg;
	}

	/**
	 * @param cancelMsg the cancelMsg to set
	 */
	public void setCancelMsg(String cancelMsg) {
		this.cancelMsg = cancelMsg;
	}

	/**
	 * @return the booleanMsg
	 */
	public boolean isBooleanMsg() {
		return booleanMsg;
	}

	/**
	 * @param booleanMsg the booleanMsg to set
	 */
	public void setBooleanMsg(boolean booleanMsg) {
		this.booleanMsg = booleanMsg;
	}

	/**
	 * @return the dementia
	 */
	public boolean isDementia() {
		return dementia;
	}

	/**
	 * @param dementia the dementia to set
	 */
	public void setDementia(boolean dementia) {
		this.dementia = dementia;
	}

	/**
	 * @return the eventVolLevel
	 */
	public String getEventVolLevel() {
		return eventVolLevel;
	}

	/**
	 * @param eventVolLevel the eventVolLevel to set
	 */
	public void setEventVolLevel(String eventVolLevel) {
		this.eventVolLevel = eventVolLevel;
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
