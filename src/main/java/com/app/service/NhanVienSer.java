package com.app.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.ChucVu;
import com.app.model.NhanVien;
import com.app.repo.DB1.DB1ChucVuRepo;
import com.app.repo.DB1.DB1NhanVienRepo;

@Service
public class NhanVienSer {

	@Autowired
	private DB1NhanVienRepo nhanVienRepo;
	
	@Autowired
	private DB1ChucVuRepo chucVuRepo;
	
	public ArrayList<NhanVien> getAll(){
		return (ArrayList<NhanVien>) nhanVienRepo.findAll();
	}
	
	public NhanVien loginAdmin(String username, String password) {
		ChucVu admin = chucVuRepo.findById(3).get();
		System.out.println("Chuc vu: " + admin.getTenChucVu());
		Optional<NhanVien> nvop =  nhanVienRepo.findByUsernameAndPasswordAndChucVu(username, password, admin);
		
		
		
		System.out.println(nvop);
		try {
			return nvop.get();
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public NhanVien findById(Integer id)
	{
		return nhanVienRepo.findById(id).get();
	}
	
	public ArrayList<NhanVien> findByChucVu(ChucVu chucVu){
		return ( ArrayList<NhanVien>)nhanVienRepo.findByChucVu(chucVu);
	}
	
	public NhanVien save(NhanVien nv) {
		
		try {
			return nhanVienRepo.save(nv);
		} catch (Exception e) {
			return null;
		}
		
	}
}
