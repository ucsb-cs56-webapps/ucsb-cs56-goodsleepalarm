package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

	@RequestMapping("/InputSchedule")
    public String page1() {
        return "InputSchedule";
    }

	@RequestMapping("/ViewSchedule")
	public String page2() {
        return "ViewSchedule";
    }

	@RequestMapping("/AlarmForOneDay")
	public String page3() {
        return "AlarmForOneDay";
    }


}
