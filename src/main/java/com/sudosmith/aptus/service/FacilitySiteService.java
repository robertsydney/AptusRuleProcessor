package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.FacilitySite;
import com.sudosmith.aptus.pagination.Page;

public interface FacilitySiteService {
	
    public FacilitySite addFacilitySite(FacilitySite facilitySite) throws Exception;
	
	public FacilitySite editFacilitySite(FacilitySite facilitySite) throws Exception;
	
	public void deleteFacilitySite(int facilitySiteId) throws Exception;
	
	public List<FacilitySite> findAllFacilitySites() throws Exception;
	
	public List<FacilitySite> findAllFacilitySites(Page page);
	
	public FacilitySite findFacilitySiteById(int facilitySiteId) throws Exception;
	
	public List<FacilitySite> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();

}
