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
	//댓글쓰기를 하기 위한 RequestMapping
	//Mapping을 할 때 우리가 원하는 데이터 타입을 강제함으로써 오류 상황을 줄일 수 있다.
	//consumes : 들어오는 데이터 타입 정의(생략가능)
	//produces : 반환하는 데이터 타입 정의(생략가능)
	//*생략을 하게 되면, 웹브라우저가 알아서 타입을 판단(내가 원하는 타입이 아닐 수도 있음)*
	
	//.jsp파일이 없기 때문에 이렇게 작성한다.
	@PostMapping(value="new",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyDTO rdto){
		System.out.println("ReplyDTO="+rdto);
		rservice.write(rdto);
		return null;
	}
}
