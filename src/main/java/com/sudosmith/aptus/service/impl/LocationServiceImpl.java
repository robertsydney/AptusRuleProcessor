package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.LocationDAO;
import com.sudosmith.aptus.model.Location;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.LocationService;

@Service("locationService")
public class LocationServiceImpl implements LocationService {
	
	private Logger logger = Logger.getLogger(LocationServiceImpl.class);

	@Autowired
	private LocationDAO locationDao;
	
	@Transactional
	public Location addLocation(Location location) throws Exception {
		logger.debug("in addLocation()");
		try {
			return locationDao.create(location);
		} catch (Exception e) {
			logger.error("Error adding Location details", e);
		}
		return null;
	}

	@Transactional
	public Location editLocation(Location location) throws Exception {

		logger.debug("In editLocation()");
		logger.info("Location id - " + location.getId());
		try {
			return locationDao.merge(location);
		} catch (Exception e) {
			logger.error("Error updating Location details", e);
		}
		return null;

	}
	
	@Transactional
	public List<Location> findAllLocations() throws Exception {
		logger.debug("In findAllLocations()");
		try {
			return locationDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting Location log.", e);
		}
		return null;
	}
	
	@Transactional
	public Location findLocationById(int locationId) throws Exception {
		logger.debug("In findLocationById()");
		try {
			return locationDao.findById(locationId);
		} catch (Exception e) {
			logger.error("Error in finding location by id - " + locationId, e);
		}
		return null;
	}
	
	@Transactional
	public List<Location> findLocationByLocationIds(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findLocationByLocationIds(String queryName, Map<String, Object> queryParameters)");
		List<Location> locations = new ArrayList<Location>();
		try {
			List<?> locationList = locationDao.findByQueryParams("findLocationByLocationIds",
					queryParameters,page);
			for (Iterator<?> iterator = locationList.iterator(); iterator
					.hasNext();) {
				Location location = (Location) iterator.next();
				locations.add(location);
			}
			return locations;
		} catch (Exception e) {
			logger.error("Error getting locations list.", e);
		}
		return null;
	}
	

	@Transactional
	public List<Location> findLocationByHalfLocation(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In  findLocationByHalfLocation(String queryName, Map<String, Object> queryParameters)");
		List<Location> locations = new ArrayList<Location>();
		try {
			List<?> locationList = locationDao.findByQueryParams("findLocationByHalfLocation",
					queryParameters,page);
			for (Iterator<?> iterator = locationList.iterator(); iterator
					.hasNext();) {
				Location location = (Location) iterator.next();
				locations.add(location);
			}
			return locations;
		} catch (Exception e) {
			logger.error("Error getting locations list.", e);
		}
		return null;
	}	

}
