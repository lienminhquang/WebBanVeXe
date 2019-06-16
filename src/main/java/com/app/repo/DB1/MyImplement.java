package com.app.repo.DB1;

import java.sql.Date;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContexts;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.ChuyenXe;

public class MyImplement implements DB1ChuyenXeRepo {

	//@PersistenceContexts 
	@Autowired
	private EntityManager em;
	
	
	
	@Override
	public long count() {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public void delete(ChuyenXe entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends ChuyenXe> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<ChuyenXe> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<ChuyenXe> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ChuyenXe> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ChuyenXe> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ChuyenXe> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer sp_admin_create_ChuyenXe(Integer id_taixe, Integer id_xe, String diemxuatphat, String diemden,
			Date thoigiandi, Date thoigianden, Integer giave, Integer so_ghe_trong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer sp_admin_create_ChucVu(String tenchucvu, String ghichu) {
		
		return (Integer)this.em.createNativeQuery("Begin"
				+ "sp_admin_create_ChucVu :tenchucvu, :ghichu"
				+ "end").setParameter("tenchucvu", tenchucvu).setParameter("ghichu", ghichu).getSingleResult();
		
		
	}

}
