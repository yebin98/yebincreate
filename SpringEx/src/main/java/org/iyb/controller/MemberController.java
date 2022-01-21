package org.iyb.controller;

import javax.servlet.http.HttpSession;

import org.iyb.domain.MemberDTO;
import org.iyb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService mservice;//MemberController�� MemberService�� ����
	//ȸ������ ȭ���� �̵�
	@GetMapping("member")
	public void write() {
		System.out.println("member/member");
	}
	//ȸ������ ȭ���� ���� ����� ������ insert
	@PostMapping("member")
	public void Postmember(MemberDTO mdto) {
		mservice.insert(mdto);//MemberController�� MemberService�� ����
	}
	//�α��� ȭ�� �̵�
	@GetMapping("login")
	public void login() {
		System.out.println("member/login");
	}
	//�α��� ȭ���� ���� ����� �����͸� Ȱ���Ͽ� select
	@PostMapping("login")
	public String Postlogin(MemberDTO mdto, HttpSession session) {//return�� if��, else�� �� �� �־�� �Ѵ�.
		// String : return �ڿ� ""�� �����ϱ� String�� ��� �Ѵ�.
		System.out.println(mservice.login(mdto));
		MemberDTO login = mservice.login(mdto);//MemberController�� MemberService�� ����
		//MemberDTO [id=dbcd, password=1234, name=���ڹ�]�� ���ǿ����� login�̶�� ������ ����
		
		//model�� ����.jsp���� �����͸� �ѱ��  �ٸ�.jsp�� �����͸� �ѱ� �� ���� session�� �ٸ� .jsp���� �����͸� �ѱ� �� �ִ�.
//���ǰ�ü(session)��            "login"������, login���� ����(setAttribute)
		session.setAttribute("login", login);
		
		//session.invalidate();//���� �ʱ�ȭ : �α׾ƿ�
		
		//session������ login�̶�� ������ ���� ������ �α��� �� ä��
		if(session.getAttribute("login")!=null) {//���� �Ǿ� �ִ� ���� �����;��ϱ� ������ session.getAttribute�� ��� ��
			//������������ �̵�
			//alert("�α��� ����");
			return "redirect:/";// redirect:value���� / �� ������ �̵��ض�(HomeController)
			//return "redirect:/board/list";
		}else {//session������ login�̶�� ������ ���� ������(null)
			//�ٽ� �α��� �� �� �ְ� �α��� �������� �̵�
			//alert('�α��� ����');
			return "redirect:/member/login";
		}
		

	}
}
