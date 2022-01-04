package org.iyb.controller;

import org.iyb.domain.SampleMemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value="sample", method = RequestMethod.GET)
	public void basic() {
		logger.info("sample 실행됨.");
//		System.out.println(); 같은거임
	}
	@RequestMapping(value="sample/ex01", method = RequestMethod.GET)
	public String basic1() {
		logger.info("sample/ex01 실행됨.");
		return "ex01";
	}
	@RequestMapping(value="sample/index", method =RequestMethod.GET)
	public String index() {
		//return이 없으면 value값에.jsp가 붙는다.
		return "index";
	}
	
	@RequestMapping(value="sample/member", method =RequestMethod.GET)
	public String member(String id, String pw, String name) {
		System.out.println("id="+id);
		System.out.println("pw="+pw);
		System.out.println("name="+name);
		return "member";
	}
	
	@RequestMapping(value="sample/memberDTO", method =RequestMethod.GET)
	public void memberdto(SampleMemberDTO smd) {
		System.out.println("id="+smd.getId());
		System.out.println("pw="+smd.getPw());
		System.out.println("name="+smd.getName());
	} // 결과값은 같지만 메모리의 효율성이 좋고 모델에 데이터를 private로 작성하여 보안이 뛰어나다.
	
	@RequestMapping(value="container1", method =RequestMethod.GET)
	public void container1() {
	}
	
	@RequestMapping(value="container2", method =RequestMethod.GET)
	public void container2() {
	}
}

