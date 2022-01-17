package org.iyb.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("upload")//form태그
	public void uploadForm() {
		System.out.println("파일 업로드 화면");
	}
	@GetMapping("uploadAjax")//div태그
	public void uploadAjaxForm() {
		System.out.println("파일 업로드 화면");
	}
	//upload.jsp에서 form태그를 이용해서 파일 업로드
	@PostMapping("uploadAction")
	public void uploadAction(MultipartFile[] uploadFile) {
		//파일 업로드할 경로 지정
		String uploadFolder="C:\\Users\\GreenArt\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {//uploadFile배열에 변수를 하나 만들어 값을  multipartFile에 저장하여 출력
			System.out.println("업로드 파일 이름 = " + multipartFile.getOriginalFilename());//사용자가 업로드 한 실제 파일 이름
			System.out.println("업로드 파일 크기 = " + multipartFile.getSize());//사용자가 업로드 한 실제 파일 크기
			System.out.println("업로드 파일 형식 = " + multipartFile.getContentType());//사용자가 업로드 한 실제 파일 형식
			
			//File saveFile=new File();//File은 기본생성자가 없기 때문에 꼭 매개변수를 작성해야 한다.
			//uploadFolder에 저장되어 있는 경로로 실제 파일명으로 저장.
			//multipartFile.getOriginalFilename()을 uploadFolder경로에 저장
			File saveFile=new File(uploadFolder,multipartFile.getOriginalFilename());//이름을 저장해야 하기 때문에
			
			try {
				multipartFile.transferTo(saveFile);//transferTo : 실제로 지정한 폴더에 업로드를 시켜주는 역활, 예외처리 필수
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
			
		}//for문 end
	}
	//uploadAjax.jsp에서 ajax를 이용해서 파일 업로드 후 controller연결
	@PostMapping("uploadAjaxAction")
	public void uploadAjaxAction(MultipartFile[] uploadFile) {
		//파일 업로드할 경로 지정
		String uploadFolder="C:\\Users\\GreenArt\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {//uploadFile배열에 변수를 하나 만들어 값을  multipartFile에 저장하여 출력
			System.out.println("업로드 파일 이름 = " + multipartFile.getOriginalFilename());//사용자가 업로드 한 실제 파일 이름
			System.out.println("업로드 파일 크기 = " + multipartFile.getSize());//사용자가 업로드 한 실제 파일 크기
			System.out.println("업로드 파일 형식 = " + multipartFile.getContentType());//사용자가 업로드 한 실제 파일 형식
			
			//File saveFile=new File();//File은 기본생성자가 없기 때문에 꼭 매개변수를 작성해야 한다.
			//uploadFolder에 저장되어 있는 경로로 실제 파일명으로 저장.
			//multipartFile.getOriginalFilename()을 uploadFolder경로에 저장
			File saveFile=new File(uploadFolder,multipartFile.getOriginalFilename());//이름을 저장해야 하기 때문에
			
			try {
				multipartFile.transferTo(saveFile);//transferTo : 실제로 지정한 폴더에 업로드를 시켜주는 역활, 예외처리 필수
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end try
			
		}//for문 end
	}
}
