package com.nhon.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public ModelAndView submitLogin(@ModelAttribute("user") User user) {
		ModelAndView modelAndView = new ModelAndView("redirect:/products");
		if(userService.checkLogin(user) == true) {
			return modelAndView;
		}else {
			modelAndView.setViewName("home/login");
			modelAndView.addObject("message", "Tài khoản hoặc mật khẩu không đúng");
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
	public ModelAndView register(@ModelAttribute("user") User user, @RequestParam String repassword ) {
		
		ModelAndView modelAndView = new ModelAndView("home/register");
		modelAndView.addObject("user", new User());
		if(user.getUsername().isEmpty() || user.getPassword().isEmpty() || repassword.isEmpty()) {
			modelAndView.addObject("message", "Vui lòng không để trống");
			
		}else {
			if(user.getPassword().equals(repassword)) {
				userService.register(user);
				modelAndView.addObject("message", "Đăng kí thành công");
			}else {
				modelAndView.addObject("message", "Xác nhận mật khẩu không đúng !!!");
			}
		}
		
		return modelAndView;
		
	}
		
		
		
	
}
