package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity(name = "chuyenxe")
//@NamedStoredProcedureQueries({
//	@NamedStoredProcedureQuery(
//			name = "ChuyenXe.sp_admin_create_ChuyenXe",
//			procedureName = "sp_admin_create_ChuyenXe",
//			parameters = {
//					@StoredProcedureParameter(mode = ParameterMode.IN, name = "id_taixe", type = Integer.class),
//					@StoredProcedureParameter(mode = ParameterMode.IN, name = "id_xe", type = Integer.class),
//					@StoredProcedureParameter(mode = ParameterMode.IN, name = "diemxuatphat", type = String.class),
//					@StoredProcedureParameter(mode = ParameterMode.IN, name = "diemden", type = String.class),
//					@StoredProcedureParameter(mode = ParameterMode.IN, name = "thoigiandi", type = java.sql.Date.class),
//					@StoredProcedureParameter(mode = ParameterMode.IN, name = "thoigianden", type = java.sql.Date.class),
//					@StoredProcedureParameter(mode = ParameterMode.IN, name = "giave", type = Integer.class),
//					@StoredProcedureParameter(mode = ParameterMode.IN, name = "so_ghe_trong", type = Integer.class),
//					@StoredProcedureParameter(mode = ParameterMode.OUT, name = "id", type = Integer.class)
//			},
//			resultClasses = Integer.class),
//	@NamedStoredProcedureQuery(
//			name = "sp_admin_create_ChucVu",
//			procedureName = "sp_admin_create_ChucVu",
//			parameters = {
//					@StoredProcedureParameter(mode = ParameterMode.IN, name = "tenchuvu", type = String.class),
//					@StoredProcedureParameter(mode = ParameterMode.IN, name = "ghichu", type = String.class),
//					@StoredProcedureParameter(mode = ParameterMode.OUT, name = "id", type = Integer.class)
//			},
//			resultClasses = Integer.class)
//})
//@NamedQuery(name = "ChuyenXe.test", query = "select u from ChuyenXe u where u.id = ?1")

public class ChuyenXe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
//	@Column(name = "id_taixe")
//	private Integer id_taixe;
	@ManyToOne
	@JoinColumn(name = "id_taixe")
	private NhanVien taiXe;
	
//	@Column(name = "id_xe")
//	private Integer id_xe;
	
	@ManyToOne
	@JoinColumn(name = "id_xe")
	private Xe xe;
	
	@Column(name = "diemxuatphat")
	private String diemXuatPhat;
	
	@Column(name = "diemden")
	private String diemDen;
	
	@Column(name = "thoigiandi")
	private Date thoiGianDi;
	
	@Column(name = "thoigianden")
	private Date thoiGianDen;
	
	@Column(name = "giave")
	private Integer giave;

	@Column(name = "so_ghe_trong")
	private Integer soGheTrong;
	

	public ChuyenXe() {
		super();
	}


	public ChuyenXe(Integer id, NhanVien taiXe, Xe xe, String diemXuatPhat, String diemDen, Date thoiGianDi,
			Date thoiGianDen, Integer giave, Integer soGheTrong) {
		super();
		this.id = id;
		this.taiXe = taiXe;
		this.xe = xe;
		this.diemXuatPhat = diemXuatPhat;
		this.diemDen = diemDen;
		this.thoiGianDi = thoiGianDi;
		this.thoiGianDen = thoiGianDen;
		this.giave = giave;
		this.soGheTrong = soGheTrong;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public NhanVien getTaiXe() {
		return taiXe;
	}


	public void setTaiXe(NhanVien taiXe) {
		this.taiXe = taiXe;
	}


	public Xe getXe() {
		return xe;
	}


	public void setXe(Xe xe) {
		this.xe = xe;
	}


	public String getDiemXuatPhat() {
		return diemXuatPhat;
	}


	public void setDiemXuatPhat(String diemXuatPhat) {
		this.diemXuatPhat = diemXuatPhat;
	}


	public String getDiemDen() {
		return diemDen;
	}


	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}


	public Date getThoiGianDi() {
		return thoiGianDi;
	}


	public void setThoiGianDi(Date thoiGianDi) {
		this.thoiGianDi = thoiGianDi;
	}


	public Date getThoiGianDen() {
		return thoiGianDen;
	}


	public void setThoiGianDen(Date thoiGianDen) {
		this.thoiGianDen = thoiGianDen;
	}


	public Integer getGiave() {
		return giave;
	}


	public void setGiave(Integer giave) {
		this.giave = giave;
	}


	public Integer getSoGheTrong() {
		return soGheTrong;
	}


	public void setSoGheTrong(Integer soGheTrong) {
		this.soGheTrong = soGheTrong;
	}

	
	
}
