package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.EventRegisterDAO;
import com.sudosmith.aptus.model.EventRegister;


@Repository("eventRegisterDao")
public class EventRegisterDAOImpl extends GenericDAOImpl<EventRegister, Long>
implements EventRegisterDAO {

	public EventRegisterDAOImpl(){
		super(EventRegister.class);
	}
}
