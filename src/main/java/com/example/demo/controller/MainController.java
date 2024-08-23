package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Controller
@OpenAPIDefinition(info = @Info(title = "ADMIN CRUD" ,description = "Rest Api for performing crud operation by using Spring Boot",version = "1.0",contact=@Contact(email="ralshithsalian776@gmail.com",name="Rakshith")))
public class MainController {

	@GetMapping("/")
	public String loadswagger()
	{
		return "redirect:/swagger-ui/index.html";
		
	}
}
