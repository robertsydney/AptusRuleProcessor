package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.RuleEscDAO;
import com.sudosmith.aptus.model.RuleEsc;

@Repository("ruleEscDao")
public class RuleEscDAOImpl extends GenericDAOImpl<RuleEsc, Long>
implements RuleEscDAO {

	public RuleEscDAOImpl(){
		super(RuleEsc.class);
	}

}
