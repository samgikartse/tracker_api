package com.mass4k.trackr.service;

public class ServiceNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ServiceNotFoundException (Long id) 
	{
		super("Could not find Service " + id);
	}
}
