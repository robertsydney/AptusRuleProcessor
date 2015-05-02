package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.Module;


@Component("moduleDao")
public interface ModuleDAO extends GenericDAO<Module, Serializable> {

}
