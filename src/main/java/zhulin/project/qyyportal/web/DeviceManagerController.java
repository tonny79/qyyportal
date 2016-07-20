package zhulin.project.qyyportal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import zhulin.project.qyyportal.data.DeviceTypeManager;
import zhulin.project.qyyportal.data.DeviceManager;

@Controller
@RequestMapping("/devicemanager")
public class DeviceManagerController {
	private DeviceTypeManager deviceTypeManager;
	private DeviceManager deviceManager;
	
	@Autowired
	public DeviceManagerController(DeviceTypeManager deviceTypeManager,DeviceManager deviceManager){
		this.deviceTypeManager=deviceTypeManager;
		this.deviceManager=deviceManager;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(@RequestParam(value="type", defaultValue="Test") String deviceType, Model model){
		model.addAttribute(deviceTypeManager.loadDeviceTypes());
		model.addAttribute(deviceManager.loadDevices(deviceType));
		
		return "devicemanager";
	}
}
