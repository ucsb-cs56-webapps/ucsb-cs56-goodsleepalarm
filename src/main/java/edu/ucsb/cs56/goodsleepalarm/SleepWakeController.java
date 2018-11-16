package edu.ucsb.cs56.goodsleepalarm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/inputschedule")
	public String calendar() {
		return "inputschedule";
	}

	@RequestMapping("/viewschedule")
	public String viewschedule() {
		return "viewschedule";
	}

	@RequestMapping("/settings")
	public String settings() {
		return "settings";
	}						
}

