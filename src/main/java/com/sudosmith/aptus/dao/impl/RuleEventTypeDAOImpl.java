package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.RuleEventTypeDAO;
import com.sudosmith.aptus.model.RuleEventType;

@Repository("ruleEventTypeDao")
public class RuleEventTypeDAOImpl extends GenericDAOImpl<RuleEventType, Long>
implements RuleEventTypeDAO {

	public RuleEventTypeDAOImpl(){
		super(RuleEventType.class);
	}

}
