package org.iyb.controller;

import org.iyb.domain.BoardDTO;
import org.iyb.domain.Criteria;
import org.iyb.domain.PageDTO;
import org.iyb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller // mvc컨트롤러(c) 역활 부여
@RequestMapping("board")
public class BoardController {
	@Autowired
	//private BoardService service = new BoardController;
	private BoardService service;//BoardService와 연결
	
	//글쓰기 화면으로
	@GetMapping("write")
	//url 주소를 입력해 게시판 글쓰기 화면이 뜬다.
	public void write() {
		System.out.println("board/write");
	}
	//글쓰기 버튼을 클릭하면
	@PostMapping("write")
	//submit 버튼을 누르면 데이터를 저장한다.
	public String writePost(BoardDTO board) {
		service.write(board);//BoardService와 연결//호출부
		System.out.println("write post"+board);
		//return "board/list"; //이렇게 작성하면 db, 서비스 하나도 안거치고 온다.
		return "redirect:/board/list";//return은 @GetMapping의 값 작성하면 된다.
	}
	
	//@GetMapping("write")
	//@PostMapping("write")
	//다른 방식이기 때문에 같은 단어 사용 가능
	
	//게시판 목록 리스트
	@GetMapping("list")
	public void list(Criteria cri, Model model) {//사용자에게 받을 것이 없기 때문에
		//검색기능은 따로 데이터를 만드는 것이 없기 때문에 변수로 작성
		//BoardDTO에search와 keyword를 작성하거나, 다른 도메인을 만들면 된다.
		//db작업할 때 필요가 없기 때문에 다른 도메인을 만드는 것이 좋다.
		System.out.println("board/list");
		//System.out.println("list결과는="+service.list(cri));
		model.addAttribute("list", service.list(cri));
		
		int total = service.getTotalCount(cri);
		//System.out.println("total="+ total);
		model.addAttribute("pageMaker", new PageDTO(cri,total));//매개변수가 2개 이므로 select된 결과 도출
	}
	
	//게시판 목록 리스트에서 제목을 클릭하면
	@GetMapping("detail")
	public void detail(BoardDTO board, Model model) {
		model.addAttribute("detail", service.detail(board));
	}
	
	//글 수정 화면으로
	@GetMapping("modify")
	public void modify(BoardDTO board, Model model) {
		model.addAttribute("detail", service.detail(board));
		System.out.println("board/modify");
	}
	
	//글수정 버튼을 클릭하면
	@PostMapping("modify")
	public String modifyPost(BoardDTO board, RedirectAttributes rttr) {//변수값으로 데이터 이동
		System.out.println(board);
		//update
		service.modify(board);
		//select한 결과값도 가지고 detail로가라
		rttr.addAttribute("bno", board.getBno());
		return "redirect:/board/detail";
	}
	
	//글삭제 버튼을 클릭하면
	@GetMapping("remove")
	public String remove(BoardDTO board) {
		System.out.println(board);
		//delete
		service.remove(board);
		return "redirect:/board/list";
	}
}
