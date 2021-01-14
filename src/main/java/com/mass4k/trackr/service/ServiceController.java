package com.mass4k.trackr.service;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController
{
	private final ServiceRepository repository;
	
	ServiceController(ServiceRepository repository)
	{
		this.repository = repository;
	}
	
	// Aggregate root
	
	@GetMapping("/services")
	  List<Service> allService() 
	  {
	    return repository.findAll();
	  }

	  @PostMapping("/services")
	  Service newService(@RequestBody Service newService) 
	  {
	    return repository.save(newService);
	  }

	  // Single item

	  @GetMapping("/services/{id}")
	  Service serviceById(@PathVariable Long id) {

	    return repository.findById(id)
	      .orElseThrow(() -> new ServiceNotFoundException(id));
	  }

	  @PutMapping("/services/{id}")
	  Service replaceService(@RequestBody Service newService, @PathVariable Long id) 
	  {
	    return repository.findById(id)
	      .map(service -> {
	    	  service.setServiceName(newService.getServiceName());
	    	  service.setServicePrice(newService.getServicePrice());
	    	  service.setSeriveDescription(newService.getSeriveDescription());
	        return repository.save(newService);
	      })
	      .orElseGet(() -> {
	    	  newService.setId(id);
	        return repository.save(newService);
	      });
	  }

	  @DeleteMapping("/services/{id}")
	  void deleteService(@PathVariable Long id) 
	  {
	    repository.deleteById(id);
	  }
	
	

	
}
