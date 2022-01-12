package org.iyb.service;

import org.iyb.domain.ReplyDTO;
import org.iyb.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyMapper rmapper;
	//��� ���� ����� ���� ����
	public void write(ReplyDTO rdto) {
		rmapper.write(rdto);
	}
}
