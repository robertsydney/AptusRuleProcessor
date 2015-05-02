package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.FacilityBuildingFloor;
import com.sudosmith.aptus.pagination.Page;

public interface FacilityBuildingFloorService {
	
	    public FacilityBuildingFloor addBuildingFloor(FacilityBuildingFloor buildingFloor) throws Exception;
		
		public FacilityBuildingFloor editBuildingFloor(FacilityBuildingFloor buildingFloor) throws Exception;
		
		public void deleteBuildingFloor(int buildingFloorId) throws Exception;
		
		public List<FacilityBuildingFloor> findAllBuildingFloors() throws Exception;
		
		public List<FacilityBuildingFloor> findAllBuildingFloors(Page page);
		
		public FacilityBuildingFloor findBuildingFloorById(int buildingFloorId) throws Exception;
		
		public List<FacilityBuildingFloor> findByQueryParams(Map<String, Object> queryParameters, Page page);
		
		public List<FacilityBuildingFloor> findByBuildingId(Map<String, Object> queryParameters, Page page);
		
		public int totalNoOfRecord();

}
