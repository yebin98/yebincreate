package org.iyb.service;

import org.iyb.domain.MemberDTO;
import org.iyb.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{//MemberService�� ����
	@Autowired
	private MemberMapper mmapper;//MemberMapper�� ����
	//ȸ������ ����� ���� ����
	public void insert(MemberDTO mdto) {
		mmapper.insert(mdto);
	}
	//�α��� ����� ���� ����
	public MemberDTO login(MemberDTO mdto) {
		return mmapper.login(mdto);
	}
}
