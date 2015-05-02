package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.RuleInputDeviceDAO;
import com.sudosmith.aptus.model.RuleInputDevice;

@Repository("ruleInputDeviceDao")
public class RuleInputDeviceDAOImpl extends GenericDAOImpl<RuleInputDevice, Long>
implements RuleInputDeviceDAO {

	public RuleInputDeviceDAOImpl(){
		super(RuleInputDevice.class);
	}

}
