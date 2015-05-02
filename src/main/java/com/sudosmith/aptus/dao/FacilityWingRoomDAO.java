package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.FacilityWingRoom;

@Component("facilityWingRoomDao")
public interface FacilityWingRoomDAO extends GenericDAO<FacilityWingRoom, Serializable> {

}
