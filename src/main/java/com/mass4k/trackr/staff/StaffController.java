package com.mass4k.trackr.staff;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController 
{
	private final StaffRepository repository;
	
	StaffController(StaffRepository repository)
	{
		this.repository = repository;
	}
	
	  // Aggregate root

	  @GetMapping("/staffs")
	  List<Staff> all() 
	  {
	    return repository.findAll();
	  }

	  @PostMapping("/staffs")
	  Staff newEmployee(@RequestBody Staff newUser) 
	  {
	    return repository.save(newUser);
	  }

	  // Single item

	  @GetMapping("/staffs/{id}")
	  Staff one(@PathVariable Long id) {

	    return repository.findById(id)
	      .orElseThrow(() -> new StaffNotFoundException(id));
	  }

	  @PutMapping("/staffs/{id}")
	  Staff replaceEmployee(@RequestBody Staff newUser, @PathVariable Long id) 
	  {
	    return repository.findById(id)
	      .map(employee -> {
	        employee.setFirstName(newUser.getFirstName());
	        employee.setLastName(newUser.getLastName());
	        employee.setEmail(newUser.getEmail());
	        return repository.save(employee);
	      })
	      .orElseGet(() -> {
	    	  newUser.setId(id);
	        return repository.save(newUser);
	      });
	  }

	  @DeleteMapping("/staffs/{id}")
	  void deleteEmployee(@PathVariable Long id) 
	  {
	    repository.deleteById(id);
	  }
}
