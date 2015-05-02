package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.FacilityWingRoomDAO;
import com.sudosmith.aptus.model.FacilityWingRoom;

@Repository("facilityWingRoomDao")
public class FacilityWingRoomDAOImpl extends GenericDAOImpl<FacilityWingRoom, Long>
implements  FacilityWingRoomDAO {
	
	public FacilityWingRoomDAOImpl(){
		super(FacilityWingRoom.class);
	}

}
