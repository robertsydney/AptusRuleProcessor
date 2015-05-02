package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.Location;
import com.sudosmith.aptus.pagination.Page;

public interface LocationService {
	
    public Location addLocation(Location location) throws Exception;
	
	public Location editLocation(Location location) throws Exception;
	
	public List<Location> findAllLocations() throws Exception;
	
	public Location findLocationById(int locationId) throws Exception;
	
	public List<Location> findLocationByLocationIds(Map<String, Object> queryParameters, Page page);
	
	public List<Location> findLocationByHalfLocation(Map<String, Object> queryParameters, Page page);

}
