package org.iyb.service;

import org.iyb.domain.MemberDTO;

public interface MemberService {
	//ȸ������ ����
	public void insert(MemberDTO mdto);//�߻�޼���
	//�α��� ����
	public MemberDTO login(MemberDTO mdto);
}
