package com.neo.employee.app.employeerestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice 
{
	@ExceptionHandler(EmployeeExistsException.class)
	public ResponseEntity<String> handleEmployeeExistsException(EmployeeExistsException employeeAlreadyExistsException)
	{
		return new ResponseEntity<String>("Employee Already Exists", HttpStatus.BAD_REQUEST);
	}
}
