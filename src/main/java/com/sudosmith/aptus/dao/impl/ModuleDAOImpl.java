package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.ModuleDAO;
import com.sudosmith.aptus.model.Module;



@Repository("moduleDao")
public class ModuleDAOImpl extends GenericDAOImpl<Module, Long>
implements ModuleDAO {
	public ModuleDAOImpl(){
		super(Module.class);
	}
}
