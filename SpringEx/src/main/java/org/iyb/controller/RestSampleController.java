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
	// �ܼ� ���ڿ� ��ȯ
	@GetMapping(value="getText", produces="text/plain; charset=UTF-8")//�ѱ��ۼ��� �ȱ����� ���� ���� plain:html�������� �ۼ��ϸ� �������ҽ��� html������ ���������.
	public String getText() {
		return "�ȳ��ϼ���.";//.jsp������ �ƴ϶� ���������� �ۼ���.
	}
	
	// ��ü(Ŭ����) ��ȯ
	@GetMapping(value="getSample", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})//produces:��������(���������� �Ǵ��Ѵ�.)
	//�ڹ�<->�ڹٽ�ũ��Ʈ  : json             {,}�� �ϸ� ��Ʈ�ѷ� javaŸ�Կ� ���� �Ѹ� �� .jsonŸ�� ,xmlŸ������ �� �� �� �� �ִ�.
	public RestSampleDTO getSample() {
		//RestSampleDTO rs = new RestSampleDTO (100,"��","�ڹ�");
		//return rs;
		return new RestSampleDTO(100,"��","�ڹ�");
	}//RestSampleDTO�� return���Ѿ� �ϱ� ������
	
	//RespnseEntityŸ�� ��ȯ(returnŸ��)
	@GetMapping(value="check")
	public ResponseEntity <RestSampleDTO> check(int mno, String firstName, String lastName){
		//����ڷκ��� �Ŵ�����ȣ(mno)�� �޾Ƽ�,
		RestSampleDTO rsdto = new RestSampleDTO(mno, firstName, lastName);//RestSampleDTO�� �����ڿ� 3���� �Ű������� �ֱ� ������
		ResponseEntity <RestSampleDTO> result =null;
		
		if(mno<150) {//�޴��� ��ȣ�� 150 �̸��̸� 
			result= ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(rsdto);//���������� ó��(ResponseEntity) - status�� 502 : BAD_GATEWAY
		}else { //�׷��� ������
			result= ResponseEntity.status(HttpStatus.OK).body(rsdto);//���������� ó��(ResponseEntity) - status�� 200 : OK
		}//status : ������ ���� ó��   body : �����޶�
		return result;
	}
	
	// �޼ҵ��� �Ű�����
	// ��üŸ���� �Ű������� �����ؾ� �Ǵ� ��쿡�� @RequestBody�� ����ؾ� ��
	@PostMapping("mno")//form�±װ� �ִ� .jsp(ȭ��)�� �ʿ��ϴ�. 
	//�׷��� Rest����� .jsp�� ������� �ʴ´�. �׷��� ������ �̿��ؼ� test�� �Ѵ�.
	public RestSampleDTO mno(@RequestBody RestSampleDTO rsdto) {//�⺻������ ȣ��
		return rsdto;
	}
	
}
