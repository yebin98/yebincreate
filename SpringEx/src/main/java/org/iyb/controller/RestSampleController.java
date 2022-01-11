package org.iyb.controller;

import org.iyb.domain.RestSampleDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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
	// 객체 반환
	@GetMapping(value="getSample", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})//produces:생략가능(웹브라우저가 판단한다.)
	//자바<->자바스크립트  : json             {,}를 하면 컨트롤러 java타입에 웹에 뿌릴 때 .json타입 ,xml타입으로 둘 다 볼 수 있다.
	public RestSampleDTO getSample() {
		//RestSampleDTO rs = new RestSampleDTO (100,"정","자바");
		//return rs;
		return new RestSampleDTO(100,"정","자바");
	}//RestSampleDTO를 return시켜야 하기 때문에
}
