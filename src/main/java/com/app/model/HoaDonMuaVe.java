package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "hoadonmuave")
public class HoaDonMuaVe {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@OneToOne
	@JoinColumn(name="id_ve")
	private VeXe veXe;
	

	@ManyToOne 
	@JoinColumn(name="id_khachhang")
	private KhachHang khachhang;
	
	@Column(name="hoten")
	private String hoten;
	
	@Column(name="sdt")
	private String sdt;

	public HoaDonMuaVe() {
		super();
	}

	public HoaDonMuaVe(Integer id, VeXe veXe, KhachHang khachhang, String hoten, String sdt) {
		super();
		this.id = id;
		this.veXe = veXe;
		this.khachhang = khachhang;
		this.hoten = hoten;
		this.sdt = sdt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VeXe getVeXe() {
		return veXe;
	}

	public void setVeXe(VeXe veXe) {
		this.veXe = veXe;
	}

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	
}
