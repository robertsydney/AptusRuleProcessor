package com.sudosmith.aptus.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.FacilityDAO;
import com.sudosmith.aptus.model.Facility;
import com.sudosmith.aptus.service.FacilityService;

@Service("facilityService")
public class FacilityServiceImpl implements FacilityService {
	
	private Logger logger = Logger.getLogger(FacilityServiceImpl.class);

	@Autowired
	private FacilityDAO facilityDao;
	
	@Transactional
	public Facility addFacility(Facility facility) throws Exception {
		logger.debug("in addFacility()");
		try {
			return facilityDao.create(facility);
		} catch (Exception e) {
			logger.error("Error adding Facility details", e);
		}
		return null;
	}

	@Transactional
	public Facility editFacility(Facility facility) throws Exception {

		logger.debug("In editFacility()");
		logger.info("Facility Name - " + facility.getOrgName());
		try {
			return facilityDao.merge(facility);
		} catch (Exception e) {
			logger.error("Error updating Facility details", e);
		}
		return null;

	}
	
	@Transactional
	public List<Facility> findAllFacilitys() throws Exception {
		logger.debug("In findAllFacilitys()");
		try {
			return facilityDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting Facility list", e);
		}
		return null;
	}
	
	@Transactional
	public Facility findFacilityById(int facilityId) throws Exception {
		logger.debug("In findFacilityById()");
		try {
			return facilityDao.findById(facilityId);
		} catch (Exception e) {
			logger.error("Error in finding facility by id - " + facilityId, e);
		}
		return null;
	}
	

}
