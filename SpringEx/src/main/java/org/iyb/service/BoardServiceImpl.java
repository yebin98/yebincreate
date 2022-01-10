package org.iyb.service;

import java.util.ArrayList;

import org.iyb.domain.BoardDTO;

import org.iyb.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 서비스 역활 부여
public class BoardServiceImpl implements BoardService{ 
	//게시판 글쓰기 설계된 것 구현 //추상메서드를 반드시 구현해야 한다.
	@Autowired
	private BoardMapper bmapper;//BoardMapper와 연결
	
	public void write(BoardDTO board) {//메서드 선언문
		//db 연결
		bmapper.write(board);//BoardMapper와 연결//호출부
	}
	//호출하면 연결됨
	
	//게시판 목록리스트 설계된 것 구현
	public ArrayList<BoardDTO> list() {
		return bmapper.list();
		//return필수! : 호출한 곳으로 보냄
	}
	
	//게시판 목록리스트에서 제목을 클릭했을 때 내용이 나오는 상세페이지 설계된 것을 구현
	public BoardDTO detail(BoardDTO board) {
		return bmapper.detail(board);
	}
	
	//게시판 글수정 설계된 것 구현
	public void modify(BoardDTO board) {
		bmapper.modify(board);
	}
	
	//게시판 글삭제 설계된 것 구현
		public void remove(BoardDTO board) {
			bmapper.remove(board);
		}
}
