package com.sudosmith.aptus.event.processor;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudosmith.aptus.model.ColorCode;
import com.sudosmith.aptus.model.EventRegister;
import com.sudosmith.aptus.model.EventType;
import com.sudosmith.aptus.model.FacilityBuildingFloor;
import com.sudosmith.aptus.model.FacilityFloorWing;
import com.sudosmith.aptus.model.FacilitySite;
import com.sudosmith.aptus.model.FacilitySiteBuilding;
import com.sudosmith.aptus.model.FacilityWingRoom;
import com.sudosmith.aptus.model.Message;
import com.sudosmith.aptus.model.Module;
import com.sudosmith.aptus.model.ModuleDevice;
import com.sudosmith.aptus.model.ModuleInput;
import com.sudosmith.aptus.model.ModuleInputMessage;
import com.sudosmith.aptus.model.OutputDeviceConfig;
import com.sudosmith.aptus.model.Request;
import com.sudosmith.aptus.model.Rule;
import com.sudosmith.aptus.model.RuleEsc;
import com.sudosmith.aptus.model.RuleEscGroupOutputDevice;
import com.sudosmith.aptus.model.RuleEventType;
import com.sudosmith.aptus.model.RuleInputDevice;
import com.sudosmith.aptus.model.SupportedDevice;
import com.sudosmith.aptus.pagination.Page;
import com.sudosmith.aptus.service.ColorCodeService;
import com.sudosmith.aptus.service.EventRegisterService;
import com.sudosmith.aptus.service.EventTypeService;
import com.sudosmith.aptus.service.FacilityBuildingFloorService;
import com.sudosmith.aptus.service.FacilityFloorWingService;
import com.sudosmith.aptus.service.FacilitySiteBuildingService;
import com.sudosmith.aptus.service.FacilitySiteService;
import com.sudosmith.aptus.service.FacilityWingRoomService;
import com.sudosmith.aptus.service.MessageService;
import com.sudosmith.aptus.service.ModuleDeviceService;
import com.sudosmith.aptus.service.ModuleInputMessageService;
import com.sudosmith.aptus.service.ModuleInputService;
import com.sudosmith.aptus.service.ModuleService;
import com.sudosmith.aptus.service.OutputDeviceConfigService;
import com.sudosmith.aptus.service.RequestService;
import com.sudosmith.aptus.service.RuleEscGroupOutputDeviceService;
import com.sudosmith.aptus.service.RuleEscService;
import com.sudosmith.aptus.service.RuleEventTypeService;
import com.sudosmith.aptus.service.RuleInputDeviceService;
import com.sudosmith.aptus.service.RuleService;
import com.sudosmith.aptus.service.SupportedDeviceService;


@Service
public class EventProcessor {
    
	@Autowired 
	private RuleService ruleService;
	
	@Autowired 
	private RuleInputDeviceService ruleInputDeviceService;
	
	@Autowired 
	private RuleEventTypeService ruleEventTypeService;	
	
	@Autowired 
	private RuleEscService ruleEscService;
	
	@Autowired 
	private EventRegisterService eventRegisterService;	
	
	@Autowired 
	private RuleEscGroupOutputDeviceService ruleOutputDeviceService;	
	
	@Autowired 
	private ModuleService moduleService;	
	
	@Autowired 
	private ModuleDeviceService moduleDeviceService;
	
	@Autowired 
	private ModuleInputService moduleInputService;
	
	@Autowired 
	private ModuleInputMessageService moduleInputMessageService;
	
	@Autowired 
	private OutputDeviceConfigService outputDeviceConfigService;	
	
	@Autowired 
	private FacilitySiteService facilitySiteService;
	
	@Autowired 
	private FacilitySiteBuildingService facilitySiteBuildingService;	
	
	@Autowired 
	private FacilityBuildingFloorService facilityBuildingFloorService;
	
	@Autowired 
	private FacilityFloorWingService facilityFloorWingService;
	
	@Autowired 
	private FacilityWingRoomService facilityWingRoomService;
	
	@Autowired 
	private RequestService requestLogService;		
	
	@Autowired 
	private MessageService messageService;		
	
	@Autowired 
	private SupportedDeviceService deviceService;	
	
	@Autowired 
	private ColorCodeService colorCodeService;		
	
	@Autowired 
	private EventTypeService eventTypeService;			
		
	private final String USER_AGENT = "Mozilla/5.0";
	
