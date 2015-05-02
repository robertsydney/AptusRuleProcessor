package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.ModuleInput;

@Component("moduleInputDao")
public interface ModuleInputDAO extends GenericDAO<ModuleInput, Serializable> {

}
