package com.sudosmith.aptus.rule.processor;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudosmith.aptus.event.processor.EventProcessor;
import com.sudosmith.aptus.model.EventRegister;
import com.sudosmith.aptus.model.EventType;
import com.sudosmith.aptus.model.Location;
import com.sudosmith.aptus.model.Module;
import com.sudosmith.aptus.model.ModuleDevice;
import com.sudosmith.aptus.model.OutputDeviceConfig;
import com.sudosmith.aptus.model.Rule;
import com.sudosmith.aptus.model.RuleEsc;
import com.sudosmith.aptus.model.RuleEscGroupOutputDevice;
import com.sudosmith.aptus.model.SupportedDevice;
import com.sudosmith.aptus.rabbitmq.MessageDelegatorOut;
import com.sudosmith.aptus.service.LocationService;
import com.sudosmith.aptus.service.ModuleDeviceService;
import com.sudosmith.aptus.service.ModuleService;
import com.sudosmith.aptus.service.RuleService;


@Service
public class RuleProcessor {
	
@Autowired  
RuleService ruleService;

@Autowired  
EventProcessor eventProcessor;

@Autowired  
MessageDelegatorOut messageDelegator;

@Autowired  
ModuleDeviceService moduleDeviceService;

@Autowired  
ModuleService moduleService;

@Autowired  
LocationService locationService;

private Rule rule;
private List<RuleEsc> ruleEscList;
private List<RuleEscGroupOutputDevice> ruleOutputDeviceList;
	
/////////MESSAGE VARIABLES///////////
private String requestId;
private int inDeviceId;
private int eventTypeId;

JSONParser parser;
JSONObject message;
 

/////////RULES VARIABLES/////////////	
private boolean isRuleDefined=false;


public void getMessageData(String requestId)
{
 try
 {	 	
	 EventRegister eventRegister=eventProcessor.findEventRegisterByRequestId(requestId);
    ///////// GETTING DATA FROM THE MESSAGE ////////////
	 System.out.println("Reading Message from IN_CEN Queue");

	 eventTypeId=eventRegister.getEventId();
	 System.out.println("Event Type id is: "+eventTypeId);
	 
	 this.requestId=requestId;
	 System.out.println("Request id is: "+requestId);
	 
	 inDeviceId=eventRegister.getModuleDeviceId();
	 System.out.println("Input Device id is: "+inDeviceId);
 }
 catch(Exception e)
 {
 System.out.println("Exception while reading the messege:- "+e);	
 }
}


public List<Rule> getAllRules(String requestId)
{ 
	List<Rule> ruleList = new ArrayList<Rule>();
	getMessageData(requestId);
	ruleList=eventProcessor.getRulesList(eventTypeId, inDeviceId);
	return ruleList;
}

public void processRule(int ruleId)
{   
	
	parser=new JSONParser();
	message=new JSONObject();
	rule=eventProcessor.getRuleByRuleId(ruleId);
	if(rule.getId()>0)
	{
	 isRuleDefined=true;	
	}
	if(isRuleDefined)
	{	
	ruleEscList=eventProcessor.getRuleEscalations(rule.getId());
	System.out.println("Rule Esc list Size: "+ruleEscList.size());
	processingRule();
	}
	else
	{
	System.out.println("No Rule is defined for this condition");	
	}
}


public void processingRule()
{
try
{
	int autoCancel=rule.getAutoCancel();
	for(int i=0;i<=autoCancel;i++)
	{
		
		 if(eventProcessor.isResponseRecieved(requestId) || eventProcessor.isInterrupted(requestId))
		  {
			System.out.println("<---------------Response Recieved Or Interrupted--------------->");
			break;
		  }
		  else
		  {
				for(int n=0;n<ruleEscList.size();n++)
				{
					if(eventProcessor.isInterrupted(requestId))
					{
						System.out.println("<------------------Event Interrupted--------------->");
					}
					else
					{	
					RuleEsc ruleEsc=ruleEscList.get(n);
					ruleOutputDeviceList=eventProcessor.getRuleOutputDevices(rule.getId(),ruleEsc.getEscLevel());
					
					for(int m=0;m<ruleOutputDeviceList.size();m++)
					{
						RuleEscGroupOutputDevice ruleOutputDevice=ruleOutputDeviceList.get(m);
						int outDeviceId=ruleOutputDevice.getDeviceId();
	                    
						System.out.println("Output Device Id is:-"+outDeviceId);
						ModuleDevice moduleDevice=moduleDeviceService.findModuleDeviceById(outDeviceId);
						int moduleId=moduleDevice.getModuleId();
						String moduleDeviceAddress=moduleDevice.getModuleDeviceAddress();
						int supportedDeviceId=moduleDevice.getSupportedDeviceId();
					   
						String shortMessage="";
						String longMessage="";
						
						if(eventProcessor.shortMessageSupport(outDeviceId))
						{
							shortMessage=eventProcessor.getInputShortMessage(inDeviceId, eventTypeId);
						}
						if(eventProcessor.longMessageSupport(outDeviceId))
						{
							longMessage=eventProcessor.getInputLongMessage(inDeviceId, eventTypeId);
						}
						else if(eventProcessor.cancelMessageSupport(outDeviceId))
						{
							
						}
						if(!eventProcessor.checkRequestInMessage(this.requestId))
						{	
						eventProcessor.storeMessage(this.requestId, longMessage, shortMessage);
						}
						
						Module module=eventProcessor.findModuleById(moduleId);
						String moduleAddress=module.getModuleAddress();
						
						
						SupportedDevice supportedDevice=eventProcessor.getSupportedDeviceById(supportedDeviceId);
						String adapterName=supportedDevice.getDeviceAdapter();
						
						if(adapterName.equalsIgnoreCase("OM012"))
						{
							OutputDeviceConfig outputDeviceConfig=eventProcessor.getOuptutDeviceConfigByDeviceId(supportedDeviceId);
							
							EventType eventType=eventProcessor.getEventByEventId(eventTypeId);
							String callType=eventType.getEventName();
							if(callType.equalsIgnoreCase("CANCEL"))
							{
								message.put("callType", "CancelCall");	
							}
							else
							{
								message.put("callType", "RaiseCall");
							}
							
							int priority=eventType.getEventPriority();
							String volLevel=eventType.getEventVolLevel();
							String colorCode=eventType.getEventColorCode();
							String colorName="";
							if(colorCode.equalsIgnoreCase("#FF0000"))
							{
								colorName="Red";
							}
							else if(colorCode.equalsIgnoreCase("#FFFF00"))
							{
								colorName="Yellow";
							}
							else
							{
								colorName="Green";
							}
							
							message.put("deviceAddress", ""+moduleDeviceAddress);
							message.put("volLevel", volLevel);
							message.put("color", colorName);
							message.put("priority", "Priority"+priority);
							message.put("message", shortMessage);
							message.put("groupAddress", "All");
							sendToOutput(message.toJSONString());
							System.out.println("Message pushed to OM012 queue for Output Device:-"+moduleDevice.getAssignedName());
						}
						else
						{	
						int responseCode=eventProcessor.sendRequest(this.requestId, moduleAddress, moduleDeviceAddress);
						if(responseCode==200)
						{	
						System.out.println("Message sent for Output Device:-"+moduleDevice.getAssignedName()); 
						}
						else
						{
							System.out.println("Unable to send Message!");
						}
						}
					 }
					  System.out.println("<---------------Processing Rule Escalation Level "+ruleEsc.getEscLevel()+"--------------->");
					}
					Thread.sleep(rule.getRepeatInterval()*8000);
				} 
		  }
	}
}
catch(Exception e)
{
System.out.println("Exception in processing Rule:-"+e);	
}
}


public void sendToOutput(String msg){
	try
	{
	messageDelegator.processMessageOut(msg.getBytes());
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}

}
