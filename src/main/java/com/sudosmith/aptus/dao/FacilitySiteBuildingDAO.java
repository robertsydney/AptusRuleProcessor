package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.FacilitySiteBuilding;

@Component("facilitySiteBuildingDao")
public interface FacilitySiteBuildingDAO extends GenericDAO<FacilitySiteBuilding, Serializable>{

}
