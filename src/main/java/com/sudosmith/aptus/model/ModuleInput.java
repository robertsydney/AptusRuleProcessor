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
@Table(name = "module_input")
@NamedQueries({
@NamedQuery(name ="findModuleInputByCommonSearch", query = "SELECT input FROM ModuleInput input WHERE input.input LIKE :queryString or input.eventId like :queryString"),
@NamedQuery(name ="findModuleInputByModuleDeviceId" , query="SELECT input FROM ModuleInput input WHERE input.moduleDeviceId = :queryString"),
@NamedQuery(name ="findModuleInputByModuleDeviceEventId" , query="SELECT input FROM ModuleInput input WHERE input.moduleDeviceId = :queryString1 AND input.eventId = :queryString2"),
@NamedQuery(name ="findAllModuleInputsByPaging" , query="from ModuleInput")
})
public class ModuleInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8750105767682787401L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "input")
	private String input;			

	@Column(name = "event_id")
	private int eventId;
	
	@Column(name = "module_device_id")
	private int moduleDeviceId;	
	
    public ModuleInput()
    {
    	
    }

	public ModuleInput(int id, String input, int eventId, int moduleDeviceId) {
		super();
		this.id = id;
		this.input = input;
		this.eventId = eventId;
		this.moduleDeviceId = moduleDeviceId;
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
	 * @return the input
	 */
	public String getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(String input) {
		this.input = input;
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


	
}