	public EventRegister findEventRegisterByRequestId(String requestId)
	{ 
		
		  EventRegister eventRegister=null;
		  List<EventRegister> eventRegisterList = new ArrayList<EventRegister>();
		  Page page=new Page();
		  Map<String, Object> queryParameter = new HashMap<String, Object>();
		  queryParameter.put("queryString", requestId);
		  eventRegisterList=eventRegisterService.findEventRegisterByRequestId(queryParameter, page);
		  for(int i=0;i<eventRegisterList.size();i++)
		  {
			eventRegister=eventRegisterList.get(i);  
		  }
		  return eventRegister;
	}

	
	public SupportedDevice getSupportedDeviceById(int deviceId)
	{
		SupportedDevice device=null;
		try
		{
			device=deviceService.findDeviceById(deviceId);
		}
		catch(Exception e)
		{
		 System.out.println(e);
		}
	    return device;
	}	
	
	public Rule getRuleByRuleId(int ruleId)
	{
		Rule rule=null;
		try
		{
		rule=ruleService.findRuleById(ruleId);
		}
		catch(Exception e)
		{
		 System.out.println(e);
		}
	    return rule;
	}
	
	
	public List<Rule> getRulesList(int eventTypeId,int inDeviceId)
	{
		List<Rule> ruleList1 = new ArrayList<Rule>();
		/////////GETTING THE CURRENT DAY/////////////////
		int day1=getToday();
		System.out.println("Today is:- "+day1);
		////////GETTING THE CURRENT TIME////////////////
		DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		String currTime=timeFormat.format(date);
		System.out.println("Time is:- "+currTime);
		
		///////// GETTING RULE BASED ON EVENT_TYPE,DAY,INPUT_DEVICE,EVENT_START_TIME,EVENT_END_TIME///////////////// 
		System.out.println("Reading the rules...");
		try
		{		
			  List<Rule> ruleList = new ArrayList<Rule>();
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString1", day1);
			  queryParameter.put("queryString2", currTime);
			  queryParameter.put("queryString3", currTime);
			  ruleList=ruleService.findRuleByDayTime(queryParameter, page);
			  for(int i=0;i<ruleList.size();i++)
			  {
				 
				 Rule rule=ruleList.get(i);
				 int ruleId=rule.getId();
				 
				 List<RuleEventType> ruleEventTypeList = new ArrayList<RuleEventType>();
				 Map<String, Object> queryParameter1 = new HashMap<String, Object>();
				 queryParameter1.put("queryString1", ruleId);
				 queryParameter1.put("queryString2", eventTypeId);
				 ruleEventTypeList=ruleEventTypeService.findRuleEventTypeByRuleEventId(queryParameter1, page);
				 
				 List<RuleInputDevice> ruleInputDeviceList = new ArrayList<RuleInputDevice>();
				 Map<String, Object> queryParameter2 = new HashMap<String, Object>();
				 queryParameter2.put("queryString1", ruleId);
				 queryParameter2.put("queryString2", inDeviceId);
				 ruleInputDeviceList=ruleInputDeviceService.findRuleInputDeviceByRuleDeviceId(queryParameter2, page);
				 
				 if(ruleEventTypeList.size()>0 && ruleInputDeviceList.size()>0)
				 {
					 ruleList1.add(rule);
					 System.out.println("Rule id is: "+rule.getId()+"Event Start Time is " + rule.getEventStartTime());
				 }
				 
			  }	  
		}
		catch(Exception e)
		{
		System.out.println("Exception while reading the rule..."+e);	
		}		
		return ruleList1;
	}		
	
	
   
   public int findSupportedDeviceIdByAdapterName(String adapterName)
   {
	int deviceId=0;
	List<SupportedDevice> deviceList = new ArrayList<SupportedDevice>();
	try
	{		
		  Page page=new Page();
		  Map<String, Object> queryParameter = new HashMap<String, Object>();
		  queryParameter.put("queryString", adapterName);
		  deviceList=deviceService.findSupportedDeviceByDeviceAdapter(queryParameter, page);
		  for(int i=0;i<deviceList.size();i++)
		  {
			SupportedDevice device=deviceList.get(i);
			deviceId=device.getId();
		  }
	}
	catch(Exception e)
	{
	System.out.println("Exception"+e);	
	}				
	return deviceId;   
   }
	
	

