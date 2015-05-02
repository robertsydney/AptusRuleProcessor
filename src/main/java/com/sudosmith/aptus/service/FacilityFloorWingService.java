package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.FacilityFloorWing;
import com.sudosmith.aptus.pagination.Page;

public interface FacilityFloorWingService {
	
	public FacilityFloorWing addFloorWing(FacilityFloorWing floorWing) throws Exception;
	
	public FacilityFloorWing editFloorWing(FacilityFloorWing floorWing) throws Exception;
	
	public void deleteFloorWing(int floorWingId) throws Exception;
	
	public List<FacilityFloorWing> findAllFloorWings() throws Exception;
	
	public List<FacilityFloorWing> findAllFloorWings(Page page);
	
	public FacilityFloorWing findFloorWingById(int floorWingId) throws Exception;
	
	public List<FacilityFloorWing> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<FacilityFloorWing> findByFloorId(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();

}
