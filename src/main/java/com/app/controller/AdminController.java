package com.app.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.ChucVu;
import com.app.model.ChuyenXe;
import com.app.model.KhachHang;
import com.app.model.NhanVien;
import com.app.model.Xe;
import com.app.service.ChucVuService;
import com.app.service.ChuyenXeSer;
import com.app.service.KhachHangSer;
import com.app.service.NhanVienSer;
import com.app.service.VeXeSer;
import com.app.service.XeSer;

@Controller
public class AdminController {

	@Autowired
	NhanVienSer nhanVienSer;
	
	@Autowired
	ChuyenXeSer chuyenXeSer;
	
	@Autowired
	ChucVuService chucVuSer;
	
	@Autowired
	XeSer xeSer;
	
	@Autowired
	VeXeSer veXeSer; 
	
	@Autowired
	KhachHangSer khachHangSer;
	
	@GetMapping(path="/admin/loginAdmin")
	public String loginAdmin()
	{
		
		
		return "loginAdmin";
	}
	
	@PostMapping(path="/admin/loginAdmin")
	public String loginAdminPost(Model model, HttpServletResponse response , @RequestParam(name="username") String username, @RequestParam(name="password") String password) {
		
	
		
		NhanVien nv =null;
		nv = nhanVienSer.loginAdmin(username, password);
		System.out.println("NHan vien " + nv);
		
		
		
		if(nv == null)
		{
			return "redirect:loginAdmin";
		}
		
		response.addCookie(new Cookie(Utils.COOKIE_ADMINID, nv.getId().toString()));
		
		return "redirect:QLVexe";
	}
	
