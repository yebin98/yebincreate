package org.iyb.mapper;

import java.util.ArrayList;

import org.iyb.domain.BoardDTO;

public interface BoardMapper {
	//게시판 글쓰기와 관련되어있는 DB작업에 대한 설계
	public void write(BoardDTO board);
	
	//게시판 목록리스트와 관련되어있는 DB작업에 대한 설계
	public ArrayList<BoardDTO> list();
	//ArrayList : 길이가 값에 따라 변하는 배열
	//select의 값이 2개이상일 때 배열 작성
	
	//게시판 목록리스트에서 제목을 클릭했을 때 내용이 나오는 상세페이지와 관련되어있는 DB작업에 대한 설계
	public BoardDTO detail(BoardDTO board);
}
