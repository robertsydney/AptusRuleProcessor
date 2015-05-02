package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.RuleGroup;

@Component("ruleGroupDao")
public interface RuleGroupDAO extends GenericDAO<RuleGroup, Serializable> {

}
