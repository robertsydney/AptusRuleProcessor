package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.FacilitySiteBuildingDAO;
import com.sudosmith.aptus.model.FacilitySiteBuilding;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.FacilitySiteBuildingService;

@Service("siteBuildingService")
public class FacilitySiteBuildingServiceImpl implements  FacilitySiteBuildingService {
	
	private Logger logger = Logger.getLogger(FacilitySiteBuildingServiceImpl.class);

	@Autowired
	private FacilitySiteBuildingDAO siteBuildingDao;

	@Transactional
	public FacilitySiteBuilding addSiteBuilding(FacilitySiteBuilding siteBuilding) throws Exception {
		logger.debug("in addSiteBuilding()");
		try {
			return siteBuildingDao.create(siteBuilding);
		} catch (Exception e) {
			logger.error("Error adding siteBuilding details", e);
		}
		return null;
	}

	@Transactional
	public FacilitySiteBuilding editSiteBuilding(FacilitySiteBuilding siteBuilding) throws Exception {

		logger.debug("In editSiteBuilding()");
		logger.info("SiteBuilding  Name - " + siteBuilding.getBuildingName());
		try {
			return siteBuildingDao.merge(siteBuilding);
		} catch (Exception e) {
			logger.error("Error updaing siteBuilding details", e);
		}
		return null;

	}

	@Transactional
	public void deleteSiteBuilding(int siteBuildingId) throws Exception {
		logger.debug("In deleteSiteBuilding()");
		try {
			FacilitySiteBuilding siteBuilding = siteBuildingDao.findById(siteBuildingId);
			if (siteBuilding != null) {
				siteBuildingDao.delete(siteBuilding);
			}
		} catch (Exception e) {
			logger.error("Error removing SiteBuilding by id - " + siteBuildingId, e);
		}
	}

	@Transactional
	public List<FacilitySiteBuilding> findAllSiteBuildings() throws Exception {
		logger.debug("In findAllSiteBuildings()");
		try {
			return siteBuildingDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting SiteBuildings list.", e);
		}
		return null;
	}

	@Transactional
	public FacilitySiteBuilding findSiteBuildingById(int siteBuildingId) throws Exception {
		logger.debug("In findSiteBuildingById()");
		try {
			return siteBuildingDao.findById(siteBuildingId);
		} catch (Exception e) {
			logger.error("Error in finding SiteBuilding by id - " + siteBuildingId, e);
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
	public List<FacilitySiteBuilding> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<FacilitySiteBuilding> siteBuildings = new ArrayList<FacilitySiteBuilding>();
		try {
			List<?> siteBuildingList = siteBuildingDao.findByQueryParams("findSiteBuildingByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = siteBuildingList.iterator(); iterator
					.hasNext();) {
				FacilitySiteBuilding siteBuilding = (FacilitySiteBuilding) iterator.next();
				siteBuildings.add(siteBuilding);
			}
			return siteBuildings;
		} catch (Exception e) {
			logger.error("Error getting SiteBuildings list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<FacilitySiteBuilding> findBySiteId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<Integer, Object> queryParameters)");
		List<FacilitySiteBuilding> siteBuildings = new ArrayList<FacilitySiteBuilding>();
		try {
			List<?> siteBuildingList = siteBuildingDao.findByQueryParams("findSiteBuildingBySiteId",
					queryParameters,page);
			for (Iterator<?> iterator = siteBuildingList.iterator(); iterator
					.hasNext();) {
				FacilitySiteBuilding siteBuilding = (FacilitySiteBuilding) iterator.next();
				siteBuildings.add(siteBuilding);
			}
			return siteBuildings;
		} catch (Exception e) {
			logger.error("Error getting SiteBuildings list.", e);
		}
		return null;
	}
	
	
	
	@Transactional
	public List<FacilitySiteBuilding> findAllSiteBuildings(Page page){
		
		logger.debug("In findAllSiteBuildings(Page page)");
		try {
			return siteBuildingDao.findAll(page, "findAllSiteBuildingsByPaging");
		} catch (Exception e) {
			logger.error("Error getting SiteBuildings list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return siteBuildingDao.totalNoOfRecord();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return 0;
	}	

}
