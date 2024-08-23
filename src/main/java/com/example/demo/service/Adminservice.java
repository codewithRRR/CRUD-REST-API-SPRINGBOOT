package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.dto.Admin;
import com.example.demo.exception.DataNotFoundException;
import com.example.demo.repository.Adminrepository;

@Component
public class Adminservice {

	@Autowired
	Adminrepository adminrep;

	public ResponseEntity<String> saveadmin(Admin admin) {
		adminrep.save(admin);
		return new ResponseEntity<String>("DATA SAVED SUCCCES", HttpStatus.CREATED);
	}

	public ResponseEntity<String> savealladmin(List<Admin> admin) {
		adminrep.saveAll(admin);
		return new ResponseEntity<String>("Data saved success", HttpStatus.CREATED);

	}

	public ResponseEntity<List<Admin>> fetchAll() {
		List<Admin> stu = adminrep.findAll();
		if (stu.isEmpty())
//			return new ResponseEntity<List<admin>>(stu, HttpStatus.NOT_FOUND);
			throw new DataNotFoundException("No data found");
		else
			return new ResponseEntity<List<Admin>>(stu, HttpStatus.FOUND);

	}

	public ResponseEntity<Admin> fetchById(int id) {
		Admin admin = adminrep.findById(id).orElseThrow(() -> new DataNotFoundException("NO Id found " +id));
//		if (admin == null)
//			returne new ResponseEntity<admin>(admin, HttpStatus.NOT_FOUND);
//		else
		return new ResponseEntity<Admin>(admin, HttpStatus.FOUND);
	}

	public ResponseEntity<List<Admin>> fetchByemail(String email) {
		List<Admin> stu = adminrep.findByEmail(email);
		if (stu.isEmpty())
			throw new DataNotFoundException("no data found with email "+ email);
		else
			return new ResponseEntity<List<Admin>>(stu, HttpStatus.FOUND);
	}

	public ResponseEntity<String> logIn(String email, String password) {
		List<Admin> stu = adminrep.findByEmailAndPassword(email, password);
		if (stu.isEmpty())
			throw new DataNotFoundException("Not able to login");
		else
			return new ResponseEntity<String>("Login Success", HttpStatus.FOUND);
	}

	public ResponseEntity<String> deleteRecord(int id) {
		Admin stu = adminrep.findById(id).orElseThrow(() -> new DataNotFoundException());
		adminrep.delete(stu);
		return new ResponseEntity<String>("deleted success", HttpStatus.FOUND);
	}
}