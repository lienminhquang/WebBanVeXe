package com.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.ChuyenXe;
import com.app.model.VeXe;
import com.app.repo.DB1.DB1VeXeRepo;

@Service
public class VeXeSer {

	@Autowired
	private DB1VeXeRepo veXeRepo;
	
	public ArrayList<VeXe> getAll(){
		return (ArrayList<VeXe>) veXeRepo.findAll();
	}
	
	public ArrayList<VeXe> findByChuyenXeAndTrangthai(ChuyenXe chuyenXe, int trangthai)
	{
		return (ArrayList<VeXe>) veXeRepo.findByChuyenXeAndTrangthai(chuyenXe, trangthai);
	}
	
	public VeXe findById(Integer id) {
		return veXeRepo.findById(id).get();
	}
	
	public void save(VeXe ve) {
		veXeRepo.save(ve);
	}
	
	public void taoVeXe(ChuyenXe chuyenXe) {
		int soGhe = chuyenXe.getXe().getSoghe();
		ArrayList<VeXe> veXes = new ArrayList<VeXe>();
		for(int i = 0; i < soGhe; i++) {
			VeXe ve = new VeXe(null, chuyenXe, i, 0);
			veXes.add(ve);
		}
		
		veXeRepo.saveAll(veXes);
	}
}
