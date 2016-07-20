package zhulin.project.qyyportal.config;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.*;
import zhulin.project.qyyportal.data.DeviceTypeManager;
import zhulin.project.qyyportal.data.DeviceTypeService;
import zhulin.project.qyyportal.data.DeviceManager;
import zhulin.project.qyyportal.data.DeviceService;

@Configuration
public class RootConfig {
	@Bean
	public DeviceTypeManager deviceTypeManager(){
		return new DeviceTypeService("http://www.i-qyy.com:8080/devicemanager-1.0/");
	}
	
	@Bean
	public DeviceManager deviceManager(){
		return new DeviceService("http://www.i-qyy.com:8080/devicemanager-1.0/");
	}

}
