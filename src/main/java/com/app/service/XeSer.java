package com.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Xe;
import com.app.repo.DB1.DB1XeRepo;

@Service
public class XeSer {

	@Autowired
	private DB1XeRepo xeRepo;
	
	public ArrayList<Xe> getAll(){
		return (ArrayList<Xe>) xeRepo.findAll();
	}
	
	public Xe findById(Integer id) {
		return xeRepo.findById(id).get();
	}
	
	public Xe save(Xe xe) {
		return xeRepo.save(xe);
	}
}
