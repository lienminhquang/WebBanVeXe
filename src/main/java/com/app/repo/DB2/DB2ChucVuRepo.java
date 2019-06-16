package com.app.repo.DB2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.ChucVu;

@Repository
public interface DB2ChucVuRepo extends CrudRepository<ChucVu, Integer> {
	
}
