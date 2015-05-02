package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.FacilitySiteBuildingDAO;
import com.sudosmith.aptus.model.FacilitySiteBuilding;

@Repository("facilitySiteBuildingDao")
public class FacilitySiteBuildingDAOImpl extends GenericDAOImpl<FacilitySiteBuilding, Long>
implements  FacilitySiteBuildingDAO {
	
	public FacilitySiteBuildingDAOImpl(){
		super(FacilitySiteBuilding.class);
	}

}
