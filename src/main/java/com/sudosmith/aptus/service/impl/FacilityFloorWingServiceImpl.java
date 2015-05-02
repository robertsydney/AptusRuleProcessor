package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.FacilityFloorWingDAO;
import com.sudosmith.aptus.model.FacilityFloorWing;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.FacilityFloorWingService;

@Service("floorWingService")
public class FacilityFloorWingServiceImpl implements  FacilityFloorWingService {
	
	private Logger logger = Logger.getLogger(FacilityFloorWingServiceImpl.class);

	@Autowired
	private FacilityFloorWingDAO floorWingDao;

	@Transactional
	public FacilityFloorWing addFloorWing(FacilityFloorWing floorWing) throws Exception {
		logger.debug("in addFloorWing()");
		try {
			return floorWingDao.create(floorWing);
		} catch (Exception e) {
			logger.error("Error adding floorWing details", e);
		}
		return null;
	}

	@Transactional
	public FacilityFloorWing editFloorWing(FacilityFloorWing floorWing) throws Exception {

		logger.debug("In editFloorWing()");
		logger.info("FloorWing  Name - " + floorWing.getWingName());
		try {
			return floorWingDao.merge(floorWing);
		} catch (Exception e) {
			logger.error("Error updaing floorWing details", e);
		}
		return null;

	}

	@Transactional
	public void deleteFloorWing(int floorWingId) throws Exception {
		logger.debug("In deleteFloorWing()");
		try {
			FacilityFloorWing floorWing = floorWingDao.findById(floorWingId);
			if (floorWing != null) {
				floorWingDao.delete(floorWing);
			}
		} catch (Exception e) {
			logger.error("Error removing FloorWing by id - " + floorWingId, e);
		}
	}

	@Transactional
	public List<FacilityFloorWing> findAllFloorWings() throws Exception {
		logger.debug("In findAllFloorWings()");
		try {
			return floorWingDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting FloorWings list.", e);
		}
		return null;
	}

	@Transactional
	public FacilityFloorWing findFloorWingById(int floorWingId) throws Exception {
		logger.debug("In findFloorWingById()");
		try {
			return floorWingDao.findById(floorWingId);
		} catch (Exception e) {
			logger.error("Error in finding FloorWing by id - " + floorWingId, e);
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
	public List<FacilityFloorWing> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<FacilityFloorWing> floorWings = new ArrayList<FacilityFloorWing>();
		try {
			List<?> floorWingList = floorWingDao.findByQueryParams("findFloorWingByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = floorWingList.iterator(); iterator
					.hasNext();) {
				FacilityFloorWing floorWing = (FacilityFloorWing) iterator.next();
				floorWings.add(floorWing);
			}
			return floorWings;
		} catch (Exception e) {
			logger.error("Error getting FloorWings list.", e);
		}
		return null;
	}
	
	@Transactional
	public List<FacilityFloorWing> findByFloorId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<FacilityFloorWing> floorWings = new ArrayList<FacilityFloorWing>();
		try {
			List<?> floorWingList = floorWingDao.findByQueryParams("findFloorWingByFloorId",
					queryParameters,page);
			for (Iterator<?> iterator = floorWingList.iterator(); iterator
					.hasNext();) {
				FacilityFloorWing floorWing = (FacilityFloorWing) iterator.next();
				floorWings.add(floorWing);
			}
			return floorWings;
		} catch (Exception e) {
			logger.error("Error getting FloorWings list.", e);
		}
		return null;
	}
	
	@Transactional
	public List<FacilityFloorWing> findAllFloorWings(Page page){
		
		logger.debug("In findAllFloorWings(Page page)");
		try {
			return floorWingDao.findAll(page, "findAllFloorWingsByPaging");
		} catch (Exception e) {
			logger.error("Error getting FloorWings list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return floorWingDao.totalNoOfRecord();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return 0;
	}	

}
