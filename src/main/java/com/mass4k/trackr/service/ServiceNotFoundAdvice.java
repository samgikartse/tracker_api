package com.mass4k.trackr.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ServiceNotFoundAdvice 
{
	@ResponseBody
	@ExceptionHandler(ServiceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String AppointmentNotFoundHandler(ServiceNotFoundException ex)
	{
		return ex.getMessage();
	}
}
