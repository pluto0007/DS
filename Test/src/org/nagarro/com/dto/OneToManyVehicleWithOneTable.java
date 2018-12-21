package org.nagarro.com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity(name="One_To_Many_Vehicle_One_Table")
public class OneToManyVehicleWithOneTable {

	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	@ManyToOne
	@JoinColumn(name="User_ID")
	private OneToManyMappingUserDetailsWithOnetable oneToManyMappingUserDetailsWithOnetable;
	
	

	public OneToManyMappingUserDetailsWithOnetable getOneToManyMappingUserDetailsWithOnetable() {
		return oneToManyMappingUserDetailsWithOnetable;
	}
	
	public void setOneToManyMappingUserDetailsWithOnetable(
			OneToManyMappingUserDetailsWithOnetable oneToManyMappingUserDetailsWithOnetable) {
		this.oneToManyMappingUserDetailsWithOnetable = oneToManyMappingUserDetailsWithOnetable;
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

