package org.iyb.service;

import org.iyb.domain.ReplyDTO;
import org.iyb.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyMapper rmapper;
	//댓글 쓰기 설계된 것을 구현
	public void write(ReplyDTO rdto) {
		rmapper.write(rdto);
	}
}
