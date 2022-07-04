package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.RboardService;
import com.javaex.vo.RboardVo;

@Controller
@RequestMapping(value = "/rboard")
public class RboardController {

	@Autowired
	private RboardService rboardService;

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("RboardController > list");

		// Service를 통해서 주소를 가져온다
		List<RboardVo> rboardList = rboardService.getList();

		model.addAttribute("rboardList", rboardList);

		return "rboard/list";
	}

	// 글쓰기폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String wirteForm() {
		System.out.println("RboardController>writeForm()");

		return "rboard/writeForm";
	}

	// 글쓰기
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute RboardVo rboardVo) {
		System.out.println("RboardController>write()");

		rboardService.write(rboardVo);

		return "redirect:/list";

	}

	// 읽기
	@RequestMapping(value = "/read", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(Model model, @RequestParam("no") int no) {
		System.out.println("RboardController>read()");

		// 조회수 먼저 올려주기
		rboardService.hitUp(no);

		RboardVo rboardVo = rboardService.read(no);

		model.addAttribute("rboardVo", rboardVo);

		return "rboard/read";

	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("RboardController>delete()");

		// Service를 통해서 삭제한다
		rboardService.delete(no);

		return "redirect:/list";
	}

	// 수정폼
	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(Model model, @RequestParam("no") int no) {
		System.out.println("RboardController>modifyForm()");

		RboardVo rboardVo = rboardService.read(no);

		model.addAttribute("rboardVo", rboardVo);

		return "rboard/modifyForm";
	}

	// 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute RboardVo rboardVo) {
		System.out.println("RboardController>modify()");

		rboardService.modify(rboardVo);

		return "redirect:list";
	}

	// 댓글 폼
	@RequestMapping(value = "/commentForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String commentForm(Model model, @ModelAttribute RboardVo rboardVo) {
		
		System.out.println("RboardController->commentForm()");
		

		model.addAttribute("rboardVo", rboardVo);

		
		return "rboard/commentForm";
	}

	// 댓글 쓰기
	@RequestMapping(value = "/commentWrite", method = { RequestMethod.GET, RequestMethod.POST })
	public String commentWrite(@ModelAttribute RboardVo rboardVo) {
		
		System.out.println("RboardController->commentWrite()");
		
		rboardService.commentWrite(rboardVo);
		
		return "redirect:list";
	}

}