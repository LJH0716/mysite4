package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value = "/gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;

	// 리스트 (갤러리 사진 가져오기)
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("GalleryController>list()");

		List<GalleryVo> galleryList = galleryService.getList();

		model.addAttribute("galleryList", galleryList);

		return "gallery/list";

	}

	// 사진 업로드
	@RequestMapping(value = "/upload", method = { RequestMethod.GET, RequestMethod.POST })
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("content") String content) {
		System.out.println("GalleryController>upload()");

		String saveName = galleryService.save(file, content);

		return "redirect:/list";

	}


	// 삭제
	@ResponseBody
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String remove(@ModelAttribute GalleryVo galleryVo) {
		System.out.println("GalleryController>delete()");

		String state = galleryService.delete(galleryVo);

		return state;
	}
}
