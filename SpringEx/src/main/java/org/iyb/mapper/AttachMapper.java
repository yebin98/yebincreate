package org.iyb.mapper;

import java.util.ArrayList;

import org.iyb.domain.AttachFileDTO;

public interface AttachMapper {
	//�Խ��� �۾��� �� �� ���ϰ� ���õǾ� �ִ� attach���̺��� insert
	public void insert(AttachFileDTO board);
	//�Խ��� ���������� ���ε�� �̹����� �Ѹ������� ������list
	public ArrayList<AttachFileDTO> fileList(int bno);//�ѱ�� ����� ���� fileList���� ������ �޶���
}
