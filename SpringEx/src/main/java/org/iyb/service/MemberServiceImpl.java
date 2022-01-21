package org.iyb.service;

import org.iyb.domain.MemberDTO;
import org.iyb.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{//MemberService와 연결
	@Autowired
	private MemberMapper mmapper;//MemberMapper와 연결
	//회원가입 설계된 것을 구현
	public void insert(MemberDTO mdto) {
		mmapper.insert(mdto);
	}
	//로그인 설계된 것을 구현
	public MemberDTO login(MemberDTO mdto) {
		return mmapper.login(mdto);
	}
}
