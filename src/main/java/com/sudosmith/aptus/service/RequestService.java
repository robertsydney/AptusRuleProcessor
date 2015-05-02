package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.Request;
import com.sudosmith.aptus.pagination.Page;

public interface RequestService {
	
    public Request addRequest(Request request) throws Exception;
	
	public Request editRequest(Request request) throws Exception;
	
	public List<Request> findAllRequests() throws Exception;
	
	public Request findRequestById(int requestId) throws Exception;
	
	public List<Request> findRequestByRequestIdResponse(Map<String, Object> queryParameters, Page page);
	
	public List<Request> findRequestByRequestIdInterrupt(Map<String, Object> queryParameters, Page page);
	
}
