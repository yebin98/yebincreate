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
	//댓글 쓰기 설계된 것을 구현
	public int write(ReplyDTO rdto) {
		//insert 성공시 ReplyMapper.java로 부터 1,
		//insert 실패시 ReplyMapper.java로 부터 0
		//값을 리턴받는다.
		return rmapper.write(rdto);
	}
	//댓글 목록 리스트 설계된 것을 구현
	public ArrayList<ReplyDTO> list(int bno) {
		return rmapper.list(bno);
	}
	
	//댓글 수정 설계된 것을 구현
		public ReplyDTO detail(int rno) {
			return rmapper.detail(rno);
		}
}
