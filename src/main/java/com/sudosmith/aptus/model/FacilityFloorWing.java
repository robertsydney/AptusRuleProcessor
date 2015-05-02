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
@Table(name = "facility_floor_wing")
@NamedQueries({
@NamedQuery(name = "findFloorWingByCommonSearch", query = "SELECT wing FROM FacilityFloorWing wing WHERE wing.wingName LIKE :queryString"),
@NamedQuery(name = "findFloorWingByFloorId", query = "SELECT wing FROM FacilityFloorWing wing WHERE wing.floorId = :queryString"),
@NamedQuery(name="findAllFloorWingsByPaging" , query="from FacilityFloorWing")})
public class FacilityFloorWing implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4880133892905870687L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;


	@Column(name = "wing_name")
	private String wingName;
	
	@Column(name = "is_map_uploaded")
	private boolean mapUploaded;
	
	@Column(name = "map_code")
	private String mapCode;
	
	@Column(name = "wing_long_msg")
	private String wingLongMsg;
	
	@Column(name = "wing_short_msg")
	private String wingShortMsg;
	
	@Column(name = "facility_building_floor_id")
	private int floorId;
	
	
	@Transient
	private Page page;
	
	public FacilityFloorWing() {

	}

	public FacilityFloorWing(int id, int floorId, String wingName, boolean mapUploaded,
			String mapCode, String wingLongMsg, String wingShortMsg, Page page) {
		super();
		this.id = id;
		this.floorId = floorId;
		this.wingName = wingName;
		this.mapUploaded = mapUploaded;
		this.mapCode = mapCode;
		this.wingLongMsg = wingLongMsg;
		this.wingShortMsg = wingShortMsg;
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
	 * @return the wingName
	 */
	public String getWingName() {
		return wingName;
	}

	/**
	 * @param wingName the wingName to set
	 */
	public void setWingName(String wingName) {
		this.wingName = wingName;
	}

	/**
	 * @return the mapUploaded
	 */
	public boolean isMapUploaded() {
		return mapUploaded;
	}

	/**
	 * @param mapUploaded the mapUploaded to set
	 */
	public void setMapUploaded(boolean mapUploaded) {
		this.mapUploaded = mapUploaded;
	}

	/**
	 * @return the mapCode
	 */
	public String getMapCode() {
		return mapCode;
	}

	/**
	 * @param mapCode the mapCode to set
	 */
	public void setMapCode(String mapCode) {
		this.mapCode = mapCode;
	}

	/**
	 * @return the wingLongMsg
	 */
	public String getWingLongMsg() {
		return wingLongMsg;
	}

	/**
	 * @param wingLongMsg the wingLongMsg to set
	 */
	public void setWingLongMsg(String wingLongMsg) {
		this.wingLongMsg = wingLongMsg;
	}

	/**
	 * @return the wingShortMsg
	 */
	public String getWingShortMsg() {
		return wingShortMsg;
	}

	/**
	 * @param wingShortMsg the wingShortMsg to set
	 */
	public void setWingShortMsg(String wingShortMsg) {
		this.wingShortMsg = wingShortMsg;
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
