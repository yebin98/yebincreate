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
	private MemberService mservice;//MemberController랑 MemberService랑 연결
	//회원가입 화면을 이동
	@GetMapping("member")
	public void write() {
		System.out.println("member/member");
	}
	//회원가입 화면을 통해 얻어진 데이터 insert
	@PostMapping("member")
	public void Postmember(MemberDTO mdto) {
		mservice.insert(mdto);//MemberController랑 MemberService랑 연결
	}
	//로그인 화면 이동
	@GetMapping("login")
	public void login() {
		System.out.println("member/login");
	}
	//로그인 화면을 통해 얻어진 데이터를 활용하여 select
	@PostMapping("login")
	public String Postlogin(MemberDTO mdto, HttpSession session) {//return은 if문, else문 둘 다 있어야 한다.
		// String : return 뒤에 ""가 있으니까 String을 써야 한다.
		System.out.println(mservice.login(mdto));
		MemberDTO login = mservice.login(mdto);//MemberController랑 MemberService랑 연결
		//MemberDTO [id=dbcd, password=1234, name=정자바]를 세션영역에 login이라는 변수에 저장
		
		//model은 본인.jsp에만 데이터를 넘기고  다른.jsp에 데이터를 넘길 수 없다 session은 다른 .jsp에도 데이터를 넘길 수 있다.
//세션객체(session)에            "login"변수에, login값을 저장(setAttribute)
		session.setAttribute("login", login);
		
		//session.invalidate();//세션 초기화 : 로그아웃
		
		//session영역에 login이라는 변수에 값이 있으면 로그인 된 채로
		if(session.getAttribute("login")!=null) {//저장 되어 있는 것을 가져와야하기 때문에 session.getAttribute를 써야 함
			//메인페이지로 이동
			//alert("로그인 성공");
			return "redirect:/";// redirect:value값이 / 인 곳으로 이동해라(HomeController)
			//return "redirect:/board/list";
		}else {//session영역에 login이라는 변수에 값이 없으면(null)
			//다시 로그인 할 수 있게 로그인 페이지로 이동
			//alert('로그인 실패');
			return "redirect:/member/login";
		}
		

	}
}
