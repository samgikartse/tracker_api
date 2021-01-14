package com.mass4k.trackr.user;


import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mass4k.trackr.appointment.Appointment;
import com.mass4k.trackr.appointment.AppointmentRepository;
import com.mass4k.trackr.role.Role;
import com.mass4k.trackr.role.RoleRepository;
import com.mass4k.trackr.service.Service;
import com.mass4k.trackr.service.ServiceRepository;
import com.mass4k.trackr.staff.Staff;
import com.mass4k.trackr.staff.StaffRepository;

@Configuration
class LoadDatabase 
{
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  

  @Bean
  CommandLineRunner initDatabase(UserRepository userrepository, 
		  ServiceRepository servicerepository, 
		  AppointmentRepository appointmentrepository,
		  RoleRepository rolerepository,
		  StaffRepository staffrepository) 
  {
	  Date date = new Date();
	  Timestamp sqlTS = new Timestamp(date.getTime());
	  
	  User user1 = new User("Bilbo Baggins", "burglar", "@someEmail");
	  User user2 = new User("Frodo Baggins", "thief", "@someOtherEmail");
	  
	  Role role1 = new Role("Technition");
	  Role role2 = new Role("admin");
	  
	  Staff staff1 = new Staff("karma", "Tesering", "@staffemail", null);
	  staff1.setRole(role1);
	  
	  Staff staff2 = new Staff("Khanh", "Ngo", "KH@staffemail", null);
	  staff2.setRole(role2);
	  
	  Service serv1 = new Service("Basic Pedicure", "33", "Something done to nail");
	  Service serv2 = new Service("Eyelash Refill", "50", "No eyelashs to eylashs");
	  
    return args -> {
      log.info("Preloading " + userrepository.save(user1));
      log.info("Preloading " + userrepository.save(user2));
      
      log.info("Preloading " + rolerepository.save(role1));
      log.info("Preloading " + rolerepository.save(role2));
      
      log.info("Preloading " + staffrepository.save(staff1));
      log.info("Preloading " + staffrepository.save(staff2));
      
      log.info("Preloading " + servicerepository.save(serv1));
      log.info("Preloading " + servicerepository.save(serv2));
      
      log.info("Preloading " + appointmentrepository.save(new Appointment(user1, staff1, serv1, sqlTS)));
      log.info("Preloading " + appointmentrepository.save(new Appointment(user2, staff2, serv2, sqlTS)));
    };
  }
}
