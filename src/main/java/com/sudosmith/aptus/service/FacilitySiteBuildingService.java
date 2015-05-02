package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.FacilitySiteBuilding;
import com.sudosmith.aptus.pagination.Page;

public interface FacilitySiteBuildingService {
	
	    public FacilitySiteBuilding addSiteBuilding(FacilitySiteBuilding siteBuilding) throws Exception;
		
		public FacilitySiteBuilding editSiteBuilding(FacilitySiteBuilding siteBuilding) throws Exception;
		
		public void deleteSiteBuilding(int siteBuildingId) throws Exception;
		
		public List<FacilitySiteBuilding> findAllSiteBuildings() throws Exception;
		
		public List<FacilitySiteBuilding> findAllSiteBuildings(Page page);
		
		public FacilitySiteBuilding findSiteBuildingById(int siteBuildingId) throws Exception;
		
		public List<FacilitySiteBuilding> findByQueryParams(Map<String, Object> queryParameters, Page page);
		
		public List<FacilitySiteBuilding> findBySiteId(Map<String, Object> queryParameters, Page page);
		
		public int totalNoOfRecord();

}
