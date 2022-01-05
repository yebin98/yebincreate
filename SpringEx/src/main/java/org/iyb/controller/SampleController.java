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
	//���� ������ @GetMapping("") �̷��� ����� �� �ִ�.
	@RequestMapping(value="", method = RequestMethod.GET)
	public void basic(Model model) {
		logger.info("sample �����.");
//		System.out.println(); ��������
		//aaaa���ڿ��� abcd������ �����Ͽ� sample.jsp�� ������
		model.addAttribute("abcd", "aaaa");
	}
	//@RequestMapping(value="ex01", method = RequestMethod.GET)
	@GetMapping("ex01")
	public String basic1(Model model1) {
		logger.info("sample/ex01 �����.");
		//bbbb���ڿ��� zzzz������ �����Ͽ� ex01.jsp�� ������
		model1.addAttribute("zzzz", "bbbb");
		return "ex01";
		
	}
	//@RequestMapping(value="index", method =RequestMethod.GET)
	@GetMapping("index")
	public String index(Model model2) {
		//cccc���ڿ��� yyyy������ �����Ͽ� index.jsp�� ������
		model2.addAttribute("yyyy", "cccc");
		//return�� ������ value����.jsp�� �ٴ´�.
		return "index";
	}
	
	//RequestMapping(value="member", method =RequestMethod.GET)
	@GetMapping("member")
	public String member(String id, String pw, String name, Model model3) {
		System.out.println("id="+id);
		System.out.println("pw="+pw);
		System.out.println("name="+name);
		
		//id���� id������ �����Ͽ� member.jsp�� ������
		model3.addAttribute("id", id);
		//pw���� pw������ �������� member.jsp�� ������
		model3.addAttribute("pw", pw);
		//name���� name������ �������� member.jsp�� ������
		model3.addAttribute("name", name);
		
		return "member";
	}
	
//	//@RequestMapping(value="memberDTO", method =RequestMethod.GET)
//	@GetMapping("memberDTO")
//	public void member(SampleMemberDTO smd) {
//		System.out.println("id="+smd.getId());
//		System.out.println("pw="+smd.getPw());
//		System.out.println("name="+smd.getName());
//	} // ������� ������ �޸��� ȿ������ ���� �𵨿� �����͸� private�� �ۼ��Ͽ� ������ �پ��.
	
	//@RequestMapping(value="memberDTO", method =RequestMethod.POST)
	@PostMapping("memberDTO")
	public String memberdto(SampleMemberDTO smd, Model model4) {
		System.out.println("id="+smd.getId());
		System.out.println("pw="+smd.getPw());
		System.out.println("name="+smd.getName());
			
		//SampleMemberDTO���� id������ �������� index.jsp�� ������
		model4.addAttribute("id", smd);
		//return "memberDTO";//��Ʈ�ѷ����� memberDTO.jsp�� �̵�
		//return "redirect:�ѱ���� �ϴ� ��Ʈ�ѷ��� value��";
		//return "redirect:/";//��Ʈ�ѷ����� HomeController��Ʈ�ѷ��� �̵�
		return "redirect:/sample/member";
	}
	
	@RequestMapping(value="container1", method =RequestMethod.GET)
	public void container1() {// �Ű������� domain�� �ϳ��� ������
	}
	
	@RequestMapping(value="container2", method =RequestMethod.GET)
	public void container2() {
	}
}

