package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="vexe")
public class VeXe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
//	@Column(name = "id_chuyenxe")
//	private Integer idchuyenxe;
	@ManyToOne
	@JoinColumn(name="id_chuyenxe")
	private ChuyenXe chuyenXe;
	
	@Column(name = "vitri")
	private Integer vitri;


	@Column(name = "trangthai")
	private Integer trangthai;
	

	

	public VeXe() {
		super();
	}




	public VeXe(Integer id, ChuyenXe chuyenXe, Integer vitri, Integer trangthai) {
		super();
		this.id = id;
		this.chuyenXe = chuyenXe;
		this.vitri = vitri;
		this.trangthai = trangthai;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public ChuyenXe getChuyenXe() {
		return chuyenXe;
	}




	public void setChuyenXe(ChuyenXe chuyenXe) {
		this.chuyenXe = chuyenXe;
	}




	public Integer getVitri() {
		return vitri;
	}




	public void setVitri(Integer vitri) {
		this.vitri = vitri;
	}




	public Integer getTrangthai() {
		return trangthai;
	}




	public void setTrangthai(Integer trangthai) {
		this.trangthai = trangthai;
	}

	
	
}
