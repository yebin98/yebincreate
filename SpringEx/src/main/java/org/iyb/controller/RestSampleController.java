package org.iyb.controller;

import org.iyb.domain.RestSampleDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class RestSampleController {
	// �ܼ� ���ڿ� ��ȯ
	@GetMapping(value="getText", produces="text/plain; charset=UTF-8")//�ѱ��ۼ��� �ȱ����� ���� ���� plain:html�������� �ۼ��ϸ� �������ҽ��� html������ ���������.
	public String getText() {
		return "�ȳ��ϼ���.";//.jsp������ �ƴ϶� ���������� �ۼ���.
	}
	// ��ü ��ȯ
	@GetMapping(value="getSample", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})//produces:��������(���������� �Ǵ��Ѵ�.)
	//�ڹ�<->�ڹٽ�ũ��Ʈ  : json             {,}�� �ϸ� ��Ʈ�ѷ� javaŸ�Կ� ���� �Ѹ� �� .jsonŸ�� ,xmlŸ������ �� �� �� �� �ִ�.
	public RestSampleDTO getSample() {
		//RestSampleDTO rs = new RestSampleDTO (100,"��","�ڹ�");
		//return rs;
		return new RestSampleDTO(100,"��","�ڹ�");
	}//RestSampleDTO�� return���Ѿ� �ϱ� ������
}
