package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.RuleInputDevice;

@Component("ruleInputDeviceDao")
public interface RuleInputDeviceDAO extends GenericDAO<RuleInputDevice, Serializable> {

}
