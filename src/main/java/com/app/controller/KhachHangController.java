package com.app.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.model.HoaDonMuaVe;
import com.app.model.KhachHang;
import com.app.model.VeXe;
import com.app.service.ChuyenXeSer;
import com.app.service.HoaDonMuaVeSer;
import com.app.service.KhachHangSer;
import com.app.service.VeXeSer;

@Controller
public class KhachHangController {
	
	@Autowired 
	ChuyenXeSer chuyenXeSer;
	
	@Autowired
	VeXeSer veXeSer;
	
	@Autowired
	KhachHangSer khachHangSer;
	
	@Autowired
	HoaDonMuaVeSer hoaDonMuaVeSer;

	@GetMapping(path="thongTin")
	public String thongTin(Model model,
			HttpServletRequest request) {
		
		KhachHang kh = null;
		
		
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals(Utils.COOKIE_USERID)) {
				kh = khachHangSer.findByID(Integer.parseInt(c.getValue()));
				break;
			}
		}
		
		if(kh == null)
			return "index";
		
		model.addAttribute(Utils.ATTRIBUTE_USER, kh);
		ArrayList<HoaDonMuaVe> hoaDonMuaVes = hoaDonMuaVeSer.findByKhachhang(kh);
		ArrayList<VeXe> veXes = new ArrayList<VeXe>();
		
		System.out.println("----IdUser: " + kh.getId() + "  So ve:" + hoaDonMuaVes.size());
		
		for(HoaDonMuaVe hd: hoaDonMuaVes) {
			
			VeXe ve = hd.getVeXe();
			
			veXes.add(ve);
		}
		
		model.addAttribute("vexes", veXes);
		
		
		return "ThongTinKhachHang";
	}
}
