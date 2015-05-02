package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.ModuleDevice;


@Component("moduleDeviceDao")
public interface ModuleDeviceDAO extends GenericDAO<ModuleDevice, Serializable> {

}
