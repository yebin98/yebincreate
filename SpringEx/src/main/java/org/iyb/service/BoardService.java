package org.iyb.service;

import java.util.ArrayList;

import org.iyb.domain.BoardDTO;

public interface BoardService { 
	//�Խ��� �۾���
	public void write(BoardDTO board);//�߻�޼���
	//�Խ��� ��ϸ���Ʈ
	public ArrayList<BoardDTO> list();
	//�Խ��� ��ϸ���Ʈ���� ������ Ŭ������ �� ������ ������ ��������
	public BoardDTO detail(BoardDTO board);//����
	//�Խ��� ����������
	//�Խ��� ����������
}
