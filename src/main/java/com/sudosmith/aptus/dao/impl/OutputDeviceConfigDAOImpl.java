package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.OutputDeviceConfigDAO;
import com.sudosmith.aptus.model.OutputDeviceConfig;

@Repository("outputDeviceConfigDao")
public class OutputDeviceConfigDAOImpl extends GenericDAOImpl<OutputDeviceConfig, Long>
implements OutputDeviceConfigDAO {
	
	public OutputDeviceConfigDAOImpl(){
		super(OutputDeviceConfig.class);
	}

}
