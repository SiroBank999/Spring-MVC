package com.nhon.spring.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class User {
	@NotBlank
	@Size(min = 5, max = 15, message = "Tên đăng nhập phải từ 8 - 15 ký tự")
	@NotEmpty(message = "Tên tài khoản không được bỏ trống")
	private String username;
	@NotBlank 
	@NotEmpty(message = "Mật khẩu không được bỏ trống")
	private String password;
	@NotBlank 
	
	public User() {
	
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
