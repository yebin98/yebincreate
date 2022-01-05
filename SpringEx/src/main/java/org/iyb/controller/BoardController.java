package org.iyb.controller;

import org.iyb.domain.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {
	@GetMapping("write")
	public void write() {
		System.out.println("board/write");
	}
	@PostMapping("write")
	public void writePost(BoardDTO board) {
		System.out.println("write post"+board);
		
	}
	//@GetMapping("write")
	//@PostMapping("write")
	//다른 방식이기 때문에 같은 단어 사용 가능
}
