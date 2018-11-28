package edu.ucsb.cs56.goodsleepalarm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SleepWakeController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/Input Schedule")
	public String calendar() {
		return "Input Schedule";
	}

	@RequestMapping("/View Schedule")
	public String upcoming() {
		return "View Schedule";
	}

	@RequestMapping("/Alarm For One Day")
	public String about() {
		return "Alarm For One Day";
	}

	@RequestMapping("/User Settings")
	public String contact() {
		return "User Settings";
	}

							
}

