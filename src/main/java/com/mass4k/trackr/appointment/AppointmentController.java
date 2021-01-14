package com.mass4k.trackr.appointment;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController 
{
	private AppointmentRepository repository;
	
	AppointmentController(AppointmentRepository repository)
	{
		this.repository = repository;
	}
	
	// Aggregate root
	
	@GetMapping("/appointments")
	  List<Appointment> allAppointment() 
	  {
	    return repository.findAll();
	  }

	  @PostMapping("/appointments")
	  Appointment newAppointment(@RequestBody Appointment newAppointment) 
	  {
	    return repository.save(newAppointment);
	  }

	  // Single item

	  @GetMapping("/appointments/{id}")
	  Appointment appointmentById(@PathVariable Long id) {

	    return repository.findById(id)
	      .orElseThrow(() -> new AppointmentNotFoundException(id));
	  }

	  @PutMapping("/appointments/{id}")
	  Appointment replaceAppointment(@RequestBody Appointment newAppointment, @PathVariable Long id) 
	  {
	    return repository.findById(id)
	      .map(appointment -> {
	    	  appointment.setUser(newAppointment.getUser());
	    	  appointment.setStaff(newAppointment.getStaff());;
	    	  appointment.setService(newAppointment.getService());;
	    	  appointment.setDatetime(newAppointment.getDatetime());
	        return repository.save(newAppointment);
	      })
	      .orElseGet(() -> {
	    	  newAppointment.setId(id);
	        return repository.save(newAppointment);
	      });
	  }

	  @DeleteMapping("/appointments/{id}")
	  void deleteAppointment(@PathVariable Long id) 
	  {
	    repository.deleteById(id);
	  }	
}
