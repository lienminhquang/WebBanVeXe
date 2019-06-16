package com.app.repo.DB1;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.ChuyenXe;
@Repository
@Transactional
public interface DB1ChuyenXeRepo extends CrudRepository<ChuyenXe, Integer>, MyCustomRepo {
	@Procedure(procedureName = "sp_admin_create_ChuyenXe")
	Integer sp_admin_create_ChuyenXe(
			@Param("id_taixe") Integer id_taixe,
			@Param("id_xe") Integer id_xe,
			@Param("diemxuatphat") String diemxuatphat,
			@Param("diemden") String diemden,
			@Param("thoigiandi") Date thoigiandi,
			@Param("thoigianden") Date thoigianden,
			@Param("giave") Integer giave,
			@Param("so_ghe_trong") Integer so_ghe_trong
			);
	
	@Procedure(procedureName = "sp_admin_create_ChucVu")
	Integer sp_admin_create_ChucVu(
			@Param("tenchucvu") String tenchucvu,
			@Param("ghichu") String ghichu
			);
	
	
}
