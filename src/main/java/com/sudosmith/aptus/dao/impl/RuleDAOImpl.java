package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.RuleDAO;
import com.sudosmith.aptus.model.Rule;

@Repository("ruleDao")
public class RuleDAOImpl extends GenericDAOImpl<Rule, Long>
implements RuleDAO {

	public RuleDAOImpl(){
		super(Rule.class);
	}
}
