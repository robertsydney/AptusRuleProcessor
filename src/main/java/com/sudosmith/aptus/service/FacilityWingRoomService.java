package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.FacilityWingRoom;
import com.sudosmith.aptus.pagination.Page;

public interface FacilityWingRoomService {
	
    public FacilityWingRoom addWingRoom(FacilityWingRoom wingRoom) throws Exception;
	
	public FacilityWingRoom editWingRoom(FacilityWingRoom wingRoom) throws Exception;
	
	public void deleteWingRoom(int wingRoomId) throws Exception;
	
	public List<FacilityWingRoom> findAllWingRooms() throws Exception;
	
	public List<FacilityWingRoom> findAllWingRooms(Page page);
	
	public FacilityWingRoom findWingRoomById(int wingRoomId) throws Exception;
	
	public List<FacilityWingRoom> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<FacilityWingRoom> findByWingId(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();

}
