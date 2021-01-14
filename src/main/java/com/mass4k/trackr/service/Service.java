package com.mass4k.trackr.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Service 
{
	private @Id @GeneratedValue Long id;
	private String serviceName;
	private String servicePrice;
	private String seriveDescription;
	
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service(String serviceName, String servicePrice, String seriveDescription) {
		super();
		this.serviceName = serviceName;
		this.servicePrice = servicePrice;
		this.seriveDescription = seriveDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}

	public String getSeriveDescription() {
		return seriveDescription;
	}

	public void setSeriveDescription(String seriveDescription) {
		this.seriveDescription = seriveDescription;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", serviceName=" + serviceName + ", servicePrice=" + servicePrice
				+ ", seriveDescription=" + seriveDescription + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((seriveDescription == null) ? 0 : seriveDescription.hashCode());
		result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
		result = prime * result + ((servicePrice == null) ? 0 : servicePrice.hashCode());
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
		Service other = (Service) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (seriveDescription == null) {
			if (other.seriveDescription != null)
				return false;
		} else if (!seriveDescription.equals(other.seriveDescription))
			return false;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		if (servicePrice == null) {
			if (other.servicePrice != null)
				return false;
		} else if (!servicePrice.equals(other.servicePrice))
			return false;
		return true;
	}
}
