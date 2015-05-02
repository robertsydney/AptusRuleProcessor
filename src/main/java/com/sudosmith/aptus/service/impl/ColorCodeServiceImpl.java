package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.ColorCodeDAO;
import com.sudosmith.aptus.model.ColorCode;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.ColorCodeService;

@Service("colorCodeService")
public class ColorCodeServiceImpl implements ColorCodeService {
	
	private Logger logger = Logger.getLogger(ColorCodeServiceImpl.class);

	@Autowired
	private ColorCodeDAO colorCodeDao;

	@Transactional
	public ColorCode addColorCode(ColorCode colorCode) throws Exception {
		logger.debug("in addColorCode()");
		try {
			return colorCodeDao.create(colorCode);
		} catch (Exception e) {
			logger.error("Error adding colorCode details", e);
		}
		return null;
	}

	@Transactional
	public ColorCode editColorCode(ColorCode colorCode) throws Exception {

		logger.debug("In editColorCode()");
		logger.info("Color Name - " + colorCode.getColorName());
		try {
			return colorCodeDao.merge(colorCode);
		} catch (Exception e) {
			logger.error("Error updaing colorCode details", e);
		}
		return null;

	}

	@Transactional
	public void deleteColorCode(int colorCodeId) throws Exception {
		logger.debug("In deleteColorCode()");
		try {
			ColorCode colorCode = colorCodeDao.findById(colorCodeId);
			if (colorCode != null) {
				colorCodeDao.delete(colorCode);
			}
		} catch (Exception e) {
			logger.error("Error removing ColorCode by id - " + colorCodeId, e);
		}
	}

	@Transactional
	public List<ColorCode> findAllColorCodes() throws Exception {
		logger.debug("In findAllColorCodes()");
		try {
			return colorCodeDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting ColorCodes list.", e);
		}
		return null;
	}

	@Transactional
	public ColorCode findColorCodeById(int colorCodeId) throws Exception {
		logger.debug("In findColorCodeById()");
		try {
			return colorCodeDao.findById(colorCodeId);
		} catch (Exception e) {
			logger.error("Error in finding ColorCode by id - " + colorCodeId, e);
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
	public List<ColorCode> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<ColorCode> colorCodes = new ArrayList<ColorCode>();
		try {
			List<?> colorCodeList = colorCodeDao.findByQueryParams("findColorCodeByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = colorCodeList.iterator(); iterator
					.hasNext();) {
				ColorCode colorCode = (ColorCode) iterator.next();
				colorCodes.add(colorCode);
			}
			return colorCodes;
		} catch (Exception e) {
			logger.error("Error getting ColorCodes list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<ColorCode> findColorCodeByColorName(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findColorCodeByColorName(String queryName, Map<String, Object> queryParameters)");
		List<ColorCode> colorCodes = new ArrayList<ColorCode>();
		try {
			List<?> colorCodeList = colorCodeDao.findByQueryParams("findColorCodeByColorName",
					queryParameters,page);
			for (Iterator<?> iterator = colorCodeList.iterator(); iterator
					.hasNext();) {
				ColorCode colorCode = (ColorCode) iterator.next();
				colorCodes.add(colorCode);
			}
			return colorCodes;
		} catch (Exception e) {
			logger.error("Error getting ColorCodes list.", e);
		}
		return null;
	}
	
	@Transactional
	public List<ColorCode> findAllColorCodes(Page page){
		
		logger.debug("In findAllColorCodes(Page page)");
		try {
			return colorCodeDao.findAll(page, "findAllColorCodesByPaging");
		} catch (Exception e) {
			logger.error("Error getting ColorCodes list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return colorCodeDao.totalNoOfRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	

}
