package org.nagarro.com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name="One_To_Many_Vehicle")
public class OneToManyVehicle {

	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	@ManyToOne
	@JoinTable(name="Vehicle_user", joinColumns=@JoinColumn(name="Vehicle_Id"),
	inverseJoinColumns=@JoinColumn(name="User_Id"))
	
	// This is used for the situation where a user doesn't have any vehicle, in those situation hibernate will throw exception
	// @NotFound(action=NotFoundAction.IGNORE) 
	private OneToManyMappingUserDetails oneToManyMappingUserDetails;
	
	
	public OneToManyMappingUserDetails getOneToManyMappingUserDetails() {
		return oneToManyMappingUserDetails;
	}
	public void setOneToManyMappingUserDetails(OneToManyMappingUserDetails oneToManyMappingUserDetails) {
		this.oneToManyMappingUserDetails = oneToManyMappingUserDetails;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
}

