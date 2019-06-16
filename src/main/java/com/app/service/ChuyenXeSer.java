package com.app.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.ChuyenXe;
import com.app.repo.DB1.DB1ChuyenXeRepo;
import com.app.repo.DB1.MyImplement;

@Service
public class ChuyenXeSer {

	@Autowired
	private DB1ChuyenXeRepo chuyenXeRepo;
	
	@Autowired
	private MyImplement impl;
	
	public ArrayList<ChuyenXe> getAll(){
		return (ArrayList<ChuyenXe>) chuyenXeRepo.findAll();
	}
	
	public ChuyenXe findById(Integer id){
		return chuyenXeRepo.findById(id).get();
	}
	
	public ChuyenXe save(ChuyenXe cx) {
		return chuyenXeRepo.save(cx);
	}
	
	public ChuyenXe sp_admin_create_ChuyenXe(ChuyenXe cx)
	{
		
		
		Integer id = -1;
		
		id = impl.sp_admin_create_ChucVu("fff", "ff");
		System.out.println("***************************************" + id + "******************************************");
		
		id = chuyenXeRepo.sp_admin_create_ChuyenXe(cx.getTaiXe().getId(), cx.getXe().getId(), cx.getDiemXuatPhat(), cx.getDiemDen(),new Date(cx.getThoiGianDi().getTime()), new Date (cx.getThoiGianDen().getTime()), cx.getGiave(), cx.getSoGheTrong());
		
		
		
		return chuyenXeRepo.findById(id).get();
	}
}
