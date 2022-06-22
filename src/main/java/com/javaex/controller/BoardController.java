package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("BoardController > list");

		// Service를 통해서 주소를 가져온다
		List<BoardVo> boardList = boardService.getList();

		model.addAttribute("boardList", boardList);

		return "board/list";
	}

	// 글쓰기폼
	@RequestMapping(value = "/wirteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String wirteForm() {
		System.out.println("BoardController>writeForm()");

		return "board/writeForm";
	}

	// 글쓰기
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController>write()");

		boardService.write(boardVo);

		return "redirect:/list";

	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("BoardController>delete()");

		BoardVo boardVo = new BoardVo();
		boardVo.getNo();
		System.out.println(boardVo);

		// Service를 통해서 삭제한다
		boardService.delete(no);

		return "redirect:/list";
	}

	// 읽기

	@RequestMapping(value = "/read", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(Model model, @RequestParam("no") int no) {
		System.out.println("BoardController>read()");

		BoardVo boardVo = boardService.read(no);

		model.addAttribute("boardVo", boardVo);
		
		return "board/read";

	}
	
	// 조회수

	

}