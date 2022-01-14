package org.iyb.mapper;

import java.util.ArrayList;

import org.iyb.domain.ReplyDTO;

public interface ReplyMapper {
	//��� ���� ����
	//insert ������ ReplyMapper.xml�� ���� 1,
	//insert ���н� ReplyMapper.xml�� ���� 0
	//���� ���Ϲ޴´�.
	public int write(ReplyDTO rdto);
	
	//��� ��� ����Ʈ ����
	public ArrayList<ReplyDTO> list(int bno);
	
	//��� ������ �ϱ� ���� ��� ������ �������¼���
	public ReplyDTO detail(int rno);
	
	//��� ���� ����
	//update ������ ReplyMapper.xml�� ���� 1,
	//update ���н� ReplyMapper.xml�� ���� 0
	public int update(ReplyDTO rdto);
	
	//��� ���� ����
	//remove ������ ReplyMapper.xml�� ���� 1,
	//remove ���н� ReplyMapper.xml�� ���� 0
	public int remove(ReplyDTO rdto);
}		
