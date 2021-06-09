package kr.ac.inha.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class JspController {
	@RequestMapping("/hello.do")
	public ModelAndView hello () {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		
		return mv;
	}
}
