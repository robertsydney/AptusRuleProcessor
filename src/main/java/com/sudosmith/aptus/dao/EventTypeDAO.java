package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.EventType;


@Component("eventTypeDao")
public interface EventTypeDAO extends GenericDAO<EventType, Serializable> {

}
