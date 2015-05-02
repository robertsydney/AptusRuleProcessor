package com.sudosmith.aptus.service;

import java.util.List;

import com.sudosmith.aptus.model.Facility;


public interface FacilityService {
	
    public Facility addFacility(Facility facility) throws Exception;
	
	public Facility editFacility(Facility facility) throws Exception;
	
	public List<Facility> findAllFacilitys() throws Exception;
	
	public Facility findFacilityById(int facilityId) throws Exception;

}
