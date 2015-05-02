package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.FacilityFloorWingDAO;
import com.sudosmith.aptus.model.FacilityFloorWing;

@Repository("facilityFloorWingDao")
public class FacilityFloorWingDAOImpl extends GenericDAOImpl<FacilityFloorWing, Long>
implements  FacilityFloorWingDAO {

	public FacilityFloorWingDAOImpl(){
		super(FacilityFloorWing.class);
	}
}
