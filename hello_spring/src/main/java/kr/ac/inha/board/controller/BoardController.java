package kr.ac.inha.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 필요없는 import 삭제 단축키 : Ctrl + Shift +  o

// 어노테이션 사용 (1)
@RestController // Spring Project 에서 RestController 역할을 하도록 지정 (파일 import)

public class BoardController {
	
	// 어노테이션 사용 (2)
	@RequestMapping("/hello1") // /hello 라는 주소갑 입력을 통한 요청을 받으면 hello() 실행
	// http://localhost:8080/hello 입력시 확인 가능
	
	// 서버의 요청을 받을 때 hello world! 를 출력 (서버를 열때 바로 실행이 아니라 요청해야 수행됨)
	public String hello() { //매서드 생성
		return "hello world!";
	}
	
	// 파라미터를 받아서 값을 return 해주는 프로그램 작성
	// 연습문제1 : inha 라는 주소로 접근 시 학교 홈페이지 주소를 보여주는 프로그램을 작성하시오
	@RequestMapping("/inha")
	public String inha(String parameter) {
		return parameter + "inha.ac.kr";
		// 요청 방식 (?변수이름 = 넣을 값)_대표적 get 기능 : http://localhost:8080/inha?parameter=www.
	}
	// 연습문제2 : name 이라는 주소로 접근하고 id라는 파라메터로 학번을 입력받아 입력한 학번을 출력해주는 프로그램을 작성하시오
	@RequestMapping("/name")
	public String name(String id) {
		return "당신의 학번은 : " + id + "입니다!";
	}
	// 연습문제3 : Spring 프로젝트를 활용하여 구구단의 숫자를 입력 받고 출력해주는 프로그램 작성
	@RequestMapping("/hello")
	public String hello(Integer num) {
		String result_list = "";
		for (int i = 1; i <= 9; i++) {
			String result = Integer.toString(num*i);
			String str_num = Integer.toString(num);
			String str_i = Integer.toString(i);
			String add = str_num + "*" + str_i + "=" + result;
			
			result_list = result_list + " " + add;
		}
		return result_list;
		
	}
	
}
