package org.iyb.service;

import java.util.ArrayList;
import org.iyb.domain.BoardDTO;
import org.iyb.domain.Criteria;
import org.iyb.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public ArrayList<BoardDTO> list(Criteria cri) {
		return bmapper.list(cri);
		//return�ʼ�! : ȣ���� ������ ����
	}
	@Transactional
	//�Խ��� ��ϸ���Ʈ���� ������ Ŭ������ �� ������ ������ �������� ����� ���� ����
	public BoardDTO detail(BoardDTO board) {
		//board���̺� ��ȸ�� �Ӽ��� +1
		bmapper.cntupdate(board);
		//		�������� select
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
	
	//�Ի��� ����¡�� ���� �����ͰǼ�
	public int getTotalCount(Criteria cri) {
		return bmapper.getTotalCount(cri);
	}
		
}
