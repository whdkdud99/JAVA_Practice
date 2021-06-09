package kr.ac.inha.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.inha.mvc.service.JspService;

@Controller

public class JspController {
	
	@Autowired // 모든 객체들을 연결시켜줌
	
	// Controller&Service 연결 step 1
	JspService jspService;
	
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
	
	@RequestMapping("/gugudan")
	public ModelAndView gugudan(Integer num) { // 반드시 파라미터 넣어야함 -> 안하면 화이트 라벨 오류 창 뜸
		// 예외처리 : int num -> Integer num 사용 (Integer 은 null 도 받을 수 있음)
		ModelAndView mv = new ModelAndView();
		mv.setViewName("gugudan"); // 호출할 jsp 파일 이름
		//예외처리
		if (num != null) 
		{ // if 문 사용
			
			String result = "구구단 : ";
			for (int i = 1; i <= 9; i++) {
				result = result + num + "*" + i + "=" + (num * i) + " ";
			}
			// gugudan.jsp에 넘길 변수이름과 값 : gugu 라는 변수를 생성하고 해당 변수 안에 result 값을 넣어서 보냄
			mv.addObject("gugu", result);
			mv.addObject("title", "구구단 결과");
		}
		return mv;
		
	}
	
	@RequestMapping("/board.do")
	
	// 새로운 어노테이션 파라미터의 디폴트 값을 정함
	public ModelAndView board(@RequestParam(value = "title", required=false, defaultValue = "과목정보") String subNm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board");
		mv.addObject("title", subNm);
		
		// Service 활용 예시 (페이지호출 카운터)
		// jspService = new JspService(); // -> new 하면 게속 count 0 유지 => 맨위 처음 부분에 @Autowired 추가
		mv.addObject("count", jspService.count()); // board jsp 파일 title 로 연결
		
		return mv;
	}
}
