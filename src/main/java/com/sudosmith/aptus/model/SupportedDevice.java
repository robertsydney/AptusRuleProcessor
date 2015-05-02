/**
 * 
 */
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
 *
 */
@Entity
@Table(name = "supported_device")
@NamedQueries({
@NamedQuery(name = "findSupportedDeviceByCommonSearch", query = "SELECT device FROM SupportedDevice device WHERE device.deviceName LIKE :queryString  OR device.deviceType like :queryString or device.deviceAdapter like :queryString or device.deviceVendor like :queryString"),
@NamedQuery(name = "findSupportedDeviceByTypeOutput", query = "SELECT device FROM SupportedDevice device WHERE device.deviceType='Output'"),
@NamedQuery(name = "findSupportedDeviceByTypeInput", query = "SELECT device FROM SupportedDevice device WHERE device.deviceType='Input'"),
@NamedQuery(name = "findSupportedDeviceByDeviceAdapter", query = "SELECT device FROM SupportedDevice device WHERE device.deviceAdapter = :queryString"),
@NamedQuery(name = "findSupportedDeviceByDeviceInput", query = "SELECT device FROM SupportedDevice device WHERE device.deviceType = 'Input' and device.id=:queryString "),
@NamedQuery(name = "findSupportedDeviceByDeviceOutput", query = "SELECT device FROM SupportedDevice device WHERE device.deviceType = 'Output' and device.id=:queryString "),
@NamedQuery(name="findAllDevicesByPaging" , query="from SupportedDevice")})

public class SupportedDevice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3311841083409025847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "device_name")
	private String deviceName;

	@Column(name = "device_type_io")
	private String deviceType;

	@Column(name = "device_adapter")
	private String deviceAdapter;

	@Column(name = "device_description")
	private String deviceDescription;

	@Column(name = "device_image")
	private String deviceImage;

	@Column(name = "device_vendor")
	private String deviceVendor;

	@Transient
	private Page page;

	public SupportedDevice() {

	}

	public SupportedDevice(int id, String deviceName, String deviceType,
			String deviceAdapter, String deviceDescription,
			String deviceImage, String deviceVendor) {
		super();
		this.id = id;
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.deviceAdapter = deviceAdapter;
		this.deviceDescription = deviceDescription;
		this.deviceImage = deviceImage;
		this.deviceVendor = deviceVendor;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName
	 *            the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the deviceType
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType
	 *            the deviceType to set
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the deviceAdapter
	 */
	public String getDeviceAdapter() {
		return deviceAdapter;
	}

	/**
	 * @param deviceAdapter
	 *            the deviceAdapter to set
	 */
	public void setDeviceAdapter(String deviceAdapter) {
		this.deviceAdapter = deviceAdapter;
	}


	/**
	 * @return the deviceDescription
	 */
	public String getDeviceDescription() {
		return deviceDescription;
	}

	/**
	 * @param deviceDescription
	 *            the deviceDescription to set
	 */
	public void setDeviceDescription(String deviceDescription) {
		this.deviceDescription = deviceDescription;
	}

	/**
	 * @return the deviceImage
	 */
	public String getDeviceImage() {
		return deviceImage;
	}

	/**
	 * @param deviceImage
	 *            the deviceImage to set
	 */
	public void setDeviceImage(String deviceImage) {
		this.deviceImage = deviceImage;
	}

	/**
	 * @return the deviceVendor
	 */
	public String getDeviceVendor() {
		return deviceVendor;
	}

	/**
	 * @param deviceVendor
	 *            the deviceVendor to set
	 */
	public void setDeviceVendor(String deviceVendor) {
		this.deviceVendor = deviceVendor;
	}

	/**
	 * @return the page
	 */
	public Page getPage() {
		if (this.page != null) {
			return this.page;
		} else {
			return new Page();
		}
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(Page page) {
		this.page = page;
	}
}
