package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.ColorCode;

@Component("colorCodeDao")
public interface ColorCodeDAO extends GenericDAO<ColorCode, Serializable> {

}
