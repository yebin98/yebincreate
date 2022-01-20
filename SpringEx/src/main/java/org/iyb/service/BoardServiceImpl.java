package org.iyb.service;

import java.util.ArrayList;

import org.iyb.domain.AttachFileDTO;
import org.iyb.domain.BoardDTO;
import org.iyb.domain.Criteria;
import org.iyb.mapper.AttachMapper;
import org.iyb.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 서비스 역활 부여
public class BoardServiceImpl implements BoardService{ 
	@Autowired
	private BoardMapper bmapper;//BoardMapper와 연결
	@Autowired
	private AttachMapper amapper;//BoardMapper와 연결
	
	//게시판 글쓰기 설계된 것 구현 //추상메서드를 반드시 구현해야 한다.
	@Transactional//제목, 내용 + 파일 둘 다 되야지 insert되거나 둘 다 안되도 insert되거나.
	public void write(BoardDTO board) {//메서드 선언문
		//제목과 내용을 board테이블에 insert
		//db 연결
		bmapper.insertSelectKey(board);//BoardMapper와 연결//호출부
		//파일명, 파일경로, 파일타입, uuid값을 attach테이블에 insert
		//BoardDTO에 있는 AttachList를 가져와서 반복문으로 실행하여 attach변수에 저장
		board.getAttachList().forEach(attach->{
			//BoardDTO의 bno값을 가져와서 AttachListFileDTO에 bno를 저장 (attach.setBno)
			attach.setBno(board.getBno());
			System.out.println("attach테이블의 bno"+attach.getBno());
			amapper.insert(attach);
		});//반복문
		//amapper.insert(board);//board의 타입은 BoardDTO이여서 board만 쓰면 타입이 맞지 않다.
	}//호출하면 연결됨
	
	//게시판 목록리스트 설계된 것 구현
	public ArrayList<BoardDTO> list(Criteria cri) {
		return bmapper.list(cri);
		//return필수! : 호출한 곳으로 보냄
	}
	@Transactional
	//게시판 목록리스트에서 제목을 클릭했을 때 내용이 나오는 상세페이지 설계된 것을 구현
	public BoardDTO detail(BoardDTO board) {
		//board테이블에 조회수 속성에 +1
		bmapper.cntupdate(board);
		//		상세페이지 select
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
	
	//게사판 페이징에 쓰일 데이터건수
	public int getTotalCount(Criteria cri) {
		return bmapper.getTotalCount(cri);
	}
	
	//게시판 상세페이지에 파일업로드된 이미지 출력하는 것을 구현
	public ArrayList<AttachFileDTO> fileList(int bno){
		return amapper.fileList(bno);
	}
		
}
