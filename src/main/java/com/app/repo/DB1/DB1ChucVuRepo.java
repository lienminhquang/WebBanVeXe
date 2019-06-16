package com.app.repo.DB1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.ChucVu;

@Repository
public interface DB1ChucVuRepo extends CrudRepository<ChucVu, Integer> {
	
}
