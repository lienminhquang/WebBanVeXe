package com.app.repo.DB1;

import org.springframework.data.repository.CrudRepository;

import com.app.model.VeXe;

public interface DB1VeXeRepo extends CrudRepository<VeXe, Integer>{
	 public abstract Iterable<VeXe> findByChuyenXeAndTrangthai(java.lang.Object arg0, java.lang.Object arg1);
	 
	 
}
