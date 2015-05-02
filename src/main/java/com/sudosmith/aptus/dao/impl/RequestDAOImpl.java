package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.RequestDAO;
import com.sudosmith.aptus.model.Request;

@Repository("requestDao")
public class RequestDAOImpl extends GenericDAOImpl<Request, Long>
implements RequestDAO {

	public RequestDAOImpl(){
		super(Request.class);
	}
	
}
