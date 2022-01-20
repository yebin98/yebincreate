package org.iyb.mapper;

import java.util.ArrayList;
import org.iyb.domain.BoardDTO;
import org.iyb.domain.Criteria;

public interface BoardMapper {
	//insert���� ����ǰ� ������ pk���� �˾ƾ� �ϴ� ���
	//public void writeKey(BoardDTO board);
	
	//insert�� ó���ǰ� ������ pk���� �� �ʿ䰡 ���� ���
	//�Խ��� �۾���� ���õǾ��ִ� DB�۾��� ���� ����
	public void write(BoardDTO board);
	
	//�Խ��� ���Ͽ� ���õǾ��ִ� DB�۾��� ���� ����
	public void insertSelectKey(BoardDTO board);
	
	//�Խ��� ��ϸ���Ʈ�� ���õǾ��ִ� DB�۾��� ���� ����
	public ArrayList<BoardDTO> list(Criteria cri);
	//ArrayList : ���̰� ���� ���� ���ϴ� �迭
	//select�� ���� 2���̻��� �� �迭 �ۼ�
	
	//�Խ��� ��ϸ���Ʈ���� ������ Ŭ������ �� ������ ������ ���������� ���õǾ��ִ� DB�۾��� ���� ����
	public BoardDTO detail(BoardDTO board);
	//public BoardDTO detail(long bno);
	
	//�Խ��� ��ϸ���Ʈ���� ������ Ŭ������ �� ��ȸ�� +1 �� �� �� �ִ� DB�۾��� ���� ����
	public void cntupdate(BoardDTO board);
	
	//�Խ��� �ۼ����� ���õǾ��ִ� DB�۾��� ���� ����
	public void modify(BoardDTO board);
	
	//�Խ��� �ۻ����� ���õǾ��ִ� DB�۾��� ���� ����
	public void remove(BoardDTO board);
	//�� ���� ó���� �� ��, ����� �����Ͱ� �����Ǿ�����
	//public int remove(long bno);
	
	//�Խ��� ����¡�� ���� ��ü �Ǽ��� ���õǾ��ִ� DB�۾��� ���� ����
	public int getTotalCount(Criteria cri);
}
