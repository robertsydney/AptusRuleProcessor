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
@Table(name = "module_input_message")
@NamedQueries({
@NamedQuery(name ="findModuleInputMessageByCommonSearch", query = "SELECT message FROM ModuleInputMessage message WHERE message.longMsg LIKE :queryString or message.shortMsg like :queryString"),
@NamedQuery(name ="findModuleInputMessageByInputId", query = "SELECT message FROM ModuleInputMessage message WHERE message.moduleInputId = :queryString "),
@NamedQuery(name ="findAllModuleInputMessagesByPaging" , query="from ModuleInputMessage")
})
public class ModuleInputMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3964023629335265284L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "long_msg")
	private String longMsg;
	
	@Column(name = "short_msg")
	private String shortMsg;	
	
	@Column(name = "boolean_msg")
	private boolean booleanMsg;	
	
	@Column(name = "cancel_msg")
	private String cancelMsg;
	
	@Column(name = "module_input_id")
	private int moduleInputId;	
	
	public ModuleInputMessage()
	{
		
	}

	public ModuleInputMessage(int id, String longMsg, String shortMsg,
			boolean booleanMsg, String cancelMsg, int moduleInputId) {
		super();
		this.id = id;
		this.longMsg = longMsg;
		this.shortMsg = shortMsg;
		this.booleanMsg = booleanMsg;
		this.cancelMsg = cancelMsg;
		this.moduleInputId = moduleInputId;
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
	 * @return the moduleInputId
	 */
	public int getModuleInputId() {
		return moduleInputId;
	}

	/**
	 * @param moduleInputId the moduleInputId to set
	 */
	public void setModuleInputId(int moduleInputId) {
		this.moduleInputId = moduleInputId;
	}
		
}
