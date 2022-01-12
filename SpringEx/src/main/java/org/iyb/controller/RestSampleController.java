package org.iyb.controller;

import org.iyb.domain.RestSampleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class RestSampleController {
	// 단순 문자열 반환
	@GetMapping(value="getText", produces="text/plain; charset=UTF-8")//한글작성이 안깨지는 것을 방지 plain:html형식으로 작성하면 페이지소스에 html형식이 만들어진다.
	public String getText() {
		return "안녕하세요.";//.jsp파일이 아니라 웹브라우저에 작성됨.
	}
	
	// 객체(클래스) 반환
	@GetMapping(value="getSample", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})//produces:생략가능(웹브라우저가 판단한다.)
	//자바<->자바스크립트  : json             {,}를 하면 컨트롤러 java타입에 웹에 뿌릴 때 .json타입 ,xml타입으로 둘 다 볼 수 있다.
	public RestSampleDTO getSample() {
		//RestSampleDTO rs = new RestSampleDTO (100,"정","자바");
		//return rs;
		return new RestSampleDTO(100,"정","자바");
	}//RestSampleDTO를 return시켜야 하기 때문에
	
	//RespnseEntity타입 반환(return타입)
	@GetMapping(value="check")
	public ResponseEntity <RestSampleDTO> check(int mno, String firstName, String lastName){
		//사용자로부터 매니저번호(mno)를 받아서,
		RestSampleDTO rsdto = new RestSampleDTO(mno, firstName, lastName);//RestSampleDTO의 생성자에 3개의 매개변수가 있기 때문에
		ResponseEntity <RestSampleDTO> result =null;
		
		if(mno<150) {//메니저 번호가 150 미만이면 
			result= ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(rsdto);//비정상으로 처리(ResponseEntity) - status가 502 : BAD_GATEWAY
		}else { //그렇지 않으면
			result= ResponseEntity.status(HttpStatus.OK).body(rsdto);//정상적으로 처리(ResponseEntity) - status가 200 : OK
		}//status : 데이터 상태 처리   body : 보여달라
		return result;
	}
	
	// 메소드의 매개변수
	// 객체타입을 매개변수로 지정해야 되는 경우에는 @RequestBody를 사용해야 함
	@PostMapping("mno")//form태그가 있는 .jsp(화면)이 필요하다. 
	//그러나 Rest방식은 .jsp를 사용하지 않는다. 그래서 도구를 이용해서 test를 한다.
	public RestSampleDTO mno(@RequestBody RestSampleDTO rsdto) {//기본생성자 호출
		return rsdto;
	}
	
}
