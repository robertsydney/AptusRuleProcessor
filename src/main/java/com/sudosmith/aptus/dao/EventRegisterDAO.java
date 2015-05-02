package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.EventRegister;

@Component("eventRegisterDao")
public interface EventRegisterDAO extends GenericDAO<EventRegister,Serializable> {

}
