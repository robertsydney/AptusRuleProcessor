/**
 * 
 */
package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.SupportedDeviceDAO;
import com.sudosmith.aptus.model.SupportedDevice;

/**
 *
 */
@Repository("deviceDao")
public class SupportedDAOImpl extends GenericDAOImpl<SupportedDevice, Long>
		implements SupportedDeviceDAO {

	public SupportedDAOImpl(){
		super(SupportedDevice.class);
	}
}
