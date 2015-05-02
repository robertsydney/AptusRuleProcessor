package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.RuleGroupDAO;
import com.sudosmith.aptus.model.RuleGroup;

@Repository("ruleGroupDao")
public class RuleGroupDAOImpl extends GenericDAOImpl<RuleGroup, Long>
implements RuleGroupDAO {

	public RuleGroupDAOImpl(){
		super(RuleGroup.class);
	}

}
