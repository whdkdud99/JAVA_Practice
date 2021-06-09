package kr.ac.inha.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class JspController {
	@RequestMapping("/hello.do")
	public ModelAndView hellodo () {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello"); // 파일 헬로와 연동하여 보여줌
		
		return mv;
	}
	@RequestMapping("/hello.dodo")
	public String hellododo () {
		
		return "hello"; // 파일 헬로와 자동으로 modelandview 객체를 생성하여 맵핑
	}
}
