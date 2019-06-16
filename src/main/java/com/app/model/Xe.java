package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="xe")
public class Xe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "soxe")
	private String soXe;
	
	@Column(name = "trangthai")
	private String trangThai;
	
	@Column(name = "soghe")
	private Integer soghe;

	public Xe() {
		super();
	}

	public Xe(Integer id, String soXe, String trangThai, Integer soghe) {
		super();
		this.id = id;
		this.soXe = soXe;
		this.trangThai = trangThai;
		this.soghe = soghe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSoXe() {
		return soXe;
	}

	public void setSoXe(String soXe) {
		this.soXe = soXe;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Integer getSoghe() {
		return soghe;
	}

	public void setSoghe(Integer soghe) {
		this.soghe = soghe;
	}

	
}
