package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	// 필드
	@Autowired
	UserService userService;

	// 회원정보 수정(업데이트)
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController>modify()");
		
		//세션 잘 모르겠음...
		//세션에서 정보 가져오기
		session.getAttribute("authUser");
	

		userService.modify(userVo);

		//다시 세션에 저장
		session.setAttribute("authUser", userVo);

		return "redirect:main";

	}

	// 수정폼(업데이트폼)
	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(Model model, @RequestParam("no") int no) {
		System.out.println("UserController>modifyForm()");

		// 주소에서 값 꺼내기
		System.out.println(no);

		// Service를 통해서 1명정보 가져오기
		UserVo userVo = userService.getUserOne(no);

		// ds 데이터보내기 -->request attribute에 넣는다
		model.addAttribute("userVo", userVo);

		return "user/modifyForm";
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {
		System.out.println("UserController>logout()");

		System.out.println("로그아웃 되었습니다.");
		session.removeAttribute("/logout");
		session.invalidate();

		return "redirect:main";
	}

	// 로그인
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController>login()");

		UserVo authUser = userService.login(userVo);

		/* 세션에 저장 */
		if (authUser != null) { // 로그인성공
			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser);
			return "redirect:main";

		} else { // 로그인실패
			System.out.println("로그인 실패");
			return "redirect:user/loginForm?result=fail";
		}

	}

	// 로그인폼
	@RequestMapping(value = "/loginForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {
		System.out.println("UserController>loginForm()");

		return "user/loginForm";
	}

	// 회원가입
	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController>join()");

		int count = userService.join(userVo);
		System.out.println("UserController: " + count);

		return "user/joinOk";
	}

	// 회원가입폼
	@RequestMapping(value = "/joinForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		System.out.println("UserController>joinForm()");

		return "user/joinForm";
	}
}