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
@Table(name = "facility_site_building")
@NamedQueries({
@NamedQuery(name = "findSiteBuildingByCommonSearch", query = "SELECT building FROM FacilitySiteBuilding building WHERE building.buildingName LIKE :queryString"),
@NamedQuery(name = "findSiteBuildingBySiteId", query = "SELECT building FROM FacilitySiteBuilding building WHERE building.siteId = :queryString"),
@NamedQuery(name="findAllSiteBuildingsByPaging" , query="from FacilitySiteBuilding")})
public class FacilitySiteBuilding implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 206622749752891142L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "building_name")
	private String buildingName;
	
	@Column(name = "building_long_msg")
	private String buildingLongMsg;
	
	@Column(name = "building_short_msg")
	private String buildingShortMsg;
	
	@Column(name = "facility_site_id")
	private int siteId;
	
	@Transient
	private Page page;
	
	public FacilitySiteBuilding() {

	}

	public FacilitySiteBuilding(int id, int siteId, String buildingName,
			String buildingLongMsg, String buildingShortMsg, Page page) {
		super();
		this.id = id;
		this.siteId = siteId;
		this.buildingName = buildingName;
		this.buildingLongMsg = buildingLongMsg;
		this.buildingShortMsg = buildingShortMsg;
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
	 * @return the buildingName
	 */
	public String getBuildingName() {
		return buildingName;
	}

	/**
	 * @param buildingName the buildingName to set
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	/**
	 * @return the buildingLongMsg
	 */
	public String getBuildingLongMsg() {
		return buildingLongMsg;
	}

	/**
	 * @param buildingLongMsg the buildingLongMsg to set
	 */
	public void setBuildingLongMsg(String buildingLongMsg) {
		this.buildingLongMsg = buildingLongMsg;
	}

	/**
	 * @return the buildingShortMsg
	 */
	public String getBuildingShortMsg() {
		return buildingShortMsg;
	}

	/**
	 * @param buildingShortMsg the buildingShortMsg to set
	 */
	public void setBuildingShortMsg(String buildingShortMsg) {
		this.buildingShortMsg = buildingShortMsg;
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
