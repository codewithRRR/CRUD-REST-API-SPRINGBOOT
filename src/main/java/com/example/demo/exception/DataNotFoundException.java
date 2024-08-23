package com.example.demo.exception;

public class DataNotFoundException extends RuntimeException {
String message="No data found";

public String getMessage() {
	return message;
}

public DataNotFoundException() {
	super();
}

public DataNotFoundException(String message) {
	super();
	this.message = message;
}


}
