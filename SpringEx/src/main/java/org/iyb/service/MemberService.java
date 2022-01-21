package org.iyb.service;

import org.iyb.domain.MemberDTO;

public interface MemberService {
	//회원가입 설계
	public void insert(MemberDTO mdto);//추상메서드
	//로그인 설계
	public MemberDTO login(MemberDTO mdto);
}
