package com.nhon.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nhon.spring.models.User;
import com.nhon.spring.service.UserService;

@Controller
public class HomeController {

	@Autowired
	public UserService userService;
	
	@GetMapping({"/","/login"})
	public ModelAndView loginView() {
		ModelAndView modelAndView = new ModelAndView("home/login");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	@PostMapping("/login")
	public ModelAndView submitLogin(@Valid @ModelAttribute("user") User user,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("redirect:/products");
		if (result.hasErrors()) {
			modelAndView.setViewName("home/login");
			return modelAndView;
		} else if (userService.checkLogin(user) == true) {
			return modelAndView;
		} else {
			modelAndView.setViewName("home/login");
			modelAndView.addObject("message", "Tài khoản hoặc mật khẩu không đúng!");
			return modelAndView;
		}

	}
	@GetMapping("/register")
	public ModelAndView registerView() {
		ModelAndView modelAndView = new ModelAndView("home/register");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	@PostMapping("/register")
	public ModelAndView register(@Valid @ModelAttribute("user")  User user, BindingResult result,String repassword) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/login");
		modelAndView.addObject("user", new User());
		if (result.hasErrors()) {
			return new ModelAndView("home/register");
		} else if (user.getPassword().equals(repassword)) {
			userService.register(user);
			return modelAndView;
		} else {
			modelAndView.setViewName("home/register");
			modelAndView.addObject("msg", "Mật khẩu nhập lại không khớp!");
			return modelAndView;
		}
	}
		
		
		
	
}
