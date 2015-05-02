package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.RuleEsc;

@Component("ruleEscDao")
public interface RuleEscDAO extends GenericDAO<RuleEsc, Serializable> {

}
