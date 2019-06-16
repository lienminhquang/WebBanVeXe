package com.app.controller;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.ChuyenXe;
import com.app.model.KhachHang;
import com.app.model.VeXe;
import com.app.service.ChuyenXeSer;
import com.app.service.KhachHangSer;
import com.app.service.VeXeSer;


@Controller
public class TrangChuController {
	
	@Autowired
	private ChuyenXeSer chuyenXeSer;
	
	@Autowired
	private KhachHangSer khachHangSer;
	
	@Autowired
	private VeXeSer veXeSer;
	
	@GetMapping(path = "/")
	public String index(Model model, HttpServletRequest request) {

		KhachHang kh = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c: cookies) {
				if(c.getName().equals(Utils.COOKIE_USERID)) {
					kh = khachHangSer.findByID(Integer.parseInt(c.getValue()));
					break;
				}
			}
		}
		if(kh != null)
			model.addAttribute(Utils.ATTRIBUTE_USER, kh);
		
		
		return "index";
	}
	
	
	
	@GetMapping(path = "/timve")
	public String timve(
			HttpServletRequest request,
			Model model,
			@RequestParam(name = "diemdi", defaultValue = "") String diemDi,
			@RequestParam(name = "diemden", defaultValue = "") String diemDen, 
			@RequestParam(name = "date", defaultValue = "") String date) {
		
		Format f = new SimpleDateFormat("MM/dd/yyyy");
		
		
		model.addAttribute("diemDi", diemDi);
		model.addAttribute("diemDen", diemDen);
		model.addAttribute("date", date);
		
		String userId = null;
		
		
		
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals(Utils.COOKIE_USERID)) {
				userId = c.getValue();
				break;
			}
		}
		
		if(userId != null) {
			KhachHang kh = khachHangSer.findByID(Integer.parseInt(userId));
			model.addAttribute("user", kh);
		}
		
		
		
		//date = date.replace('/', '-');
		System.out.println(diemDi + diemDen + date);
	
		
		ArrayList<ChuyenXe> chuyenXes = chuyenXeSer.getAll();
		ArrayList<ChuyenXe> kq = new ArrayList<ChuyenXe>();
		
		ArrayList<VeXe> vexes = new ArrayList<VeXe>();
		
		for(ChuyenXe ch : chuyenXes) {
							
			String s = f.format(ch.getThoiGianDi());
			
			if(ch.getDiemXuatPhat().toString().contains(diemDi) && ch.getDiemDen().toString().contains(diemDen) && s.contains(date))
			{
				ArrayList<VeXe> t = veXeSer.findByChuyenXeAndTrangthai(ch, 0);
				if(t.size() == 0)
					continue;
				ch.setSoGheTrong(t.size());
				
				kq.add(ch);
				vexes.addAll(t);
			}
		}
		
		System.out.println(kq.size());
		System.out.println(vexes.size());
		
		model.addAttribute("chuyenXes", kq);		
		model.addAttribute("vexes", vexes);
		
		return "Timve";
	}
	
	@GetMapping(path = "/test")
	public String timvee() {
		return "login";
	}
}
