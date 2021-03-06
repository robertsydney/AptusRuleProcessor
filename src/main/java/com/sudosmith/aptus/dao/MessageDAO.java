package com.sudosmith.aptus.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.sudosmith.aptus.model.Message;

@Component("messageDao")
public interface MessageDAO extends GenericDAO<Message, Serializable> {

}
