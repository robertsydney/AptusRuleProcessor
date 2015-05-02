package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.FacilitySiteDAO;
import com.sudosmith.aptus.model.FacilitySite;

@Repository("facilitySiteDao")
public class FacilitySiteDAOImpl extends GenericDAOImpl<FacilitySite, Long>
implements  FacilitySiteDAO {
	
	public FacilitySiteDAOImpl(){
		super(FacilitySite.class);
	}

}
