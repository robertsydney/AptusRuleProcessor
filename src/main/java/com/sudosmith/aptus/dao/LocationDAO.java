package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.Location;

@Component("locationDao")
public interface LocationDAO extends GenericDAO<Location, Serializable> {

}
