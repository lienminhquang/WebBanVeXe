package com.app.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.HoaDonMuaVe;
import com.app.model.KhachHang;
import com.app.model.VeXe;
import com.app.service.HoaDonMuaVeSer;
import com.app.service.KhachHangSer;
import com.app.service.VeXeSer;

@Controller
public class DatVeController {
	
	@Autowired
	KhachHangSer khachHangSer;
	
	@Autowired
	VeXeSer veXeSer;
	
	@Autowired 
	HoaDonMuaVeSer hoaDonMuaVeSer;

	@GetMapping(path="/datve")
	public String datVe(
			Model model, 
			HttpServletResponse response, 
			HttpServletRequest request,
			@RequestParam(name = "idvexe" ) Integer idvexe,
			@RequestParam(name = "hoten") String hoten,
			@RequestParam(name = "sdt") String sdt){
		
		Cookie[] cookies = request.getCookies();
		KhachHang kh = null;
		
		
		for(Cookie c : cookies) {
			if(c.getName().equals(Utils.COOKIE_USERID))
			{
				System.out.println("Dang nhap bang user " + c.getValue());
				kh = khachHangSer.findByID(Integer.parseInt(c.getValue()));
				break;
			}
		}
		
		
		
		
		VeXe vexe = veXeSer.findById(idvexe);
		vexe.setTrangthai(1); // 1 da mua
		veXeSer.save(vexe);
		
		
		HoaDonMuaVe hd = new HoaDonMuaVe(null, vexe, kh, hoten, sdt);
		hd = hoaDonMuaVeSer.save(hd);
		
		if(hd.getId() != null)
			System.out.println("DAt ve thanh cong!");
		else 
			System.out.println("Dat ve that bai!");
		
		
		return "redirect:timve";
	}
}
