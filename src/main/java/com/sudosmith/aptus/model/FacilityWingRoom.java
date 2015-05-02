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
@Table(name = "facility_wing_room")
@NamedQueries({
@NamedQuery(name = "findWingRoomByCommonSearch", query = "SELECT room FROM FacilityWingRoom room WHERE room.roomNumber LIKE :queryString"),
@NamedQuery(name = "findWingRoomByWingId", query = "SELECT room FROM FacilityWingRoom room WHERE room.wingId = :queryString"),
@NamedQuery(name="findAllWingRoomsByPaging" , query="from FacilityWingRoom")})
public class FacilityWingRoom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8630354924017148557L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "room_number")
	private String roomNumber;
	
	@Column(name = "room_long_msg")
	private String roomLongMsg;
	
	@Column(name = "room_short_msg")
	private String roomShortMsg;
	
	@Column(name = "facility_floor_wing_id")
	private int wingId;
	
	@Transient
	private Page page;
	
	public FacilityWingRoom() {

	}

	public FacilityWingRoom(int id, int wingId, String roomNumber, String roomLongMsg,
			String roomShortMsg, Page page) {
		super();
		this.id = id;
		this.wingId = wingId;
		this.roomNumber = roomNumber;
		this.roomLongMsg = roomLongMsg;
		this.roomShortMsg = roomShortMsg;
		this.page = page;
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
	 * @return the wingId
	 */
	public int getWingId() {
		return wingId;
	}

	/**
	 * @param wingId the wingId to set
	 */
	public void setWingId(int wingId) {
		this.wingId = wingId;
	}

	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the roomLongMsg
	 */
	public String getRoomLongMsg() {
		return roomLongMsg;
	}

	/**
	 * @param roomLongMsg the roomLongMsg to set
	 */
	public void setRoomLongMsg(String roomLongMsg) {
		this.roomLongMsg = roomLongMsg;
	}

	/**
	 * @return the roomShortMsg
	 */
	public String getRoomShortMsg() {
		return roomShortMsg;
	}

	/**
	 * @param roomShortMsg the roomShortMsg to set
	 */
	public void setRoomShortMsg(String roomShortMsg) {
		this.roomShortMsg = roomShortMsg;
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
