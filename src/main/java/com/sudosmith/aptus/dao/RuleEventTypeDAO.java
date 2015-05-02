package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.RuleEventType;

@Component("ruleEventTypeDao")
public interface RuleEventTypeDAO extends GenericDAO<RuleEventType, Serializable> {

}
