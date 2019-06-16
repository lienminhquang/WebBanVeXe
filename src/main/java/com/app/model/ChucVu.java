package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "chucvu")
public class ChucVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "tenchucvu")
	private String tenChucVu;
	
	@Column(name = "ghichu")
	private String ghiChu;

	public ChucVu(Integer id, String tenChucVu, String ghiChu) {
		super();
		this.id = id;
		this.tenChucVu = tenChucVu;
		this.ghiChu = ghiChu;
	}

	public ChucVu() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
}
