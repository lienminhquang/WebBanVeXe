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


@Service
public class ChuyenXeSer {

	@Autowired
	private DB1ChuyenXeRepo chuyenXeRepo;
	

	
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
		
		ChuyenXe cx2 = chuyenXeRepo.test(1);
		System.out.println("***************************************" + cx2.getId() + "******************************************");
		
		
		
		
		
		return chuyenXeRepo.findById(id).get();
	}
}
