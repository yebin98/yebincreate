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

@Service // ���� ��Ȱ �ο�
public class BoardServiceImpl implements BoardService{ 
	@Autowired
	private BoardMapper bmapper;//BoardMapper�� ����
	@Autowired
	private AttachMapper amapper;//BoardMapper�� ����
	
	//�Խ��� �۾��� ����� �� ���� //�߻�޼��带 �ݵ�� �����ؾ� �Ѵ�.
	@Transactional//����, ���� + ���� �� �� �Ǿ��� insert�ǰų� �� �� �ȵǵ� insert�ǰų�.
	public void write(BoardDTO board) {//�޼��� ����
		//����� ������ board���̺� insert
		//db ����
		bmapper.insertSelectKey(board);//BoardMapper�� ����//ȣ���
		//���ϸ�, ���ϰ��, ����Ÿ��, uuid���� attach���̺� insert
		//BoardDTO�� �ִ� AttachList�� �����ͼ� �ݺ������� �����Ͽ� attach������ ����
		board.getAttachList().forEach(attach->{
			//BoardDTO�� bno���� �����ͼ� AttachListFileDTO�� bno�� ���� (attach.setBno)
			attach.setBno(board.getBno());
			System.out.println("attach���̺��� bno"+attach.getBno());
			amapper.insert(attach);
		});//�ݺ���
		//amapper.insert(board);//board�� Ÿ���� BoardDTO�̿��� board�� ���� Ÿ���� ���� �ʴ�.
	}//ȣ���ϸ� �����
	
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
	
	//�Խ��� ���������� ���Ͼ��ε�� �̹��� ����ϴ� ���� ����
	public ArrayList<AttachFileDTO> fileList(int bno){
		return amapper.fileList(bno);
	}
		
}
