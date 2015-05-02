package com.sudosmith.aptus.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 */
@Controller
public class HomeController {

	private Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public String doHomeController(Map<String, Object> map) {
		logger.debug("doHomeController()");
		System.out.println("doHomeController()");
		return "index";
	}
}
