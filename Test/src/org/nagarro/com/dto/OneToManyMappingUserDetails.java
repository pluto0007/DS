package org.nagarro.com.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name="One_to_Many_User_details")
public class OneToManyMappingUserDetails {
	
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	
	@OneToMany
	@JoinTable(name="Many_User_Vehicle",joinColumns=@JoinColumn(name="User_id"),
	inverseJoinColumns=@JoinColumn(name="Vehicle_id"))
	private Collection<OneToManyVehicle> vehicles = new ArrayList<OneToManyVehicle>();
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
	public Collection<OneToManyVehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<OneToManyVehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	

}
