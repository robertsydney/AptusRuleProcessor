package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.ModuleInputMessageDAO;
import com.sudosmith.aptus.model.ModuleInputMessage;

@Repository("moduleInputMessageDao")
public class ModuleInputMessageDAOImpl extends GenericDAOImpl<ModuleInputMessage, Long>
implements ModuleInputMessageDAO {
	public ModuleInputMessageDAOImpl(){
		super(ModuleInputMessage.class);
	}

}
