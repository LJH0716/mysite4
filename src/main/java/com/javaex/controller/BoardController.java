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

	// 리스트(페이징)
	@RequestMapping(value = "/list4", method = { RequestMethod.GET, RequestMethod.POST })
	public String list4(Model model,
			@RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage) {
		System.out.println("BoardContoller>list4()");

		Map<String, Object> pMap = boardService.getBoardList4(crtPage);
		model.addAttribute("pMap", pMap);

		System.out.println("controller --> " + pMap);

		return "board/list4";
	}

	/*
	 * // 리스트
	 * 
	 * @RequestMapping(value = "/list", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String list(Model model) {
	 * System.out.println("BoardController > list");
	 * 
	 * // Service를 통해서 주소를 가져온다 List<BoardVo> boardList = boardService.getList();
	 * 
	 * model.addAttribute("boardList", boardList);
	 * 
	 * return "board/list"; }
	 * 
	 */
	// 글쓰기폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String wirteForm() {
		System.out.println("BoardController>writeForm()");

		return "board/writeForm";
	}

	// 글쓰기
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController>write()");

		boardService.write(boardVo);

		return "redirect:/list3";

	}

	// 읽기

	@RequestMapping(value = "/read", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(Model model, @RequestParam("no") int no) {
		System.out.println("BoardController>read()");

		// 조회수 먼저 올려주기
		boardService.hitUp(no);

		BoardVo boardVo = boardService.read(no);

		model.addAttribute("boardVo", boardVo);

		return "board/read";

	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("BoardController>delete()");

		// Service를 통해서 삭제한다
		boardService.delete(no);

		return "redirect:/list3";
	}

	// 수정폼
	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(Model model, @RequestParam("no") int no) {
		System.out.println("BoardController>modifyForm()");

		BoardVo boardVo = boardService.read(no);

		model.addAttribute("boardVo", boardVo);

		return "board/modifyForm";
	}

	// 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController>modify()");

		boardService.modify(boardVo);

		return "redirect:list3";
	}
	/*
	 * // 검색 1
	 * 
	 * @RequestMapping(value = "/search", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String search(@RequestParam("keyword") String
	 * keyword, Model model) { System.out.println("BoardContoller>search()");
	 * 
	 * List<BoardVo> boardList = boardService.getBoardList2(keyword);
	 * model.addAttribute("boardList", boardList);
	 * 
	 * return "board/list2"; }
	 */

	// 검색2(리스트+검색)
	@RequestMapping(value = "/list3", method = { RequestMethod.GET, RequestMethod.POST })
	public String list3(Model model,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
		// keyword처럼 값이 있을 수도 있고, 없을 수도 있는 경우에 쓰는 방식//@requestParam는 사용할때 파라미터 값이 항상
		// 있어야함
		System.out.println("BoardContoller>list3()");

		List<BoardVo> boardList = boardService.getBoardList3(keyword);
		model.addAttribute("boardList", boardList);

		return "board/list3";
	}

}