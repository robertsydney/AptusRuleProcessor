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

/**
 * @author SIMRAN
 *
 */
@Entity
@Table(name = "facility_building_floor")
@NamedQueries({
@NamedQuery(name = "findBuildingFloorByCommonSearch", query = "SELECT floor FROM FacilityBuildingFloor floor WHERE floor.floorName LIKE :queryString"),
@NamedQuery(name = "findBuildingFloorByBuildingId", query = "SELECT floor FROM FacilityBuildingFloor floor WHERE floor.buildingId = :queryString"),
@NamedQuery(name="findAllBuildingFloorsByPaging" , query="from FacilityBuildingFloor")})
public class FacilityBuildingFloor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7799835914715962050L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "floor_name")
	private String floorName;
	
	@Column(name = "floor_long_msg")
	private String floorLongMsg;
	
	@Column(name = "floor_short_msg")
	private String floorShortMsg;
	
	@Column(name = "facility_site_building_id")
	private int buildingId;

	
	@Transient
	private Page page;
	
	public FacilityBuildingFloor() {

	}

	public FacilityBuildingFloor(int id, int buildingId, String floorName,
			String floorLongMsg, String floorShortMsg, Page page) {
		super();
		this.id = id;
		this.buildingId = buildingId;
		this.floorName = floorName;
		this.floorLongMsg = floorLongMsg;
		this.floorShortMsg = floorShortMsg;
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
	 * @return the floorName
	 */
	public String getFloorName() {
		return floorName;
	}

	/**
	 * @param floorName the floorName to set
	 */
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	/**
	 * @return the floorLongMsg
	 */
	public String getFloorLongMsg() {
		return floorLongMsg;
	}

	/**
	 * @param floorLongMsg the floorLongMsg to set
	 */
	public void setFloorLongMsg(String floorLongMsg) {
		this.floorLongMsg = floorLongMsg;
	}

	/**
	 * @return the floorShortMsg
	 */
	public String getFloorShortMsg() {
		return floorShortMsg;
	}

	/**
	 * @param floorShortMsg the floorShortMsg to set
	 */
	public void setFloorShortMsg(String floorShortMsg) {
		this.floorShortMsg = floorShortMsg;
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
