package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileService;

@Controller
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/fileupload/form", method = { RequestMethod.GET, RequestMethod.POST })
	public String form() {
		System.out.println("FileController>form()");

		return "fileupload/form";
	}

	@RequestMapping(value = "/fileupload/upload", method = { RequestMethod.GET, RequestMethod.POST })
	public String upolad(@RequestParam("file") MultipartFile file, Model model) {
											//모든 형식의 파일을 다 받을 수 있는 것, multipartFile
		System.out.println("FileController>upload()");
		
		//System.out.println(file.getOriginalFilename());-->파일 이름이 없어도 값이 들어가버리기 때문에 원본파일 이름으로 관리할것

		String saveName = fileService.save(file);

		model.addAttribute("saveName", saveName);

		return "fileupload/result";
	}

}