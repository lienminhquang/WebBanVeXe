package com.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.HoaDonMuaVe;
import com.app.model.KhachHang;
import com.app.repo.DB1.DB1HoaDonMuaVeRepo;

@Service
public class HoaDonMuaVeSer {

	@Autowired
	private DB1HoaDonMuaVeRepo hoaDonMuaVeRepo;
	
	public ArrayList<HoaDonMuaVe> getAll(){
		return (ArrayList<HoaDonMuaVe>)hoaDonMuaVeRepo.findAll();
	}
	
	public HoaDonMuaVe save(HoaDonMuaVe hd) {
		return hoaDonMuaVeRepo.save(hd);
	}
	
	public ArrayList<HoaDonMuaVe> findByKhachhang(KhachHang kh){
		return (ArrayList<HoaDonMuaVe>)hoaDonMuaVeRepo.findByKhachhang(kh);
	}
}
