package bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JspController {

	@RequestMapping ( "/hello.do")
	public ModelAndView getHello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "aa bb cc");
		mav.setViewName("hello");
		return mav;
	}
	
	@RequestMapping ( "/rep/rep_hello.do")
	public ModelAndView getRepHello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "aa bb cc");
		mav.setViewName("/rep/rep_hello");
		return mav;
	}
}
