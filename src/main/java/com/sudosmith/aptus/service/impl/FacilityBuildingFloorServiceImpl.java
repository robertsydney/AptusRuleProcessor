package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.FacilityBuildingFloorDAO;
import com.sudosmith.aptus.model.FacilityBuildingFloor;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.FacilityBuildingFloorService;

@Service("buildingFloorService")
public class FacilityBuildingFloorServiceImpl implements  FacilityBuildingFloorService {
	
	private Logger logger = Logger.getLogger(FacilityBuildingFloorServiceImpl.class);

	@Autowired
	private FacilityBuildingFloorDAO buildingFloorDao;

	@Transactional
	public FacilityBuildingFloor addBuildingFloor(FacilityBuildingFloor buildingFloor) throws Exception {
		logger.debug("in addBuildingFloor()");
		try {
			return buildingFloorDao.create(buildingFloor);
		} catch (Exception e) {
			logger.error("Error adding buildingFloor details", e);
		}
		return null;
	}

	@Transactional
	public FacilityBuildingFloor editBuildingFloor(FacilityBuildingFloor buildingFloor) throws Exception {

		logger.debug("In editBuildingFloor()");
		logger.info("BuildingFloor  Name - " + buildingFloor.getFloorName());
		try {
			return buildingFloorDao.merge(buildingFloor);
		} catch (Exception e) {
			logger.error("Error updaing buildingFloor details", e);
		}
		return null;

	}

	@Transactional
	public void deleteBuildingFloor(int buildingFloorId) throws Exception {
		logger.debug("In deleteBuildingFloor()");
		try {
			FacilityBuildingFloor buildingFloor = buildingFloorDao.findById(buildingFloorId);
			if (buildingFloor != null) {
				buildingFloorDao.delete(buildingFloor);
			}
		} catch (Exception e) {
			logger.error("Error removing BuildingFloor by id - " + buildingFloorId, e);
		}
	}

	@Transactional
	public List<FacilityBuildingFloor> findAllBuildingFloors() throws Exception {
		logger.debug("In findAllBuildingFloors()");
		try {
			return buildingFloorDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting BuildingFloors list.", e);
		}
		return null;
	}

	@Transactional
	public FacilityBuildingFloor findBuildingFloorById(int buildingFloorId) throws Exception {
		logger.debug("In findBuildingFloorById()");
		try {
			return buildingFloorDao.findById(buildingFloorId);
		} catch (Exception e) {
			logger.error("Error in finding BuildingFloor by id - " + buildingFloorId, e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.crud.service.SupportedDeviceService#findByQueryParams(java.lang.String
	 * , java.util.Map)
	 */
	@Transactional
	public List<FacilityBuildingFloor> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<FacilityBuildingFloor> buildingFloors = new ArrayList<FacilityBuildingFloor>();
		try {
			List<?> buildingFloorList = buildingFloorDao.findByQueryParams("findBuildingFloorByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = buildingFloorList.iterator(); iterator
					.hasNext();) {
				FacilityBuildingFloor buildingFloor = (FacilityBuildingFloor) iterator.next();
				buildingFloors.add(buildingFloor);
			}
			return buildingFloors;
		} catch (Exception e) {
			logger.error("Error getting BuildingFloors list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<FacilityBuildingFloor> findByBuildingId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<FacilityBuildingFloor> buildingFloors = new ArrayList<FacilityBuildingFloor>();
		try {
			List<?> buildingFloorList = buildingFloorDao.findByQueryParams("findBuildingFloorByBuildingId",
					queryParameters,page);
			for (Iterator<?> iterator = buildingFloorList.iterator(); iterator
					.hasNext();) {
				FacilityBuildingFloor buildingFloor = (FacilityBuildingFloor) iterator.next();
				buildingFloors.add(buildingFloor);
			}
			return buildingFloors;
		} catch (Exception e) {
			logger.error("Error getting BuildingFloors list.", e);
		}
		return null;
	}
	
	
	
	@Transactional
	public List<FacilityBuildingFloor> findAllBuildingFloors(Page page){
		
		logger.debug("In findAllBuildingFloors(Page page)");
		try {
			return buildingFloorDao.findAll(page, "findAllBuildingFloorsByPaging");
		} catch (Exception e) {
			logger.error("Error getting BuildingFloors list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return buildingFloorDao.totalNoOfRecord();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return 0;
	}	

}
