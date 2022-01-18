package org.iyb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.iyb.domain.AttachFileDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

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
	
	//��/��/�� ������ ������ �����ϱ� ���� �۾�. ���� �̸� �����Ͽ� ����
	private String getFolder() {
		//���糯¥�� ����(���� �� �� ��:��:�� KST �⵵)
		Date date = new Date();//util//�⺻������ ȣ��
		
		//->2020-01-18�� ����ϱ�(yyyy-mm-dd �������� ����(�ð� ����))
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//MM�� �빮�� �ʼ� �̴��ϰ� �����ϱ� ����
		
		//2020-01-18
		String str = sdf.format(date);
		System.out.println("date="+date);
		System.out.println(str.replace("-", File.separator));
		//str.replace("-", File.separator);
		
		//2020-01-18 -> 2022\01\18�� ����
		return str.replace("-", File.separator);
	}
	
	//����� �̹��� ������ �� ������ �� �� �������� ���� �Ǵ��ϴ� �޼ҵ�(����ڰ� ���ε� �� ������ �̹����̸� ����, �׷��� ������ ���� ����)
	private boolean checkImage(File file) {//�̹������� �ƴ��� Ȯ���ϱ� ���� �Ű������� file�� �޾ƾ� ��  //����ó��
		try {
			String contentType=Files.probeContentType(file.toPath());//������ Ÿ���� �˾Ƴ��� probeContentType�޼ҵ� ȣ���Ͽ� ���
			return contentType.startsWith("image");//�� ������ Ÿ���� image�̸� true, �׷��� ������ false
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//uploadAjax.jsp���� ajax�� �̿��ؼ� ���� ���ε� �� controller����
	@PostMapping(value="uploadAjaxAction",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	//ajax�� ���ؼ� ȣ���ϸ� model�� ������� �ʰ� ResponseEntity�� ����Ͽ� ���������� return ��Ų��.
	public ResponseEntity <ArrayList<AttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		//AttachFileDTO�� ����Ǵ� ���� �������Ͽ� ���� ���̸� �迭�� ó���� �Ǿ�� �ϹǷ� ArrayListŸ���� �Ǿ�� ��. �迭�� �����Ͽ� �������� ���� �� �ְ� ��.
		ArrayList<AttachFileDTO> list = new ArrayList<>();
		
		//���� ���ε��� ��� ����
		String uploadFolder="C:\\Users\\GreenArt\\upload";//��¥�� ���� ��
		
		//���� ����                                     		(���� ����, ���� ����)�� ����
		File uploadPath = new File(uploadFolder, getFolder());//��¥�� �ִ� �� //���� ���ε� ���
		System.out.println("uploadPath="+uploadPath);
		
		//��¥�� ��� �ٲ�� ������ ��¥ �κи� ����
		String uploadFolderPath=getFolder();
		
		//���� ������� �ϴ� ������ ������
		if(uploadPath.exists()==false) {//exists(), mkdirs() �ν��Ͻ� �ż���
			//���� ����
			uploadPath.mkdirs();//mkdirs:Make directory=>������ �����
		}
		
		for(MultipartFile multipartFile : uploadFile) {//uploadFile�迭�� ������ �ϳ� ����� ����  multipartFile�� �����Ͽ� ���
			System.out.println("���ε� ���� �̸� = " + multipartFile.getOriginalFilename());//����ڰ� ���ε� �� ���� ���� �̸�
			System.out.println("���ε� ���� ũ�� = " + multipartFile.getSize());//����ڰ� ���ε� �� ���� ���� ũ��
			System.out.println("���ε� ���� ���� = " + multipartFile.getContentType());//����ڰ� ���ε� �� ���� ���� ����
			
			//UploadController�� �ִ� uploadAjaxAction�޼ҵ忡�� AttachFileDTO�� ����ؼ� ���� �����ؾ� �ȴµ�
			//�̷� ��� UploadController�� AttachFileDTO�� ������ ����� �� �� ����.
			//�׷��� UploadController�� AttachFileDTO ���� ���Ѽ� ����Ͽ� ���� ������.
			AttachFileDTO attachdto = new AttachFileDTO();//���԰��� ����
			
			//���� ���ϸ� ����
			String uploadFileName= multipartFile.getOriginalFilename();//�����ؾ� ��//uuid�� ���� ���ε�� ���� �̸�
			
			//���� ���ϸ�(uploadFileName)�� AttachFileDTOŬ����(attachdto)�� fileName�� ����(setFileName)
			attachdto.setFileName(uploadFileName);
			
			//�ߺ��� ���� �ʴ� ������ ���ڿ��� ����
			UUID uuid = UUID.randomUUID();//.randomUUID(); : Ŭ���� �޼���
			
			//UUID+"_"+getOriginalFilename()�� �������� ���ϸ��� uploadFileName�� ����
			uploadFileName=uuid.toString()+"_"+uploadFileName;
			
			//File saveFile=new File();//File�� �⺻�����ڰ� ���� ������ �� �Ű������� �ۼ��ؾ� �Ѵ�.
			//uploadFolder�� ����Ǿ� �ִ� ��η� ���� ���ϸ����� ����.
			File saveFile=new File(uploadPath,uploadFileName);//�̸��� �����ؾ� �ϱ� ������
			
			try {
				//saveFile������ ����Ǿ� �ִ� ���������� ������ ������.
				multipartFile.transferTo(saveFile);//transferTo : ������ ������ ������ ���ε带 �����ִ� ��Ȱ, ����ó�� �ʼ�
				
				//���� ���ε� ���(uploadFolderPath)�� AttachFileDTOŬ����(attachdto)�� uploadPath�� ����(setUploadPath)
				attachdto.setUploadPath(uploadFolderPath); //try�� �ȿ� ��� �ȴ�. for�� �ȿ��� ������ �ȴ�.
				
				//uuid��(UUID)�� AttachFileDTOŬ����(attachdto)�� uploadPath�� ����(setUuid)
				attachdto.setUuid(uuid.toString()); //try�� �ȿ� ��� �ȴ�. for�� �ȿ��� ������ �ȴ�. //uuid�� Ŭ����Ÿ���̹Ƿ� ���ڷ� �ٲ���� �Ѵ�.
				
				if(checkImage(saveFile)) {//�̹��� �����̸�
					//FileType��(image)�� AttachFileDTOŬ����(attachdto)�� uploadPath�� ����(setImage)
					attachdto.setImage(true); //try�� �ȿ� ��� �ȴ�. for�� �ȿ��� ������ �ȴ�.
					
					//������� ������ �����ϱ� ���� ����� ���� �̸��� ����
					FileOutputStream thumnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));//FileOutput ������ ������ �A��
					
					//������� ������ ������
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumnail, 100, 100);
					thumnail.close();//����� ����(�޸� ���� �Լ�)
				}
				
				list.add(attachdto);//add : ���� ���� �� ����ϴ� �޼��� 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
		}//for�� end
		//��Ż��°� ������(HttpStatus.OK)�̸� ArrayList(list)�� ����Ǿ� �ִ� ���� ��������(uploadAjax.js�� �ִ� ajax�� success)�� ������
		return new ResponseEntity<>(list,HttpStatus.OK);//list�� uploadAjax.js�� ajax�� result�� �Ѿ��.
	}
}
