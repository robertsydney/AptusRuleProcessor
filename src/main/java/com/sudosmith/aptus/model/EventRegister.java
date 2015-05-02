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
@Table(name = "event_register")
@NamedQueries({
@NamedQuery(name = "findEventRegisterByCommonSearch", query = "SELECT register FROM EventRegister register WHERE register.moduleDeviceId LIKE :queryString"),
@NamedQuery(name = "findEventRegisterByDeviceId", query = "SELECT register FROM EventRegister register WHERE register.moduleDeviceId=:queryString"),
@NamedQuery(name = "findEventRegisterByRequestId", query = "SELECT register FROM EventRegister register WHERE register.requestId=:queryString"),
@NamedQuery(name="findAllEventRegistersByPaging" , query="from EventRegister")})
public class EventRegister implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5968798299916673246L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "request_id")
	private String requestId;
	
	@Column(name = "request_sequence_id")
	private String requestSequenceId;
	
	@Column(name = "module_device_id")
	private int moduleDeviceId;
	
	@Column(name = "event_id")
	private int eventId;
	
	@Column(name = "created_at")
	private String createdAt;
	
	@Column(name = "is_active")
	private boolean active;

	public EventRegister() {
		
	}

	public EventRegister(int id, String requestId, String requestSequenceId,
			int moduleDeviceId, int eventId, String createdAt, boolean active) {
		super();
		this.id = id;
		this.requestId = requestId;
		this.requestSequenceId = requestSequenceId;
		this.moduleDeviceId = moduleDeviceId;
		this.eventId = eventId;
		this.createdAt = createdAt;
		this.active = active;
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
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the requestSequenceId
	 */
	public String getRequestSequenceId() {
		return requestSequenceId;
	}

	/**
	 * @param requestSequenceId the requestSequenceId to set
	 */
	public void setRequestSequenceId(String requestSequenceId) {
		this.requestSequenceId = requestSequenceId;
	}

	/**
	 * @return the moduleDeviceId
	 */
	public int getModuleDeviceId() {
		return moduleDeviceId;
	}

	/**
	 * @param moduleDeviceId the moduleDeviceId to set
	 */
	public void setModuleDeviceId(int moduleDeviceId) {
		this.moduleDeviceId = moduleDeviceId;
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
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
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

}
