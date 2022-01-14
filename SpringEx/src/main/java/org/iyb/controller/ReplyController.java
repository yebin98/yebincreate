package org.iyb.controller;

import java.util.ArrayList;

import org.iyb.domain.ReplyDTO;
import org.iyb.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@PostMapping(value="new",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})//MediaType.TEXT_PLAIN_VALUE:문자열로 반환해라
	public ResponseEntity<String> create(@RequestBody ReplyDTO rdto){
		System.out.println("ReplyDTO="+rdto);
		//insert 성공시 ReplyServiceImpl.java로 부터 1,
		//insert 실패시 ReplyServiceImpl.java로 부터 0
		//값을 리턴받는다.
		int result = rservice.write(rdto);
								//insert가 정상적으로 처리되었을 때 1          :              insert가 비정상적으로 처리되었을 때 0 
								// detail.js의 success문 실행                                                            detail.js의 error문 실행
		return result==1?new ResponseEntity<>("success",HttpStatus.OK):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		//통신상태와 함께 문자열을 detail.js의 success(result)에 보낸다.
		//<String>와 "success"타입이 일치
	}
	@GetMapping(value="list/{bno}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})//produces="select된 결과를 반환할 타입"
	public ResponseEntity<ArrayList<ReplyDTO>> getList(@PathVariable int bno){//ReplyDTO타입으로 된 결과를 return해라 
													//@PathVariable : Rest방식에서 주로 사용. url경로의 일부를 파라미터(변수) 사용하고자 할 때 작성한다. 경로의 명과 변수명이 같아야 한다.
		System.out.println(bno);
		return new ResponseEntity<>(rservice.list(bno),HttpStatus.OK);//자바스크립트의 sucess부분으로 간다.//"success"는 String타입지만, 위에는 ReplyDTO타입이여서 에러가 난다.
		//<ArrayList<ReplyDTO>>타입과 rservice.list(bno)가 일치
	}
	//댓글 수정을 하기 위해 댓글 내용 가져오는 함수 선언
	@GetMapping(value="{rno}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyDTO> getDetail(@PathVariable int rno){
		System.out.println(rno);
		return new ResponseEntity<>(rservice.detail(rno),HttpStatus.OK);
	}
	
	@PutMapping(value="update",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})//같은 value값을 사용해도 된다. insert==update
	public ResponseEntity<String> update(@RequestBody ReplyDTO rdto){//댓글 번호, 댓글 내용
		System.out.println("rdto="+rdto);//rdto에 rno가 있기 때문에 rno를 사용하지 않아도 된다. 
		
		return rservice.update(rdto)==1?new ResponseEntity<>("success",HttpStatus.OK)://update가 정상적으로 처리되었을 때
										new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//update가 비정상적으로 처리되었을 때
	}
	@DeleteMapping(value="remove",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@RequestBody ReplyDTO rdto){//댓글 번호, 댓글 내용
		//System.out.println("rdto="+rdto);//rdto에 rno가 있기 때문에 rno를 사용하지 않아도 된다.
		return rservice.remove(rdto)==1?new ResponseEntity<>("success",HttpStatus.OK)://remove가 정상적으로 처리되었을 때
										new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	//remove가 비정상적으로 처리되었을 때
	}
}






