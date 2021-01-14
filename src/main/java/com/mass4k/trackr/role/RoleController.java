package com.mass4k.trackr.role;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController 
{
	private RoleRepository repository;
	
	RoleController(RoleRepository repository)
	{
		this.repository = repository;
	}
	
	// Aggregate root
	
	@GetMapping("/roles")
	  List<Role> allRole() 
	  {
	    return repository.findAll();
	  }

	  @PostMapping("/roles")
	  Role newRole(@RequestBody Role newRole) 
	  {
	    return repository.save(newRole);
	  }

	  // Single item

	  @GetMapping("/roles/{id}")
	  Role roleById(@PathVariable Long id) {

	    return repository.findById(id)
	      .orElseThrow(() -> new RoleNotFoundException(id));
	  }

	  @PutMapping("/roles/{id}")
	  Role replaceRole(@RequestBody Role newRole, @PathVariable Long id) 
	  {
	    return repository.findById(id)
	      .map(role -> {
	    	  role.setRole(newRole.getRole());
	        return repository.save(newRole);
	      })
	      .orElseGet(() -> {
	    	  newRole.setId(id);
	        return repository.save(newRole);
	      });
	  }

	  @DeleteMapping("/roles/{id}")
	  void deleteRole(@PathVariable Long id) 
	  {
	    repository.deleteById(id);
	  }
}
