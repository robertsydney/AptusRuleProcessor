package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.Facility;

@Component("facilityDao")
public interface FacilityDAO extends GenericDAO<Facility, Serializable> {

}
