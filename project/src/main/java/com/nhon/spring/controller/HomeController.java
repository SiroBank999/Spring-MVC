package com.nhon.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhon.spring.models.Student;

@Controller
public class HomeController {

	@RequestMapping({"/","/home"})
	public String Home(Model model) {
		Student std = new Student();
		std.setFullname("Nguyen Van Nhon");
		model.addAttribute("student", std);
		return "home";

	}
}
