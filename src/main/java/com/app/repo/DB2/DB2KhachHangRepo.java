package com.app.repo.DB2;

import org.springframework.data.repository.CrudRepository;


import com.app.model.KhachHang;

public interface DB2KhachHangRepo extends CrudRepository<KhachHang, Integer>{
	
	  public abstract java.util.Optional<KhachHang> findByUsernameAndPassword(java.lang.Object arg0, java.lang.Object arg1);
}
