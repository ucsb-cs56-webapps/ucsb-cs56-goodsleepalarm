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
	public String page1() {
		return "Input Schedule";
	}

	@RequestMapping("/View Schedule")
	public String page2() {
		return "View Schedule";
	}

	@RequestMapping("/Alarm For One Day")
	public String page3() {
		return "Alarm For One Day";
	}

	@RequestMapping("/User Settings")
	public String page4() {
		return "User Settings";
	}

							
}

