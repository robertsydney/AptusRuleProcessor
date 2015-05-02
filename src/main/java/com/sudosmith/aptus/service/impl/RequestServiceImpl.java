package com.sudosmith.aptus.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.aptus.dao.RequestDAO;
import com.sudosmith.aptus.model.Request;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.RequestService;


@Service("requestService")
public class RequestServiceImpl implements RequestService {

	
	private Logger logger = Logger.getLogger(RequestServiceImpl.class);

	@Autowired
	private RequestDAO requestDao;
	
	@Transactional
	public Request addRequest(Request request) throws Exception {
		logger.debug("in addRequest()");
		try {
			return requestDao.create(request);
		} catch (Exception e) {
			logger.error("Error adding Request details", e);
		}
		return null;
	}

	@Transactional
	public Request editRequest(Request request) throws Exception {

		logger.debug("In editRequest()");
		logger.info("Request id - " + request.getRequestId());
		try {
			return requestDao.merge(request);
		} catch (Exception e) {
			logger.error("Error updating Request details", e);
		}
		return null;

	}
	
	@Transactional
	public List<Request> findAllRequests() throws Exception {
		logger.debug("In findAllRequests()");
		try {
			return requestDao.findAll();
		} catch (Exception e) {
			logger.error("Error getting Request log.", e);
		}
		return null;
	}
	
	@Transactional
	public Request findRequestById(int requestId) throws Exception {
		logger.debug("In findRequestById()");
		try {
			return requestDao.findById(requestId);
		} catch (Exception e) {
			logger.error("Error in finding request by id - " + requestId, e);
		}
		return null;
	}
	
	
	@Transactional
	public List<Request> findRequestByRequestIdResponse(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Request> requests = new ArrayList<Request>();
		try {
			List<?> requestList = requestDao.findByQueryParams("findRequestByRequestIdResponse",
					queryParameters,page);
			for (Iterator<?> iterator = requestList.iterator(); iterator
					.hasNext();) {
				Request request = (Request) iterator.next();
				requests.add(request);
			}
			return requests;
		} catch (Exception e) {
			logger.error("Error getting Requests list.", e);
		}
		return null;
	}
	
	
	@Transactional
	public List<Request> findRequestByRequestIdInterrupt(
			Map<String, Object> queryParameters, Page page) {
		logger.debug("In findByQueryParams(String queryName, Map<String, Object> queryParameters)");
		List<Request> requests = new ArrayList<Request>();
		try {
			List<?> requestList = requestDao.findByQueryParams("findRequestByRequestIdInterrupt",
					queryParameters,page);
			for (Iterator<?> iterator = requestList.iterator(); iterator
					.hasNext();) {
				Request request = (Request) iterator.next();
				requests.add(request);
			}
			return requests;
		} catch (Exception e) {
			logger.error("Error getting Requests list.", e);
		}
		return null;
	}	
	
}
