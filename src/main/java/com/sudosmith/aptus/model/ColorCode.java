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
@Table(name = "color_code")
@NamedQueries({
@NamedQuery(name = "findColorCodeByCommonSearch", query = "SELECT color FROM ColorCode color WHERE color.colorName LIKE :queryString"),
@NamedQuery(name = "findColorCodeByColorName", query = "SELECT color FROM ColorCode color WHERE color.colorName= :queryString"),
@NamedQuery(name="findAllColorCodesByPaging" , query="from ColorCode")})
public class ColorCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3804190296605692859L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "color_name")
	private String colorName;

	@Column(name = "color_code")
	private String colorCode;
	
	@Transient
	private Page page;
	
	public ColorCode() {

	}

	public ColorCode(int id, String colorName, String colorCode) {
		super();
		this.id = id;
		this.colorName = colorName;
		this.colorCode = colorCode;
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
	 * @return the colorName
	 */
	public String getColorName() {
		return colorName;
	}

	/**
	 * @param colorName the colorName to set
	 */
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	/**
	 * @return the colorCode
	 */
	public String getColorCode() {
		return colorCode;
	}

	/**
	 * @param colorCode the colorCode to set
	 */
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
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
