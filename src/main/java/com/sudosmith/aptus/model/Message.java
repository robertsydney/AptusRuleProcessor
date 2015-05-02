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
@Table(name = "message")
@NamedQueries({
@NamedQuery(name = "findMessageByCommonSearch", query = "SELECT message FROM Message message WHERE message.requestId LIKE :queryString"),
@NamedQuery(name = "findMessageByRequestId", query = "SELECT message FROM Message message WHERE message.requestId = :queryString"),
@NamedQuery(name="findAllMessagesByPaging" , query="from Message")
})
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1367938391942349639L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "request_id")
	private String requestId;

	@Column(name = "lm")
	private String lm;	
	
	@Column(name = "sm")
	private String sm;	
	
	@Column(name = "bm")
	private String bm;
	
    public Message()
    {
    	
    }

	public Message(int id, String requestId, String lm, String sm, String bm) {
		super();
		this.id = id;
		this.requestId = requestId;
		this.lm = lm;
		this.sm = sm;
		this.bm = bm;
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
	 * @return the lm
	 */
	public String getLm() {
		return lm;
	}

	/**
	 * @param lm the lm to set
	 */
	public void setLm(String lm) {
		this.lm = lm;
	}

	/**
	 * @return the sm
	 */
	public String getSm() {
		return sm;
	}

	/**
	 * @param sm the sm to set
	 */
	public void setSm(String sm) {
		this.sm = sm;
	}

	/**
	 * @return the bm
	 */
	public String getBm() {
		return bm;
	}

	/**
	 * @param bm the bm to set
	 */
	public void setBm(String bm) {
		this.bm = bm;
	}

}
