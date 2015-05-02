package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.ModuleInputDAO;
import com.sudosmith.aptus.model.ModuleInput;

@Repository("moduleInputDao")
public class ModuleInputDAOImpl extends GenericDAOImpl<ModuleInput, Long>
implements ModuleInputDAO {
	public ModuleInputDAOImpl(){
		super(ModuleInput.class);
	}

}
