package com.sudosmith.aptus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facility")
public class Facility implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4230212086581055279L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "facility_name")
	private String orgName;

	@Column(name = "address1")
	private String Address1;
	
	@Column(name = "address2")
	private String Address2;
	
	@Column(name = "city")
	private String City;
	
	@Column(name = "state")
	private String State;
	
	@Column(name = "postcode")
	private String Postcode;
	
	@Column(name = "phone")
	private String Phone;
	
	@Column(name = "website")
	private String Website;
	
	@Column(name = "email")
	private String Email;
	

	public Facility() {

	}


	public Facility(int id, String orgName, String address1, String address2,
			String city, String state, String postcode, String phone,
			String website, String email) {
		super();
		this.id = id;
		this.orgName = orgName;
		Address1 = address1;
		Address2 = address2;
		City = city;
		State = state;
		Postcode = postcode;
		Phone = phone;
		Website = website;
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
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}


	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return Address1;
	}


	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		Address1 = address1;
	}


	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return Address2;
	}


	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		Address2 = address2;
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
	 * @return the website
	 */
	public String getWebsite() {
		return Website;
	}


	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		Website = website;
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
