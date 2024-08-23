package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Admin;

public interface Adminrepository extends JpaRepository<Admin ,Integer > {

	List<Admin> findByEmail(String email);

	List<Admin> findByEmailAndPassword(String email, String password);
      
}
