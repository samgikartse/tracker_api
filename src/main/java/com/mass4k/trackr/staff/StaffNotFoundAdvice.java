package com.mass4k.trackr.staff;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StaffNotFoundAdvice 
{
	@ResponseBody
	@ExceptionHandler(StaffNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String UserNotFoundHandler(StaffNotFoundException ex)
	{
		return ex.getMessage();
	}
}
