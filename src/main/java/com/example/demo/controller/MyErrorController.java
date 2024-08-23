package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MyErrorController implements ErrorController {

	@RequestMapping("/error")
	public String error(HttpServletRequest request) {
		int status = (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status == 404)
			return "Sorry your url is wrong";

		else if (status == 500)
			return "There is some mistake in logic";

		else if (status == 400)
			return "check values you are sending";
		else if (status == 404)
			return "Method is not correct check";
		else
			return "something went wrong";
	}
}
