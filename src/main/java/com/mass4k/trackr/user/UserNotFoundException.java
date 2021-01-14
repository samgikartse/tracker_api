package com.mass4k.trackr.user;

class UserNotFoundException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserNotFoundException (Long id) 
	{
		super("Could not find User " + id);
	}

}
