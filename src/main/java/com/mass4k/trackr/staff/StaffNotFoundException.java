package com.mass4k.trackr.staff;

class StaffNotFoundException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	StaffNotFoundException (Long id) 
	{
		super("Could not find User " + id);
	}

}
