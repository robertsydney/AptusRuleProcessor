package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.RuleEscGroupOutputDeviceDAO;
import com.sudosmith.aptus.model.RuleEscGroupOutputDevice;

@Repository("ruleOutputDeviceDao")
public class RuleEscGroupOutputDeviceDAOImpl extends GenericDAOImpl<RuleEscGroupOutputDevice, Long>
implements RuleEscGroupOutputDeviceDAO {

	public RuleEscGroupOutputDeviceDAOImpl(){
		super(RuleEscGroupOutputDevice.class);
	}

}
