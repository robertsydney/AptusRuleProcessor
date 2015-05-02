package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.Rule;

@Component("ruleDao")
public interface RuleDAO extends GenericDAO<Rule, Serializable> {

}
