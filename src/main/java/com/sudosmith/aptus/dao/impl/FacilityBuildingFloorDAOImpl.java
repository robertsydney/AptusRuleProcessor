package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.FacilityBuildingFloorDAO;
import com.sudosmith.aptus.model.FacilityBuildingFloor;

@Repository("facilityBuildingFloorDao")
public class FacilityBuildingFloorDAOImpl extends GenericDAOImpl<FacilityBuildingFloor, Long>
implements  FacilityBuildingFloorDAO {
	
	public FacilityBuildingFloorDAOImpl(){
		super(FacilityBuildingFloor.class);
	}

}
