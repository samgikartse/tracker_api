package com.mass4k.trackr.appointment;

public class AppointmentNotFoundException extends RuntimeException
{
	/*
	 * 
	 */
	AppointmentNotFoundException (Long id) 
	{
		super("Could not find Appointment " + id);
	}

}
