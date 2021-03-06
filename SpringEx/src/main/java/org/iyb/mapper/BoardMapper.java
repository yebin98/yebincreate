package org.iyb.mapper;

import java.util.ArrayList;
import org.iyb.domain.BoardDTO;
import org.iyb.domain.Criteria;

public interface BoardMapper {
	//insert문이 실행되고 생성된 pk값을 알아야 하는 경우
	//public void writeKey(BoardDTO board);
	
	//insert만 처리되고 생성된 pk값을 알 필요가 없는 경우
	//게시판 글쓰기와 관련되어있는 DB작업에 대한 설계
	public void write(BoardDTO board);
	
	//게시판 파일와 관련되어있는 DB작업에 대한 설계
	public void insertSelectKey(BoardDTO board);
	
	//게시판 목록리스트와 관련되어있는 DB작업에 대한 설계
	public ArrayList<BoardDTO> list(Criteria cri);
	//ArrayList : 길이가 값에 따라 변하는 배열
	//select의 값이 2개이상일 때 배열 작성
	
	//게시판 목록리스트에서 제목을 클릭했을 때 내용이 나오는 상세페이지와 관련되어있는 DB작업에 대한 설계
	public BoardDTO detail(BoardDTO board);
	//public BoardDTO detail(long bno);
	
	//게시판 목록리스트에서 제목을 클릭했을 때 조회수 +1 을 할 수 있는 DB작업에 대한 설계
	public void cntupdate(BoardDTO board);
	
	//게시판 글수정과 관련되어있는 DB작업에 대한 설계
	public void modify(BoardDTO board);
	
	//게시판 글삭제와 관련되어있는 DB작업에 대한 설계
	public void remove(BoardDTO board);
	//글 삭제 처리를 한 후, 몇건의 데이터가 삭제되었는지
	//public int remove(long bno);
	
	//게시판 페이징에 쓰일 전체 건수와 관련되어있는 DB작업에 대한 설계
	public int getTotalCount(Criteria cri);
}
