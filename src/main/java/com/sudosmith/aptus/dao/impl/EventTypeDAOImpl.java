package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.EventTypeDAO;
import com.sudosmith.aptus.model.EventType;

@Repository("eventTypeDao")
public class EventTypeDAOImpl extends GenericDAOImpl<EventType, Long>
implements EventTypeDAO {

	public EventTypeDAOImpl(){
		super(EventType.class);
	}

}
