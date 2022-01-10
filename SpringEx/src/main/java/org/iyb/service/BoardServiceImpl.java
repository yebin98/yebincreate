package org.iyb.service;

import java.util.ArrayList;

import org.iyb.domain.BoardDTO;

import org.iyb.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // ���� ��Ȱ �ο�
public class BoardServiceImpl implements BoardService{ 
	//�Խ��� �۾��� ����� �� ���� //�߻�޼��带 �ݵ�� �����ؾ� �Ѵ�.
	@Autowired
	private BoardMapper bmapper;//BoardMapper�� ����
	
	public void write(BoardDTO board) {//�޼��� ����
		//db ����
		bmapper.write(board);//BoardMapper�� ����//ȣ���
	}
	//ȣ���ϸ� �����
	
	//�Խ��� ��ϸ���Ʈ ����� �� ����
	public ArrayList<BoardDTO> list() {
		return bmapper.list();
		//return�ʼ�! : ȣ���� ������ ����
	}
	
	//�Խ��� ��ϸ���Ʈ���� ������ Ŭ������ �� ������ ������ �������� ����� ���� ����
	public BoardDTO detail(BoardDTO board) {
		return bmapper.detail(board);
	}
	
	//�Խ��� �ۼ��� ����� �� ����
	public void modify(BoardDTO board) {
		bmapper.modify(board);
	}
	
	//�Խ��� �ۻ��� ����� �� ����
		public void remove(BoardDTO board) {
			bmapper.remove(board);
		}
}
