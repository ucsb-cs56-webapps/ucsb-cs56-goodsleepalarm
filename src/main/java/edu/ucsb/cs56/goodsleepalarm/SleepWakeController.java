package edu.ucsb.cs56.goodsleepalarm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute ;
import java.util.Map ;
import java.util.HashMap ;

@Controller
public class SleepWakeController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/InputSchedule")
	public String page1() {
		return "InputSchedule";
	}

    // @RequestMapping(value="user", method = RequestMethod.GET)
    // public @ResponseBody item getitem(@RequestParam("data") String itemid){

    //     item i = itemDao.findOne(itemid);              
    //     String itemname = i.getItemname();
    //     String price = i.getPrice();
    //     return i;
    // }
	@RequestMapping("/ViewSchedule")
	public @ResponseBody ModelAndView page2(@ModelAttribute("sm") SleepModel sm) {
        Map<String, Object> params = new HashMap<>();
        params.put("sm", sm);
		return new ModelAndView("ViewSchedule", params) ;
	}

	@RequestMapping("/AlarmForOneDay")
	public String page3() {
		return "AlarmForOneDay";
	}

	@RequestMapping("/UserSettings")
	public String page4() {
		return "UserSettings";
	}

}

