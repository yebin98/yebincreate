package org.iyb.service;

import java.util.ArrayList;

import org.iyb.domain.ReplyDTO;

public interface ReplyService {
	//��� ���� ����
	public int write(ReplyDTO rdto);
	//��� ��� ����Ʈ ����
	public ArrayList<ReplyDTO> list(int bno);
	//��� ������ �ϱ� ���� ��� ������ �������¼���
	public ReplyDTO detail(int rno);
	//��� ���� ����
	public int update(ReplyDTO rdto);
	//��� ���� ����
	public int remove(ReplyDTO rdto);
}
