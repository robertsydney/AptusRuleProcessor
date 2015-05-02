package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.ModuleDeviceDAO;
import com.sudosmith.aptus.model.ModuleDevice;



@Repository("moduleDeviceDao")
public class ModuleDeviceDAOImpl extends GenericDAOImpl<ModuleDevice, Long>
implements ModuleDeviceDAO {
	public ModuleDeviceDAOImpl(){
		super(ModuleDevice.class);
	}

}
