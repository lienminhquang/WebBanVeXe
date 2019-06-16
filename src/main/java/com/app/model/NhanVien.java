package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "nhanvien")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "hoten")
	private String hoTen;
	
	@Column(name = "ngaysinh")
	private Date ngaySinh;
	
	@Column(name = "sdt")
	private String sdt;
	
//	@Column(name = "id_chucvu")
//	private Integer id_chucvu;
	@ManyToOne
	@JoinColumn(name="id_chucvu")
	private ChucVu chucVu;
	
	@Column(name = "luong")
	private Integer luong;
	
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
	public NhanVien() {
		super();
	}

	public NhanVien(Integer id, String hoTen, Date ngaySinh, String sdt, ChucVu chucVu, Integer luong) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.chucVu = chucVu;
		this.luong = luong;
		this.username=this.hoTen;
		this.password="123";
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public ChucVu getChucVu() {
		return chucVu;
	}

	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}

	public Integer getLuong() {
		return luong;
	}

	public void setLuong(Integer luong) {
		this.luong = luong;
	}

	
	
}
