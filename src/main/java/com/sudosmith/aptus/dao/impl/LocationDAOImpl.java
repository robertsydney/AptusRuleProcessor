package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.LocationDAO;
import com.sudosmith.aptus.model.Location;

@Repository("locationDao")
public class LocationDAOImpl extends GenericDAOImpl<Location, Long>
implements LocationDAO {
	
	public LocationDAOImpl(){
		super(Location.class);
	}

}
