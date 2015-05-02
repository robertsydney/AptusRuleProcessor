package com.sudosmith.aptus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "location")
@NamedQuery(name = "findLocationByLocationIds", query = "SELECT location FROM Location location WHERE location.siteId =:queryString1 and location.buildingId = :queryString2 and location.floorId = :queryString3 and location.wingId = :queryString4 and location.roomId = :queryString5")
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6135361333365906886L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "facility_site_id")
	private int siteId;
	
	@Column(name = "facility_site_building_id")
	private int buildingId;
	
	@Column(name = "facility_building_floor_id")
	private int floorId;
	
	@Column(name = "facility_floor_wing_id")
	private int wingId;
	
	@Column(name = "facility_wing_room_id")
	private int roomId;
	
	public Location() {

	}

	public Location(int id, int siteId, int buildingId, int floorId,
			int wingId, int roomId) {
		super();
		this.id = id;
		this.siteId = siteId;
		this.buildingId = buildingId;
		this.floorId = floorId;
		this.wingId = wingId;
		this.roomId = roomId;
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
	 * @return the siteId
	 */
	public int getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the buildingId
	 */
	public int getBuildingId() {
		return buildingId;
	}

	/**
	 * @param buildingId the buildingId to set
	 */
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	/**
	 * @return the floorId
	 */
	public int getFloorId() {
		return floorId;
	}

	/**
	 * @param floorId the floorId to set
	 */
	public void setFloorId(int floorId) {
		this.floorId = floorId;
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
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	
}
