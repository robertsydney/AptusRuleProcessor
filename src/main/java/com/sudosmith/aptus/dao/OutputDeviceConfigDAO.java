package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.OutputDeviceConfig;

@Component("outputDeviceConfigDao")
public interface OutputDeviceConfigDAO extends GenericDAO<OutputDeviceConfig, Serializable> {

}
