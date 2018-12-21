package org.nagarro.com.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name="one_to_Many_User_details_single_table")
public class OneToManyMappingUserDetailsWithOnetable {
	
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	
	@OneToMany(mappedBy="oneToManyMappingUserDetailsWithOnetable")
	private Collection<OneToManyVehicleWithOneTable> vehicles = new ArrayList<OneToManyVehicleWithOneTable>();
	
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
	public Collection<OneToManyVehicleWithOneTable> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<OneToManyVehicleWithOneTable> vehicles) {
		this.vehicles = vehicles;
	}

	

}
