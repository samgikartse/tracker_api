package com.mass4k.trackr.role;

public class RoleNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	RoleNotFoundException (Long id)
	{
		super("Could not find role " + id);
	}

}
