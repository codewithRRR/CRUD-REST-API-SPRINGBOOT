package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Admin;
import com.example.demo.service.Adminservice;


@RestController
@RequestMapping("/admins")
public class Admincontroller {

	@Autowired
	Adminservice service;

	@PostMapping
	public ResponseEntity<String> adddetail(@RequestBody Admin admin) {
		return service.saveadmin(admin);
	}

	@PostMapping("/saveall")
	public ResponseEntity<String> addall(@RequestBody List<Admin> admin) {
		return service.savealladmin(admin);
	}

	// fetch all
	@GetMapping
	public ResponseEntity<List<Admin>> fetchalladmin() {
		return service.fetchAll();
	}

	// fetchbyid
	@GetMapping("/{id}")
	public ResponseEntity<Admin> fetchId(@PathVariable int id) {
		return service.fetchById(id);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<List<Admin>> fetchEmail(@PathVariable String email)
	{
		return service.fetchByemail(email);
	}
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<String> fetchpassemail(@PathVariable String email,@PathVariable String password)
	{
		return service.logIn(email,password);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteArecord(@PathVariable int id)
	{
		return service.deleteRecord(id);
	}
	@PutMapping
	public ResponseEntity<String> updateById(@RequestBody Admin admin) {
		
		return service.saveadmin(admin);
	}
}
