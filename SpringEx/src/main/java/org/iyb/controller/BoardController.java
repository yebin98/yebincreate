package org.iyb.controller;

import org.iyb.domain.BoardDTO;
import org.iyb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // ��Ʈ�ѷ� ��Ȱ �ο�
@RequestMapping("board")
public class BoardController {
	@Autowired
	//private BoardService service = new BoardController;
	private BoardService service;//BoardService�� ����
	
	//�۾��� ȭ������
	@GetMapping("write")
	//url �ּҸ� �Է��� �Խ��� �۾��� ȭ���� ���.
	public void write() {
		System.out.println("board/write");
	}
	//�۾��� ��ư�� Ŭ���ϸ�
	@PostMapping("write")
	//submit ��ư�� ������ �����͸� �����Ѵ�.
	public String writePost(BoardDTO board) {
		service.write(board);//BoardService�� ����//ȣ���
		System.out.println("write post"+board);
		//return "board/list"; //�̷��� �ۼ��ϸ� db, ���� �ϳ��� �Ȱ�ġ�� �´�.
		return "redirect:/board/list";//return�� @GetMapping�� �� �ۼ��ϸ� �ȴ�.
	}
	
	//@GetMapping("write")
	//@PostMapping("write")
	//�ٸ� ����̱� ������ ���� �ܾ� ��� ����
	
	//�Խ��� ��� ����Ʈ
	@GetMapping("list")
	public void list(Model model) {//����ڿ��� ���� ���� ���� ������
		service.list();
		System.out.println("board/list");
		System.out.println("list�����="+service.list());
		model.addAttribute("list", service.list());
	}
	
	//�Խ��� ��� ����Ʈ���� ������ Ŭ���ϸ�
	@GetMapping("detail")
	public void detail(BoardDTO board, Model model) {
		model.addAttribute("detail", service.detail(board));
	}
}
