package org.nagarro.com.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="Many_to_Many_User_details")
public class ManyToManyUserDetails {
	
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	
	@ManyToMany
	private Collection<ManyToManyVehicle> vehicles = new ArrayList<ManyToManyVehicle>();

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<ManyToManyVehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<ManyToManyVehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
