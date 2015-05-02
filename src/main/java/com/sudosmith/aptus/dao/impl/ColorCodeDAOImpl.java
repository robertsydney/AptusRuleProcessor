package com.sudosmith.aptus.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.aptus.dao.ColorCodeDAO;
import com.sudosmith.aptus.model.ColorCode;

@Repository("colorCodeDao")
public class ColorCodeDAOImpl extends GenericDAOImpl<ColorCode, Long>
implements ColorCodeDAO {

	public ColorCodeDAOImpl(){
		super(ColorCode.class);
	}

}
