package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.Request;

@Component("requestDao")
public interface RequestDAO extends GenericDAO<Request, Serializable> {

}
