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
@Table(name = "facility_site")
@NamedQueries({
@NamedQuery(name = "findHospitalSiteByCommonSearch", query = "SELECT site FROM FacilitySite site WHERE site.siteName LIKE :queryString  OR site.siteAddress1 like :queryString or site.siteAddress2 like :queryString"),
@NamedQuery(name="findAllHospitalSitesByPaging" , query="from FacilitySite")})
public class FacilitySite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5710788377494329352L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "site_name")
	private String siteName;
	
	@Column(name="site_long_msg")
	private String siteLongMsg;
	
	@Column(name="site_short_msg")
	private String siteShortMsg;
	
	@Column(name = "site_address1")
	private String siteAddress1;
	
	@Column(name = "site_address2")
	private String siteAddress2;
	
	@Column(name = "city")
	private String City;
	
	@Column(name = "state")
	private String State;
	
	@Column(name = "postcode")
	private String Postcode;
	
	@Column(name = "phone")
	private String Phone;
		
	@Column(name = "email")
	private String Email;

	@Column(name = "facility_id")
	private int facilityId;
	
	public FacilitySite() {

	}


	public FacilitySite(int id, int facilityId, String siteName,
			String siteLongMsg, String siteShortMsg, String siteAddress1,
			String siteAddress2, String city, String state, String postcode,
			String phone, String email) {
		super();
		this.id = id;
		this.facilityId = facilityId;
		this.siteName = siteName;
		this.siteLongMsg = siteLongMsg;
		this.siteShortMsg = siteShortMsg;
		this.siteAddress1 = siteAddress1;
		this.siteAddress2 = siteAddress2;
		City = city;
		State = state;
		Postcode = postcode;
		Phone = phone;
		Email = email;
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
	 * @return the facilityId
	 */
	public int getFacilityId() {
		return facilityId;
	}


	/**
	 * @param facilityId the facilityId to set
	 */
	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}


	/**
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}


	/**
	 * @param siteName the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}


	/**
	 * @return the siteLongMsg
	 */
	public String getSiteLongMsg() {
		return siteLongMsg;
	}


	/**
	 * @param siteLongMsg the siteLongMsg to set
	 */
	public void setSiteLongMsg(String siteLongMsg) {
		this.siteLongMsg = siteLongMsg;
	}


	/**
	 * @return the siteShortMsg
	 */
	public String getSiteShortMsg() {
		return siteShortMsg;
	}


	/**
	 * @param siteShortMsg the siteShortMsg to set
	 */
	public void setSiteShortMsg(String siteShortMsg) {
		this.siteShortMsg = siteShortMsg;
	}


	/**
	 * @return the siteAddress1
	 */
	public String getSiteAddress1() {
		return siteAddress1;
	}


	/**
	 * @param siteAddress1 the siteAddress1 to set
	 */
	public void setSiteAddress1(String siteAddress1) {
		this.siteAddress1 = siteAddress1;
	}


	/**
	 * @return the siteAddress2
	 */
	public String getSiteAddress2() {
		return siteAddress2;
	}


	/**
	 * @param siteAddress2 the siteAddress2 to set
	 */
	public void setSiteAddress2(String siteAddress2) {
		this.siteAddress2 = siteAddress2;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return City;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		City = city;
	}


	/**
	 * @return the state
	 */
	public String getState() {
		return State;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		State = state;
	}


	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return Postcode;
	}


	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		Postcode = postcode;
	}


	/**
	 * @return the phone
	 */
	public String getPhone() {
		return Phone;
	}


	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		Phone = phone;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	

}