package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.ModuleInputMessage;
import com.sudosmith.aptus.pagination.Page;

public interface ModuleInputMessageService {
	
    public ModuleInputMessage addModuleInputMessage(ModuleInputMessage moduleInputMessage) throws Exception;
	
	public ModuleInputMessage editModuleInputMessage(ModuleInputMessage moduleInputMessage) throws Exception;
	
	public void deleteModuleInputMessage(int moduleInputMessageId) throws Exception;
	
	public List<ModuleInputMessage> findAllModuleInputMessages() throws Exception;
	
	public List<ModuleInputMessage> findAllModuleInputMessages(Page page);
	
	public ModuleInputMessage findModuleInputMessageById(int moduleInputMessageId) throws Exception;
	
	public List<ModuleInputMessage> findByQueryParams(Map<String, Object> queryParameters, Page page);		
	
	public List<ModuleInputMessage> findModuleInputMessageByInputId(Map<String, Object> queryParameters, Page page);		
	
	public int totalNoOfRecord();			

}
