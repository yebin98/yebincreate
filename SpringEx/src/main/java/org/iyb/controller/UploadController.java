package org.iyb.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("upload")//form�±�
	public void uploadForm() {
		System.out.println("���� ���ε� ȭ��");
	}
	@GetMapping("uploadAjax")//div�±�
	public void uploadAjaxForm() {
		System.out.println("���� ���ε� ȭ��");
	}
	//upload.jsp���� form�±׸� �̿��ؼ� ���� ���ε�
	@PostMapping("uploadAction")
	public void uploadAction(MultipartFile[] uploadFile) {
		//���� ���ε��� ��� ����
		String uploadFolder="C:\\Users\\GreenArt\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {//uploadFile�迭�� ������ �ϳ� ����� ����  multipartFile�� �����Ͽ� ���
			System.out.println("���ε� ���� �̸� = " + multipartFile.getOriginalFilename());//����ڰ� ���ε� �� ���� ���� �̸�
			System.out.println("���ε� ���� ũ�� = " + multipartFile.getSize());//����ڰ� ���ε� �� ���� ���� ũ��
			System.out.println("���ε� ���� ���� = " + multipartFile.getContentType());//����ڰ� ���ε� �� ���� ���� ����
			
			//File saveFile=new File();//File�� �⺻�����ڰ� ���� ������ �� �Ű������� �ۼ��ؾ� �Ѵ�.
			//uploadFolder�� ����Ǿ� �ִ� ��η� ���� ���ϸ����� ����.
			//multipartFile.getOriginalFilename()�� uploadFolder��ο� ����
			File saveFile=new File(uploadFolder,multipartFile.getOriginalFilename());//�̸��� �����ؾ� �ϱ� ������
			
			try {
				multipartFile.transferTo(saveFile);//transferTo : ������ ������ ������ ���ε带 �����ִ� ��Ȱ, ����ó�� �ʼ�
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
			
		}//for�� end
	}
	//uploadAjax.jsp���� ajax�� �̿��ؼ� ���� ���ε� �� controller����
	@PostMapping("uploadAjaxAction")
	public void uploadAjaxAction(MultipartFile[] uploadFile) {
		//���� ���ε��� ��� ����
		String uploadFolder="C:\\Users\\GreenArt\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {//uploadFile�迭�� ������ �ϳ� ����� ����  multipartFile�� �����Ͽ� ���
			System.out.println("���ε� ���� �̸� = " + multipartFile.getOriginalFilename());//����ڰ� ���ε� �� ���� ���� �̸�
			System.out.println("���ε� ���� ũ�� = " + multipartFile.getSize());//����ڰ� ���ε� �� ���� ���� ũ��
			System.out.println("���ε� ���� ���� = " + multipartFile.getContentType());//����ڰ� ���ε� �� ���� ���� ����
			
			//File saveFile=new File();//File�� �⺻�����ڰ� ���� ������ �� �Ű������� �ۼ��ؾ� �Ѵ�.
			//uploadFolder�� ����Ǿ� �ִ� ��η� ���� ���ϸ����� ����.
			//multipartFile.getOriginalFilename()�� uploadFolder��ο� ����
			File saveFile=new File(uploadFolder,multipartFile.getOriginalFilename());//�̸��� �����ؾ� �ϱ� ������
			
			try {
				multipartFile.transferTo(saveFile);//transferTo : ������ ������ ������ ���ε带 �����ִ� ��Ȱ, ����ó�� �ʼ�
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
			
		}//for�� end
	}
}
