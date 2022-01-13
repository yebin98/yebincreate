package org.iyb.service;

import java.util.ArrayList;

import org.iyb.domain.ReplyDTO;
import org.iyb.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyMapper rmapper;
	//��� ���� ����� ���� ����
	public int write(ReplyDTO rdto) {
		//insert ������ ReplyMapper.java�� ���� 1,
		//insert ���н� ReplyMapper.java�� ���� 0
		//���� ���Ϲ޴´�.
		return rmapper.write(rdto);
	}
	//��� ��� ����Ʈ ����� ���� ����
	public ArrayList<ReplyDTO> list(int bno) {
		return rmapper.list(bno);
	}
	
	//��� ���� ����� ���� ����
		public ReplyDTO detail(int rno) {
			return rmapper.detail(rno);
		}
}
