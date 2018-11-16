package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	    @RequestMapping("/")
		    public String index() {
				        return "index";
						    }

			@RequestMapping("/calendar")
			    public String calendar() {
					        return "calendar";
							    }

				@RequestMapping("/upcoming")
					public String upcoming() {
						        return "upcoming";
								    }

					@RequestMapping("/about")
						public String about() {
							        return "about";
									    }

					    @RequestMapping("/contact")
						    public String contact() {
								        return "contact";
										    }

							
}

