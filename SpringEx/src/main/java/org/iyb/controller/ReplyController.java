package org.iyb.controller;

import java.util.ArrayList;

import org.iyb.domain.ReplyDTO;
import org.iyb.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("replies")
public class ReplyController {
	@Autowired 
	private ReplyService rservice;
	//��۾��⸦ �ϱ� ���� RequestMapping
	//Mapping�� �� �� �츮�� ���ϴ� ������ Ÿ���� ���������ν� ���� ��Ȳ�� ���� �� �ִ�.
	//consumes : ������ ������ Ÿ�� ����(��������)
	//produces : ��ȯ�ϴ� ������ Ÿ�� ����(��������)
	//*������ �ϰ� �Ǹ�, ���������� �˾Ƽ� Ÿ���� �Ǵ�(���� ���ϴ� Ÿ���� �ƴ� ���� ����)*
	
	//.jsp������ ���� ������ �̷��� �ۼ��Ѵ�.
	@PostMapping(value="new",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})//MediaType.TEXT_PLAIN_VALUE:���ڿ��� ��ȯ�ض�
	public ResponseEntity<String> create(@RequestBody ReplyDTO rdto){
		System.out.println("ReplyDTO="+rdto);
		//insert ������ ReplyServiceImpl.java�� ���� 1,
		//insert ���н� ReplyServiceImpl.java�� ���� 0
		//���� ���Ϲ޴´�.
		int result = rservice.write(rdto);
								//insert�� ���������� ó���Ǿ��� �� 1          :              insert�� ������������ ó���Ǿ��� �� 0 
								// detail.js�� success�� ����                                                            detail.js�� error�� ����
		return result==1?new ResponseEntity<>("success",HttpStatus.OK):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		//��Ż��¿� �Բ� ���ڿ��� detail.js�� success(result)�� ������.
		//<String>�� "success"Ÿ���� ��ġ
	}
	@GetMapping(value="list/{bno}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})//produces="select�� ����� ��ȯ�� Ÿ��"
	public ResponseEntity<ArrayList<ReplyDTO>> getList(@PathVariable int bno){//ReplyDTOŸ������ �� ����� return�ض� 
													//@PathVariable : Rest��Ŀ��� �ַ� ���. url����� �Ϻθ� �Ķ����(����) ����ϰ��� �� �� �ۼ��Ѵ�. ����� ��� �������� ���ƾ� �Ѵ�.
		System.out.println(bno);
		return new ResponseEntity<>(rservice.list(bno),HttpStatus.OK);//�ڹٽ�ũ��Ʈ�� sucess�κ����� ����.//"success"�� StringŸ������, ������ ReplyDTOŸ���̿��� ������ ����.
		//<ArrayList<ReplyDTO>>Ÿ�԰� rservice.list(bno)�� ��ġ
	}
	//��� ������ �ϱ� ���� ��� ���� �������� �Լ� ����
	@GetMapping(value="{rno}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyDTO> getDetail(@PathVariable int rno){
		System.out.println(rno);
		return new ResponseEntity<>(rservice.detail(rno),HttpStatus.OK);
	}
}