package org.iyb.controller;

import org.iyb.domain.ReplyDTO;
import org.iyb.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	@PostMapping(value="new",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyDTO rdto){
		System.out.println("ReplyDTO="+rdto);
		rservice.write(rdto);
		return null;
	}
}
