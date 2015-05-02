package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.FacilitySite;

@Component("facilitySiteDao")
public interface FacilitySiteDAO extends GenericDAO<FacilitySite, Serializable>{

}