	@GetMapping(path="/admin/QLVexe")
	public String qLVexe(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		
		NhanVien nv = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c: cookies) {
				if(c.getName().equals(Utils.COOKIE_ADMINID))
				{
					nv = nhanVienSer.findById(Integer.parseInt(c.getValue()));
				}
			}
		}
		
		if(nv == null)
		{
			return "redirect:loginAdmin";
		}
		
		
		model.addAttribute("admin", nv);
		ArrayList<ChuyenXe> chuyenXes = chuyenXeSer.getAll();
		model.addAttribute("chuyenXes", chuyenXes);
		
		ChucVu cvTaiXe = chucVuSer.getById(2);
		
		ArrayList<NhanVien> taiXes = nhanVienSer.findByChucVu(cvTaiXe);
		model.addAttribute("taiXes", taiXes);
		
		
		ArrayList<Xe> xes = xeSer.getAll();
		model.addAttribute("xes", xes);
		
		//model.addAttribute("thongBao", "test thong bao");
		
		return "QLVexe";
	}
	
	@PostMapping(path="/admin/QLVexe")
	public String qLVexe_post(Model model, 
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(name="idtaixe") Integer idTaiXe, 
			@RequestParam(name="idxe") Integer idXe,
			@RequestParam(name="diemxuatphat") String diemXuatPhat,
			@RequestParam(name="diemden") String diemDen,
			@RequestParam(name="thoigiandi") String sThoiGianDi,
			@RequestParam(name="thoigianden") String sThoiGianDen,
			@RequestParam(name="giave") Integer giaVe) {
		
		System.out.println(sThoiGianDen);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		Date thoiGianDi = new Date();;
		try {
			thoiGianDi = (Date)formatter.parse(sThoiGianDi);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Date thoiGianDen = new Date();
		try {
			thoiGianDen = (Date)formatter.parse(sThoiGianDen);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		NhanVien nv = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		for(Cookie c: cookies) {
			if(c.getName().equals(Utils.COOKIE_ADMINID))
			{
				nv = nhanVienSer.findById(Integer.parseInt(c.getValue()));
			}
		}
		
		if(nv == null)
		{
			return "redirect:loginAdmin";
		}
		
		ChuyenXe cx = new ChuyenXe(null, nhanVienSer.findById(idTaiXe), xeSer.findById(idXe), diemXuatPhat, diemDen, thoiGianDi, thoiGianDen, giaVe, 30);
		//cx = chuyenXeSer.save(cx);
		cx = chuyenXeSer.sp_admin_create_ChuyenXe(cx);
		
		veXeSer.taoVeXe(cx);
		
		System.out.println("Da them chuyen xe " + cx.getId());
		
		model.addAttribute("admin", nv);
		ArrayList<ChuyenXe> chuyenXes = chuyenXeSer.getAll();
		model.addAttribute("chuyenXes", chuyenXes);
		
		ChucVu cvTaiXe = chucVuSer.getById(2);
		
		ArrayList<NhanVien> taiXes = nhanVienSer.findByChucVu(cvTaiXe);
		model.addAttribute("taiXes", taiXes);
		
		
		ArrayList<Xe> xes = xeSer.getAll();
		model.addAttribute("xes", xes);
		
		model.addAttribute("thongBao", "Thêm thành công!");
		
		return "QLVexe";
	}
	
	@GetMapping(path="/admin/QLNhanVien")
	public String gLTaiXe(Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(name="idnv", defaultValue = "-1")Integer idnv) {
		
		NhanVien nv = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals(Utils.COOKIE_ADMINID))
			{
				nv = nhanVienSer.findById(Integer.parseInt(c.getValue()));
			}
		}
		if(nv == null)
		{
			System.out.println("Chua dang nhap admin");
			return "redirect:loginAdmin";
		}
		model.addAttribute("admin", nv);
		
		ArrayList<NhanVien> nvs = new ArrayList<NhanVien>();
		
		if(idnv != -1)
		{
			NhanVien nv1 = nhanVienSer.findById(idnv);
			nvs.add(nv1);
		} else {
			nvs.addAll(nhanVienSer.getAll());
		}
		
		model.addAttribute("nvs", nvs);
		
		ArrayList<ChucVu> cvs = chucVuSer.getAll();
		model.addAttribute("cvs", cvs);
		
		
		
		
		
		return "QLNhanVien";
	}
	
	@PostMapping(path="/admin/QLNhanVien")
	public String themNhanVien(Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(name="hoTen")String hoTen,
			@RequestParam(name="ngaySinh")String sngaySinh,
			@RequestParam(name="sdt")String sdt,
			@RequestParam(name="idChucVu")Integer idChucVu,
			@RequestParam(name="luong")Integer luong) {
		
		Date ngaySinh = new Date();
		try {
			ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(sngaySinh);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		NhanVien nv = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals(Utils.COOKIE_ADMINID))
			{
				nv = nhanVienSer.findById(Integer.parseInt(c.getValue()));
			}
		}
		if(nv == null)
		{
			return "redirect:loginAdmin";
		}
		model.addAttribute("admin", nv);
		
		
		ChucVu chucVu = chucVuSer.getById(idChucVu);
		
		NhanVien nvnew = new NhanVien(null, hoTen, ngaySinh, sdt, chucVu, luong);
		nvnew = nhanVienSer.save(nvnew);
		
		if(nvnew != null)
		{
			model.addAttribute("thongBao", "Thêm thành công!");
		}
		else {
			model.addAttribute("thongBao", "Thêm thất bại!");
		}
		
		
		ArrayList<NhanVien> nvs = new ArrayList<NhanVien>();
		nvs.addAll(nhanVienSer.getAll());
		model.addAttribute("nvs", nvs);
		
		ArrayList<ChucVu> cvs = chucVuSer.getAll();
		model.addAttribute("cvs", cvs);
		
		
		return "QLNhanVien";
	}
	
	@GetMapping(path="/admin/QLXe")
	public String qlXe(Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(name="idxe", defaultValue = "-1")Integer idxe) {
		
		NhanVien nv = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals(Utils.COOKIE_ADMINID))
			{
				nv = nhanVienSer.findById(Integer.parseInt(c.getValue()));
			}
		}
		if(nv == null)
		{
			return "redirect:loginAdmin";
		}
		model.addAttribute("admin", nv);
		
		ArrayList<Xe> xes = new ArrayList<Xe>();
		
		if(idxe != -1)
		{
			Xe xe = xeSer.findById(idxe);
			xes.add(xe);
		} else {
			xes.addAll(xeSer.getAll());
		}
		
		model.addAttribute("xes", xes);
		
		
		return "QLXe";
	}
	
	@PostMapping(path="/admin/QLXe")
	public String themXe(Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(name="soXe")String soXe,
			@RequestParam(name="trangThai")String trangThai,
			@RequestParam(name="soGhe")Integer soGhe) {
		
		NhanVien nv = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals(Utils.COOKIE_ADMINID))
			{
				nv = nhanVienSer.findById(Integer.parseInt(c.getValue()));
			}
		}
		if(nv == null)
		{
			return "redirect:loginAdmin";
		}
		model.addAttribute("admin", nv);
		
		
		Xe newXe = new Xe(null, soXe, trangThai, soGhe);
		newXe = xeSer.save(newXe);
		
		if(newXe != null)
		{
			model.addAttribute("thongBao", "Thêm thành công!");
		}
		else {
			model.addAttribute("thongBao", "Thêm thất bại!");
		}
		
		ArrayList<Xe> xes = new ArrayList<Xe>();
		xes.addAll(xeSer.getAll());
		model.addAttribute("xes", xes);
		
		
		return "QLXe";
	}
	
	@GetMapping(path="/admin/QLKhachHang")
	public String qlKh(Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(name="idkh", defaultValue = "-1")Integer idkh) {
		
		NhanVien nv = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals(Utils.COOKIE_ADMINID))
			{
				nv = nhanVienSer.findById(Integer.parseInt(c.getValue()));
			}
		}
		if(nv == null)
		{
			return "redirect:loginAdmin";
		}
		model.addAttribute("admin", nv);
		
		ArrayList<KhachHang> khs = new ArrayList<KhachHang>();
		
		if(idkh != -1)
		{
			KhachHang kh = khachHangSer.findByID(idkh);
			khs.add(kh);
			
		} else {
			khs.addAll(khachHangSer.getAll());
		}
		
		model.addAttribute("khs", khs);
		
		
		return "QLKhachHang";
	}
	
	@PostMapping(path="/admin/QLKhachHang")
	public String themKH(Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(name="hoTen")String hoTen,
			@RequestParam(name="sdt")String sdt,
			@RequestParam(name="username")String username,
			@RequestParam(name="password")String password) {
		
		NhanVien nv = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals(Utils.COOKIE_ADMINID))
			{
				nv = nhanVienSer.findById(Integer.parseInt(c.getValue()));
			}
		}
		if(nv == null)
		{
			return "redirect:loginAdmin";
		}
		model.addAttribute("admin", nv);
		
		
		KhachHang kh = new KhachHang(null, hoTen, sdt, username, password);
		kh = khachHangSer.save(kh);
		
		if(kh != null)
		{
			model.addAttribute("thongBao", "Thêm thành công!");
		}
		else {
			model.addAttribute("thongBao", "Thêm thất bại!");
		}
		
		ArrayList<KhachHang> khs = new ArrayList<KhachHang>();
		khs.addAll(khachHangSer.getAll());
		model.addAttribute("khs", khs);
		
		
		return "QLKhachHang";
	}
	
}









