package org.iyb.mapper;

import org.iyb.domain.MemberDTO;

public interface MemberMapper {
	//ȸ������ ����
	public void insert(MemberDTO mdto);//�߻�޼���
	//�α��� ����
	public MemberDTO login(MemberDTO mdto);
}
