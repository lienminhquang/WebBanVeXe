package com.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.KhachHang;
import com.app.repo.DB1.DB1KhachHangRepo;

@Service
public class KhachHangSer {

	
	@Autowired
	private DB1KhachHangRepo khachHangRepo;
	
	public ArrayList<KhachHang> getAll()
	{
		return (ArrayList<KhachHang>) khachHangRepo.findAll();
	}
	
	public KhachHang kiemTraDangNhap(String username, String password) {
				
		return khachHangRepo.findByUsernameAndPassword(username,password).get();
	}
	
	public KhachHang dangKy(KhachHang a) {

		return khachHangRepo.save(a);
	}
	
	public KhachHang findByID(Integer id) {

		return khachHangRepo.findById(id).get();
	}

	public KhachHang save(KhachHang kh) {

		return khachHangRepo.save(kh);
		
	}
}
