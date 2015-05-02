package com.sudosmith.aptus.service;

import java.util.List;
import java.util.Map;

import com.sudosmith.aptus.model.ColorCode;
import com.sudosmith.aptus.pagination.Page;

public interface ColorCodeService {

    public ColorCode addColorCode(ColorCode colorCode) throws Exception;
	
	public ColorCode editColorCode(ColorCode colorCode) throws Exception;
	
	public void deleteColorCode(int colorCodeId) throws Exception;
	
	public List<ColorCode> findAllColorCodes() throws Exception;
	
	public List<ColorCode> findAllColorCodes(Page page);
	
	public ColorCode findColorCodeById(int colorCodeId) throws Exception;
	
	public List<ColorCode> findByQueryParams(Map<String, Object> queryParameters, Page page);
	
	public List<ColorCode> findColorCodeByColorName(Map<String, Object> queryParameters, Page page);
	
	public int totalNoOfRecord();
	
}
