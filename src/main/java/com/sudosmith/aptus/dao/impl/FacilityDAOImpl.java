package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.FacilityDAO;
import com.sudosmith.aptus.model.Facility;

@Repository("facilityDao")
public class FacilityDAOImpl extends GenericDAOImpl<Facility, Long>
implements FacilityDAO {
	
	public FacilityDAOImpl(){
		super(Facility.class);
	}

}
