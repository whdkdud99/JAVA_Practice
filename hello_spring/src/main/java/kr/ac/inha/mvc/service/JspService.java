package kr.ac.inha.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class JspService {
	//Dao 에 해당하는 어노테이션을 사용
	int count = 0;
	public String count() {
		return count++ + "";
	}
}
