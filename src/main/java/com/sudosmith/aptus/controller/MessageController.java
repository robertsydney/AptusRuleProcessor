package com.sudosmith.aptus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sudosmith.aptus.model.Rule;
import com.sudosmith.aptus.rabbitmq.MessageDelegator;
import com.sudosmith.aptus.rule.processor.RuleProcessor;



@Controller
public class MessageController {
	
	@Autowired MessageDelegator messageDelegator;
	
	@Autowired RuleProcessor ruleProcessor;
	
	@RequestMapping(value = "/processRequest", method = RequestMethod.GET)
	public ModelAndView publishMessage(@RequestParam(value = "requestId") String requestId, ModelMap model) throws IOException {
		List<Rule> ruleList = new ArrayList<Rule>();
		ruleList=ruleProcessor.getAllRules(requestId);
		for(int i=0;i<ruleList.size();i++)
		{
			Rule rule=ruleList.get(i);
			int ruleId=rule.getId();
			model.addAttribute("ruleId", ruleId);
			model.put("ruleId", ruleId);
			return new ModelAndView("redirect:/processRule");
			//ruleProcessor.processRule(ruleId);
		}
		return new ModelAndView("redirect:/processRule");
	}
	
	
	@RequestMapping(value = "/processRule", method = RequestMethod.GET)
	public String processRule(@RequestParam(value = "ruleId") String ruleId, ModelMap model) throws IOException {
		int ruleId1=Integer.parseInt(ruleId.trim());
		ruleProcessor.processRule(ruleId1);
		return "index";
	}	
	
}