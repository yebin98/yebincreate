package org.iyb.mapper;

import java.util.ArrayList;

import org.iyb.domain.BoardDTO;

public interface BoardMapper {
	//�Խ��� �۾���� ���õǾ��ִ� DB�۾��� ���� ����
	public void write(BoardDTO board);
	
	//�Խ��� ��ϸ���Ʈ�� ���õǾ��ִ� DB�۾��� ���� ����
	public ArrayList<BoardDTO> list();
	//ArrayList : ���̰� ���� ���� ���ϴ� �迭
	//select�� ���� 2���̻��� �� �迭 �ۼ�
	
	//�Խ��� ��ϸ���Ʈ���� ������ Ŭ������ �� ������ ������ ���������� ���õǾ��ִ� DB�۾��� ���� ����
	public BoardDTO detail(BoardDTO board);
}
