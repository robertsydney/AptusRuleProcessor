package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.FacilitySiteDAO;
import com.sudosmith.aptus.model.FacilitySite;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.FacilitySiteService;

@Service("facilitySiteService")
public class FacilitySiteServiceImpl implements FacilitySiteService {
	
	private Logger logger = Logger.getLogger(FacilitySiteServiceImpl.class);

	@Autowired
	private FacilitySiteDAO facilitySiteDao;

	@Transactional
	public FacilitySite addFacilitySite(FacilitySite facilitySite) throws Exception {
		logger.debug("in addFacilitySite()");
		try {
			return facilitySiteDao.create(facilitySite);
		} catch (Exception e) {
			logger.error("Error adding facilitySite details", e);
		}
		return null;
	}

	@Transactional
	public FacilitySite editFacilitySite(FacilitySite facilitySite) throws Exception {

		logger.debug("In editFacilitySite()");
		logger.info("FacilitySite  Name - " + facilitySite.getSiteName());
		try {
			return facilitySiteDao.merge(facilitySite);
		} catch (Exception e) {
			logger.error("Error updaing facilitySite details", e);
		}
		return null;

	}

	@Transactional
	public void deleteFacilitySite(int facilitySiteId) throws Exception {
		logger.debug("In deleteFacilitySite()");
		try {
			FacilitySite facilitySite = facilitySiteDao.findById(facilitySiteId);
			if (facilitySite != null) {
				facilitySiteDao.delete(facilitySite);
			}
		} catch (Exception e) {
			logger.error("Error removing FacilitySite by id - " + facilitySiteId, e);
		}
	}

	@Transactional
	public List<FacilitySite> findAllFacilitySites() throws Exception {
		logger.debug("In findAllFacilitySites()");
		try {
			return facilitySiteDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting FacilitySites list.", e);
		}
		return null;
	}

	@Transactional
	public FacilitySite findFacilitySiteById(int facilitySiteId) throws Exception {
		logger.debug("In findFacilitySiteById()");
		try {
			return facilitySiteDao.findById(facilitySiteId);
		} catch (Exception e) {
			logger.error("Error in finding FacilitySite by id - " + facilitySiteId, e);
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
	public List<FacilitySite> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<FacilitySite> facilitySites = new ArrayList<FacilitySite>();
		try {
			List<?> facilitySiteList = facilitySiteDao.findByQueryParams("findFacilitySiteByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = facilitySiteList.iterator(); iterator
					.hasNext();) {
				FacilitySite facilitySite = (FacilitySite) iterator.next();
				facilitySites.add(facilitySite);
			}
			return facilitySites;
		} catch (Exception e) {
			logger.error("Error getting FacilitySites list.", e);
		}
		return null;
	}
	
	@Transactional
	public List<FacilitySite> findAllFacilitySites(Page page){
		
		logger.debug("In findAllFacilitySites(Page page)");
		try {
			return facilitySiteDao.findAll(page, "findAllFacilitySitesByPaging");
		} catch (Exception e) {
			logger.error("Error getting FacilitySites list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return facilitySiteDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
