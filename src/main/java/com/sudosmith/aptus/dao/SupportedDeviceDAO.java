/**
 * 
 */
package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.SupportedDevice;

/**
 *
 */
@Component("deviceDao")
public interface SupportedDeviceDAO extends GenericDAO<SupportedDevice, Serializable> {

}
