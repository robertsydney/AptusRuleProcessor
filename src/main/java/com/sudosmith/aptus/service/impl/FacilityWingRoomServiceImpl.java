package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.FacilityWingRoomDAO;
import com.sudosmith.aptus.model.FacilityWingRoom;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.FacilityWingRoomService;

@Service("wingRoomService")
public class FacilityWingRoomServiceImpl implements  FacilityWingRoomService {

	private Logger logger = Logger.getLogger(FacilityWingRoomServiceImpl.class);

	@Autowired
	private FacilityWingRoomDAO wingRoomDao;

	@Transactional
	public FacilityWingRoom addWingRoom(FacilityWingRoom wingRoom) throws Exception {
		logger.debug("in addWingRoom()");
		try {
			return wingRoomDao.create(wingRoom);
		} catch (Exception e) {
			logger.error("Error adding wingRoom details", e);
		}
		return null;
	}

	@Transactional
	public FacilityWingRoom editWingRoom(FacilityWingRoom wingRoom) throws Exception {

		logger.debug("In editWingRoom()");
		logger.info("WingRoom  Number - " + wingRoom.getRoomNumber());
		try {
			return wingRoomDao.merge(wingRoom);
		} catch (Exception e) {
			logger.error("Error updaing wingRoom details", e);
		}
		return null;

	}

	@Transactional
	public void deleteWingRoom(int wingRoomId) throws Exception {
		logger.debug("In deleteWingRoom()");
		try {
			FacilityWingRoom wingRoom = wingRoomDao.findById(wingRoomId);
			if (wingRoom != null) {
				wingRoomDao.delete(wingRoom);
			}
		} catch (Exception e) {
			logger.error("Error removing WingRoom by id - " + wingRoomId, e);
		}
	}

	@Transactional
	public List<FacilityWingRoom> findAllWingRooms() throws Exception {
		logger.debug("In findAllWingRooms()");
		try {
			return wingRoomDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting WingRooms list.", e);
		}
		return null;
	}

	@Transactional
	public FacilityWingRoom findWingRoomById(int wingRoomId) throws Exception {
		logger.debug("In findWingRoomById()");
		try {
			return wingRoomDao.findById(wingRoomId);
		} catch (Exception e) {
			logger.error("Error in finding WingRoom by id - " + wingRoomId, e);
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
	public List<FacilityWingRoom> findByQueryParams(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<FacilityWingRoom> wingRooms = new ArrayList<FacilityWingRoom>();
		try {
			List<?> wingRoomList = wingRoomDao.findByQueryParams("findWingRoomByCommonSearch",
					queryParameters,page);
			for (Iterator<?> iterator = wingRoomList.iterator(); iterator
					.hasNext();) {
				FacilityWingRoom wingRoom = (FacilityWingRoom) iterator.next();
				wingRooms.add(wingRoom);
			}
			return wingRooms;
		} catch (Exception e) {
			logger.error("Error getting WingRooms list.", e);
		}
		return null;
	}
	
	@Transactional
	public List<FacilityWingRoom> findByWingId(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<FacilityWingRoom> wingRooms = new ArrayList<FacilityWingRoom>();
		try {
			List<?> wingRoomList = wingRoomDao.findByQueryParams("findWingRoomByWingId",
					queryParameters,page);
			for (Iterator<?> iterator = wingRoomList.iterator(); iterator
					.hasNext();) {
				FacilityWingRoom wingRoom = (FacilityWingRoom) iterator.next();
				wingRooms.add(wingRoom);
			}
			return wingRooms;
		} catch (Exception e) {
			logger.error("Error getting WingRooms list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<FacilityWingRoom> findAllWingRooms(Page page){
		
		logger.debug("In findAllWingRooms(Page page)");
		try {
			return wingRoomDao.findAll(page, "findAllWingRoomsByPaging");
		} catch (Exception e) {
			logger.error("Error getting WingRooms list.", e);
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.crud.service.SupportedDeviceService#totalNoOfRecord()
	 */
	@Override
	public int totalNoOfRecord() {
		try {
			return wingRoomDao.totalNoOfRecord();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return 0;
	}	

}
