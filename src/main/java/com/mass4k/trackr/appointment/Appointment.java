package com.mass4k.trackr.appointment;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.mass4k.trackr.service.Service;
import com.mass4k.trackr.staff.Staff;
import com.mass4k.trackr.user.User;

@Entity
public class Appointment 
{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Staff staff;
	
	@OneToOne
	private Service service;
	
	private Timestamp sqlTS;
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public Appointment(User user, Staff staff, Service service, Timestamp sqlTS) {
		super();
		this.user = user;
		this.staff = staff;
		this.service = service;
		this.sqlTS = sqlTS;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Timestamp getDatetime() {
		return sqlTS;
	}

	public void setDatetime(Timestamp sqlTS) {
		this.sqlTS = sqlTS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sqlTS == null) ? 0 : sqlTS.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((staff == null) ? 0 : staff.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (sqlTS == null) {
			if (other.sqlTS != null)
				return false;
		} else if (!sqlTS.equals(other.sqlTS))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (staff == null) {
			if (other.staff != null)
				return false;
		} else if (!staff.equals(other.staff))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", user=" + user + ", staff=" + staff + ", service=" + service + ", datetime="
				+ sqlTS + "]";
	}	
}