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
@Table(name = "output_device_config")
@NamedQueries({
@NamedQuery(name = "findOutputDeviceConfigByCommonSearch", query = "SELECT config FROM OutputDeviceConfig config WHERE config.longMsg LIKE :queryString"),
@NamedQuery(name = "findOutputDeviceConfigByDeviceId", query = "SELECT config FROM OutputDeviceConfig config WHERE config.deviceId = :queryString"),
@NamedQuery(name="findAllOutputDeviceConfigsByPaging" , query="from OutputDeviceConfig")})
public class OutputDeviceConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1320113117106726820L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "device_id")
	private int deviceId;	
	
	@Column(name = "is_long_msg")
	private boolean longMsg;
	
	@Column(name = "is_short_msg")
	private boolean shortMsg;
	
	@Column(name = "is_cancel_msg")
	private boolean cancelMsg;
	
	@Column(name = "is_ack")
	private boolean ack;
	
	@Column(name = "is_vol")
	private boolean vol;
	
	@Column(name = "is_color")
	private boolean color;
	
	@Column(name = "is_bm")
	private boolean bm;
	
	@Transient
	private Page page;

	public OutputDeviceConfig() {

	}

	public OutputDeviceConfig(int id, int deviceId, boolean longMsg,
			boolean shortMsg, boolean cancelMsg, boolean ack, boolean vol,
			boolean color, boolean bm) {
		super();
		this.id = id;
		this.deviceId = deviceId;
		this.longMsg = longMsg;
		this.shortMsg = shortMsg;
		this.cancelMsg = cancelMsg;
		this.ack = ack;
		this.vol = vol;
		this.color = color;
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
	 * @return the longMsg
	 */
	public boolean isLongMsg() {
		return longMsg;
	}

	/**
	 * @param longMsg the longMsg to set
	 */
	public void setLongMsg(boolean longMsg) {
		this.longMsg = longMsg;
	}

	/**
	 * @return the shortMsg
	 */
	public boolean isShortMsg() {
		return shortMsg;
	}

	/**
	 * @param shortMsg the shortMsg to set
	 */
	public void setShortMsg(boolean shortMsg) {
		this.shortMsg = shortMsg;
	}

	/**
	 * @return the cancelMsg
	 */
	public boolean isCancelMsg() {
		return cancelMsg;
	}

	/**
	 * @param cancelMsg the cancelMsg to set
	 */
	public void setCancelMsg(boolean cancelMsg) {
		this.cancelMsg = cancelMsg;
	}

	/**
	 * @return the ack
	 */
	public boolean isAck() {
		return ack;
	}

	/**
	 * @param ack the ack to set
	 */
	public void setAck(boolean ack) {
		this.ack = ack;
	}

	/**
	 * @return the vol
	 */
	public boolean isVol() {
		return vol;
	}

	/**
	 * @param vol the vol to set
	 */
	public void setVol(boolean vol) {
		this.vol = vol;
	}

	/**
	 * @return the color
	 */
	public boolean isColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(boolean color) {
		this.color = color;
	}

	/**
	 * @return the bm
	 */
	public boolean isBm() {
		return bm;
	}

	/**
	 * @param bm the bm to set
	 */
	public void setBm(boolean bm) {
		this.bm = bm;
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