	public List<RuleEsc> getRuleEscalations(int ruleId)
	{
		List<RuleEsc> ruleEscList = new ArrayList<RuleEsc>();
		System.out.println("Reading the rule Escalations...");
		try
		{		
			  Page page=new Page();
			  page.setRecordPerPage(200);
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString", ruleId);
			  ruleEscList=ruleEscService.findRuleEscByRuleId(queryParameter, page);  
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}			
		return  ruleEscList;
	}


	
	public List<RuleEscGroupOutputDevice> getRuleOutputDevices(int ruleId,int ruleEscId)
	{
		List<RuleEscGroupOutputDevice> ruleOutputDeviceList = new ArrayList<RuleEscGroupOutputDevice>();
		System.out.println("Reading the rule Output Devices...");
		try
		{	
			  Page page=new Page();
			  page.setRecordPerPage(200);
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString1", ruleId);
			  queryParameter.put("queryString2", ruleEscId);
			  ruleOutputDeviceList=ruleOutputDeviceService.findRuleEscGroupOutputDeviceByRuleId(queryParameter, page);  
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return ruleOutputDeviceList;
	}

	
	public EventType getEventByEventId(int eventTypeId)
	{   
		EventType eventType=null;
		try
		{
			eventType=eventTypeService.findEventTypeById(eventTypeId);
		}
		catch(Exception e)
		{
		 System.out.println(e);
		}
	    return eventType;
	}
	

	public String getColorNameByColorId(int colorCodeId)
	{   
		String colorName="";
		try
		{
			ColorCode colorCode=colorCodeService.findColorCodeById(colorCodeId);
			colorName=colorCode.getColorName();
		}
		catch(Exception e)
		{
		 System.out.println(e);
		}
	    return colorName;
	}
	
	
	public OutputDeviceConfig getOuptutDeviceConfigByDeviceId(int deviceId)
	{   
		OutputDeviceConfig outputDeviceConfig=null;
		boolean flg=false;
		List<OutputDeviceConfig> outputDeviceConfigList = new ArrayList<OutputDeviceConfig>();
		try
		{		
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString", deviceId);
			  outputDeviceConfigList=outputDeviceConfigService.findByDeviceId(queryParameter, page);
			  for(int i=0;i<outputDeviceConfigList.size();i++)
			  {
				  outputDeviceConfig=outputDeviceConfigList.get(i); 
			  }
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return outputDeviceConfig;
	}	
	

	public boolean shortMessageSupport(int deviceId)
	{   
		boolean flg=false;
		List<OutputDeviceConfig> outputDeviceConfigList = new ArrayList<OutputDeviceConfig>();
		try
		{		
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString", deviceId);
			  outputDeviceConfigList=outputDeviceConfigService.findByDeviceId(queryParameter, page);
			  OutputDeviceConfig outputDeviceConfig=new OutputDeviceConfig();
			  for(int i=0;i<outputDeviceConfigList.size();i++)
			  {
				  outputDeviceConfig=outputDeviceConfigList.get(i);
				  flg=outputDeviceConfig.isShortMsg();
			  }
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return flg;
	}	

	

	public boolean longMessageSupport(int deviceId)
	{   
		boolean flg=false;
		List<OutputDeviceConfig> outputDeviceConfigList = new ArrayList<OutputDeviceConfig>();
		try
		{		
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString", deviceId);
			  outputDeviceConfigList=outputDeviceConfigService.findByDeviceId(queryParameter, page);
			  OutputDeviceConfig outputDeviceConfig=new OutputDeviceConfig();
			  for(int i=0;i<outputDeviceConfigList.size();i++)
			  {
				  outputDeviceConfig=outputDeviceConfigList.get(i);
				  flg=outputDeviceConfig.isLongMsg();
			  }
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return flg;
	}



	public boolean cancelMessageSupport(int deviceId)
	{   
		boolean flg=false;
		List<OutputDeviceConfig> outputDeviceConfigList = new ArrayList<OutputDeviceConfig>();
		try
		{		
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString", deviceId);
			  outputDeviceConfigList=outputDeviceConfigService.findByDeviceId(queryParameter, page);
			  OutputDeviceConfig outputDeviceConfig=new OutputDeviceConfig();
			  for(int i=0;i<outputDeviceConfigList.size();i++)
			  {
				  outputDeviceConfig=outputDeviceConfigList.get(i);
				  flg=outputDeviceConfig.isCancelMsg();
			  }
			  
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return flg;
	}

	
	
	public String getInputShortMessage(int deviceId,int eventId)
	{   
		String initMsg=null;
		System.out.println("Getting Short Message..");
		
		List<ModuleInput> moduleInputList = new ArrayList<ModuleInput>();
		try
		{	
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString1", deviceId);
			  queryParameter.put("queryString2", eventId);
			  moduleInputList=moduleInputService.findModuleInputByModuleDeviceEventId(queryParameter, page); 
			  for(int i=0;i<moduleInputList.size();i++)
			  {
				  ModuleInput moduleInput=moduleInputList.get(i);
				  int moduleInputId=moduleInput.getId();
				  
				  List<ModuleInputMessage> moduleInputMessageList = new ArrayList<ModuleInputMessage>();
				  Map<String, Object> queryParameter1 = new HashMap<String, Object>();
				  queryParameter1.put("queryString", moduleInputId);
				  moduleInputMessageList=moduleInputMessageService.findModuleInputMessageByInputId(queryParameter1, page);
				  for(int n=0;n<moduleInputMessageList.size();n++)
				  {
					  ModuleInputMessage moduleInputMessage=moduleInputMessageList.get(n);
					  initMsg=moduleInputMessage.getShortMsg();
				  }
				  
			  }
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}		
		return initMsg;
	}
	
	
	
	public String getInputLongMessage(int deviceId,int eventId)
	{   
		String initMsg=null;
		System.out.println("Getting Long Message..");
		
		List<ModuleInput> moduleInputList = new ArrayList<ModuleInput>();
		try
		{	
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString1", deviceId);
			  queryParameter.put("queryString2", eventId);
			  moduleInputList=moduleInputService.findModuleInputByModuleDeviceEventId(queryParameter, page); 
			  for(int i=0;i<moduleInputList.size();i++)
			  {
				  ModuleInput moduleInput=moduleInputList.get(i);
				  int moduleInputId=moduleInput.getId();
				  
				  List<ModuleInputMessage> moduleInputMessageList = new ArrayList<ModuleInputMessage>();
				  Map<String, Object> queryParameter1 = new HashMap<String, Object>();
				  queryParameter1.put("queryString", moduleInputId);
				  moduleInputMessageList=moduleInputMessageService.findModuleInputMessageByInputId(queryParameter1, page);
				  for(int n=0;n<moduleInputMessageList.size();n++)
				  {
					  ModuleInputMessage moduleInputMessage=moduleInputMessageList.get(n);
					  initMsg=moduleInputMessage.getLongMsg();
				  }
				  
			  }
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}		
		return initMsg;
	}	
	
	
	
	public String getShortMessage(int deviceId,int eventId,int siteId,int buildingId,int floorId,int wingId,int roomId)
	{   
		String msg=null;
		String initMsg=null;
		System.out.println("Creating Short Message..");
		
		List<ModuleInput> moduleInputList = new ArrayList<ModuleInput>();
		try
		{	
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString1", deviceId);
			  queryParameter.put("queryString2", eventId);
			  moduleInputList=moduleInputService.findModuleInputByModuleDeviceEventId(queryParameter, page); 
			  for(int i=0;i<moduleInputList.size();i++)
			  {
				  ModuleInput moduleInput=moduleInputList.get(i);
				  int moduleInputId=moduleInput.getId();
				  
				  List<ModuleInputMessage> moduleInputMessageList = new ArrayList<ModuleInputMessage>();
				  Map<String, Object> queryParameter1 = new HashMap<String, Object>();
				  queryParameter1.put("queryString", moduleInputId);
				  moduleInputMessageList=moduleInputMessageService.findModuleInputMessageByInputId(queryParameter1, page);
				  for(int n=0;n<moduleInputMessageList.size();n++)
				  {
					  ModuleInputMessage moduleInputMessage=moduleInputMessageList.get(n);
					  initMsg=moduleInputMessage.getShortMsg();
				  }
				  
			  }
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		msg=initMsg+" "+getSiteShortMessage(siteId)+" "+getBuildingShortMessage(buildingId)+" "+getFloorShortMessage(floorId)+" "+getWingShortMessage(wingId)+" "+getRoomShortMessage(roomId);	
		return msg;
	}

	
	public String getSiteShortMessage(int siteId)
	{   
		String msg=null;
		try
		{
		FacilitySite facilitySite=facilitySiteService.findFacilitySiteById(siteId);	
		msg=facilitySite.getSiteShortMsg();
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return msg;
	}

	
	public String getSiteLongMessage(int siteId)
	{   
		String msg=null;
		try
		{		
		    FacilitySite facilitySite=facilitySiteService.findFacilitySiteById(siteId);	
			msg=facilitySite.getSiteLongMsg();	
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return msg;
	}

	
	public String getBuildingShortMessage(int buildingId)
	{   
		String msg=null;
		try
		{
			FacilitySiteBuilding facilitySiteBuilding=facilitySiteBuildingService.findSiteBuildingById(buildingId);	
			msg=facilitySiteBuilding.getBuildingShortMsg();		
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return msg;
	}

	
	public String getBuildingLongMessage(int buildingId)
	{   
		String msg=null;
		try
		{		
			FacilitySiteBuilding facilitySiteBuilding=facilitySiteBuildingService.findSiteBuildingById(buildingId);	
			msg=facilitySiteBuilding.getBuildingLongMsg();					
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return msg;
	}

	
	public String getFloorShortMessage(int floorId)
	{   
		String msg=null;
		try
		{		
			FacilityBuildingFloor facilityBuildingFloor=facilityBuildingFloorService.findBuildingFloorById(floorId);	
			msg=facilityBuildingFloor.getFloorShortMsg();	
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return msg;
	}

	
	public String getFloorLongMessage(int floorId)
	{   
		String msg=null;
		try
		{		
			FacilityBuildingFloor facilityBuildingFloor=facilityBuildingFloorService.findBuildingFloorById(floorId);	
			msg=facilityBuildingFloor.getFloorLongMsg();
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return msg;
	}

	
	public String getWingShortMessage(int wingId)
	{   
		String msg=null;
		try
		{	
			FacilityFloorWing facilityFloorWing=facilityFloorWingService.findFloorWingById(wingId);	
			msg=facilityFloorWing.getWingShortMsg();
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return msg;
	}

	
	public String getWingLongMessage(int wingId)
	{   
		String msg=null;
		try
		{
			FacilityFloorWing facilityFloorWing=facilityFloorWingService.findFloorWingById(wingId);	
			msg=facilityFloorWing.getWingLongMsg();			
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return msg;
	}

	
	public String getRoomShortMessage(int roomId)
	{   
		String msg=null;
		try
		{		
			FacilityWingRoom facilityWingRoom=facilityWingRoomService.findWingRoomById(roomId);	
			msg=facilityWingRoom.getRoomShortMsg();						
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return msg;
	}

	
	public String getRoomLongMessage(int roomId)
	{   
		String msg=null;
		try
		{
			FacilityWingRoom facilityWingRoom=facilityWingRoomService.findWingRoomById(roomId);	
			msg=facilityWingRoom.getRoomLongMsg();		
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return msg;
	}

	
	public String getLongMessage(int deviceId,int eventId,int siteId,int buildingId,int floorId,int wingId,int roomId)
	{   
		String msg=null;
		String initMsg=null;
		System.out.println("Creating Long Message..");
		List<ModuleInput> moduleInputList = new ArrayList<ModuleInput>();
		try
		{	
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString1", deviceId);
			  queryParameter.put("queryString2", eventId);
			  moduleInputList=moduleInputService.findModuleInputByModuleDeviceEventId(queryParameter, page); 
			  for(int i=0;i<moduleInputList.size();i++)
			  {
				  ModuleInput moduleInput=moduleInputList.get(i);
				  int moduleInputId=moduleInput.getId();
				  
				  List<ModuleInputMessage> moduleInputMessageList = new ArrayList<ModuleInputMessage>();
				  Map<String, Object> queryParameter1 = new HashMap<String, Object>();
				  queryParameter1.put("queryString", moduleInputId);
				  moduleInputMessageList=moduleInputMessageService.findModuleInputMessageByInputId(queryParameter1, page);
				  for(int n=0;n<moduleInputMessageList.size();n++)
				  {
					  ModuleInputMessage moduleInputMessage=moduleInputMessageList.get(n);
					  initMsg=moduleInputMessage.getLongMsg();
				  }
				  
			  }
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		msg=initMsg+" "+getSiteLongMessage(siteId)+" "+getBuildingLongMessage(buildingId)+" "+getFloorLongMessage(floorId)+" "+getWingLongMessage(wingId)+" "+getRoomLongMessage(roomId);
		return msg;
	}

		
	public String getCancelMessage(int deviceId,int eventId)
	{   
		String msg=null;
		List<ModuleInput> moduleInputList = new ArrayList<ModuleInput>();
		try
		{	
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString1", deviceId);
			  queryParameter.put("queryString2", eventId);
			  moduleInputList=moduleInputService.findModuleInputByModuleDeviceEventId(queryParameter, page); 
			  for(int i=0;i<moduleInputList.size();i++)
			  {
				  ModuleInput moduleInput=moduleInputList.get(i);
				  int moduleInputId=moduleInput.getId();
				  
				  List<ModuleInputMessage> moduleInputMessageList = new ArrayList<ModuleInputMessage>();
				  Map<String, Object> queryParameter1 = new HashMap<String, Object>();
				  queryParameter1.put("queryString", moduleInputId);
				  moduleInputMessageList=moduleInputMessageService.findModuleInputMessageByInputId(queryParameter1, page);
				  for(int n=0;n<moduleInputMessageList.size();n++)
				  {
					  ModuleInputMessage moduleInputMessage=moduleInputMessageList.get(n);
					  msg=moduleInputMessage.getCancelMsg();
				  }
				  
			  }
		}
		catch(Exception e)
		{
		System.out.println("Exception"+e);	
		}	
		return msg;
	}

	
	
	public boolean isResponseRecieved(String requestId)
	{  
		System.out.println("Checking whether response recieved or not...");
		boolean flg=false;
		List<Request> requestList = new ArrayList<Request>();
		try
		{	
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString1", requestId);
			  queryParameter.put("queryString2", true);
			  requestList=requestLogService.findRequestByRequestIdResponse(queryParameter, page); 
		      for(int i=0;i<requestList.size();i++)
		      {
		    	  Request request=requestList.get(i);
		    	  flg=true;
		      }
		}
		catch(Exception e)
		{
		  System.out.println("Exception while checking Response Recieved"+e);	
		}	
		return flg;
	}
	
	
	
	public void storeMessage(String requestId,String longMessage,String shortMessage)
	{  
		try
		{	
			  Message message=new Message();
			  message.setRequestId(requestId);
			  message.setLm(longMessage);
			  message.setSm(shortMessage);
			  messageService.addMessage(message);
		}
		catch(Exception e)
		{
		  System.out.println("Exception while storing the Message"+e);	
		}	
	}	
	

	public boolean checkRequestInMessage(String requestId)
	{
		boolean flg=false;
		List<Message> messageList = new ArrayList<Message>();
		try
		{	
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString", requestId);
			  messageList=messageService.findMessageByRequestId(queryParameter, page);
		      for(int i=0;i<messageList.size();i++)
		      {
		    	  flg=true;
		      }
		}
		catch(Exception e)
		{
		  System.out.println("Exception while checking Request in Message... "+e);	
		}	
		return flg;
	}
	

	public boolean isInterrupted(String requestId)
	{  
		//System.out.println("Checking whether any interrupt occured or not...");
		boolean flg=false;
		List<Request> requestList = new ArrayList<Request>();
		try
		{	
			  Page page=new Page();
			  Map<String, Object> queryParameter = new HashMap<String, Object>();
			  queryParameter.put("queryString1", requestId);
			  queryParameter.put("queryString2", true);
			  requestList=requestLogService.findRequestByRequestIdInterrupt(queryParameter, page); 
		      for(int i=0;i<requestList.size();i++)
		      {
		    	  Request request=requestList.get(i);
		    	  flg=true;
		      }
		}
		catch(Exception e)
		{
		  System.out.println("Exception while checking interrupt... "+e);	
		}	
		return flg;
	}	
	
	
	
	public int sendRequest(String requestId,String moduleAddress,String moduleDeviceAddress) throws Exception {
			 
		String url = "http://"+moduleAddress+moduleDeviceAddress+"/index.php/"+requestId+"";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode=con.getResponseCode();
		return responseCode;
	}	
	
	
	public Module findModuleById(int moduleId)
	{
		Module module=null;
		try
		{
			module=moduleService.findModuleById(moduleId);
		}
		catch(Exception e)
		{
			System.out.println("Exception while getting moduleDeviceById "+e);
		}
		return module;
	}	
	
	
	
	private int getToday()
	{
	Calendar calendar = Calendar.getInstance();
	int day = calendar.get(Calendar.DAY_OF_WEEK); 	
	return day;
	}	
	
}
