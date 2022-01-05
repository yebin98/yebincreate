package org.iyb.controller;

import org.iyb.domain.SampleMemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("sample")
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	//@RequestMapping(value="", method = RequestMethod.GET)
	//위의 내용을 @GetMapping("") 이렇게 축약할 수 있다.
	@RequestMapping(value="", method = RequestMethod.GET)
	public void basic(Model model) {
		logger.info("sample 실행됨.");
//		System.out.println(); 같은거임
		//aaaa문자열을 abcd변수에 저장하여 sample.jsp에 보내기
		model.addAttribute("abcd", "aaaa");
	}
	//@RequestMapping(value="ex01", method = RequestMethod.GET)
	@GetMapping("ex01")
	public String basic1(Model model1) {
		logger.info("sample/ex01 실행됨.");
		//bbbb문자열을 zzzz변수에 저장하여 ex01.jsp에 보내기
		model1.addAttribute("zzzz", "bbbb");
		return "ex01";
		
	}
	//@RequestMapping(value="index", method =RequestMethod.GET)
	@GetMapping("index")
	public String index(Model model2) {
		//cccc문자열을 yyyy변수에 저장하여 index.jsp에 보내기
		model2.addAttribute("yyyy", "cccc");
		//return이 없으면 value값에.jsp가 붙는다.
		return "index";
	}
	
	//RequestMapping(value="member", method =RequestMethod.GET)
	@GetMapping("member")
	public String member(String id, String pw, String name, Model model3) {
		System.out.println("id="+id);
		System.out.println("pw="+pw);
		System.out.println("name="+name);
		
		//id값을 id변수에 자장하여 member.jsp에 보내기
		model3.addAttribute("id", id);
		//pw값을 pw변수에 저장히여 member.jsp에 보내기
		model3.addAttribute("pw", pw);
		//name값을 name변수에 저장히여 member.jsp에 보내기
		model3.addAttribute("name", name);
		
		return "member";
	}
	
//	//@RequestMapping(value="memberDTO", method =RequestMethod.GET)
//	@GetMapping("memberDTO")
//	public void member(SampleMemberDTO smd) {
//		System.out.println("id="+smd.getId());
//		System.out.println("pw="+smd.getPw());
//		System.out.println("name="+smd.getName());
//	} // 결과값은 같지만 메모리의 효율성이 좋고 모델에 데이터를 private로 작성하여 보안이 뛰어나다.
	
	//@RequestMapping(value="memberDTO", method =RequestMethod.POST)
	@PostMapping("memberDTO")
	public String memberdto(SampleMemberDTO smd, Model model4) {
		System.out.println("id="+smd.getId());
		System.out.println("pw="+smd.getPw());
		System.out.println("name="+smd.getName());
			
		//SampleMemberDTO값을 id변수에 저장히여 index.jsp에 보내기
		model4.addAttribute("id", smd);
		//return "memberDTO";//컨트롤러에서 memberDTO.jsp로 이동
		//return "redirect:넘기고자 하는 컨트롤러의 value값";
		//return "redirect:/";//컨트롤러에서 HomeController컨트롤러로 이동
		return "redirect:/sample/member";
	}
	
	@RequestMapping(value="container1", method =RequestMethod.GET)
	public void container1() {// 매개변수가 domain중 하나를 선택함
	}
	
	@RequestMapping(value="container2", method =RequestMethod.GET)
	public void container2() {
	}
}

