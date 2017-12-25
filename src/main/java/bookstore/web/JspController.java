package bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

	@RequestMapping ("/hello")
	public String getHello() {
		//ModelAndView mav = new ModelAndView("")
		return "hello1";
	}
}
