package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calci")
public class Calculator {

	@GetMapping("/add/{a}/{b}")
	public String add(@PathVariable int a, @PathVariable int b) {
		return "Result is " + (a + b);
	}

	@GetMapping("/sub/{a}/{b}")
	public String sub(@PathVariable int a, @PathVariable int b) {
		return "Result is " + (a - b);

	}

	@GetMapping("/mul/{a}/{b}")
	public String mul(@PathVariable int a, @PathVariable int b) {
		return "Result is " + (a * b);
	}

	@GetMapping("/div/{a}/{b}")
	public String div(@PathVariable double a, @PathVariable double  b) {
		return "Result is " + (a / b);
	}
}
