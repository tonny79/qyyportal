package zhulin.project.qyyportal.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	@RequestMapping(value="/",method=GET)
	public String home(){
		return "home";
	}
}
