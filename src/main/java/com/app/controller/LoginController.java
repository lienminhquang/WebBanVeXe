package com.app.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.KhachHang;
import com.app.model.NhanVien;
import com.app.service.KhachHangSer;
import com.app.service.NhanVienSer;

@Controller
public class LoginController {
	
	@Autowired
	KhachHangSer khachHangSer;
	
	@Autowired
	NhanVienSer nhanVienSer;
	
	@GetMapping(path="/login")
	public String login_() {
		return "login";
	}
	
	@GetMapping(path = "/logout")
	public String logout(HttpServletResponse response) {
		
		Cookie c = new Cookie(Utils.COOKIE_USERID, null);
		c.setMaxAge(0);
		
		response.addCookie(c);
		
		return "login";
	}
	

	@PostMapping(path = "/login")
	public String login(HttpServletResponse response, Model model, @RequestParam(name="username", defaultValue = "sang") String username, @RequestParam(name="password", defaultValue = "123") String password) {
		System.out.println("-------------------------" + username);
		System.out.println("-------------------------" + password) ;
		
		KhachHang a = new KhachHang();
		try {
			a = (KhachHang)khachHangSer.kiemTraDangNhap(username, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(a.getId() == null) return "login";
	System.out.println("-------------------------");
		
		System.out.println("++++" + a.getId());
		response.addCookie(new Cookie(Utils.COOKIE_USERID,a.getId().toString()));
		
		
		model.addAttribute("user", a);
		
		return "index";
	}
	
	@PostMapping(path="/signup")
	public String signup(
			HttpServletResponse response,
			Model model,@RequestParam(name="hoten") String hoTen, @RequestParam(name="sdt") String sdt, @RequestParam(name="username") String username, 
			@RequestParam(name="password") String password) {
		KhachHang a = new KhachHang(null, hoTen, sdt, username, password);
		a = khachHangSer.dangKy(a);
		
		if(a == null) {
			System.out.println("Khong dang ky dc");
			return "login";
		}
		
		response.addCookie(new Cookie(Utils.COOKIE_USERID,a.getId().toString()));
		
		
		
		model.addAttribute("user", a);
		return "index";
	}
	
	
}
