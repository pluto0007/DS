package org.nagarro.com.dto;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="Many_TO_Many_Vehicle")
public class ManyToManyVehicle {

	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	// Using "(mappedBy="vehicles")" makes one One table instead of two[Many_to_Many_User_details_Many_TO_Many_Vehicle, Many_TO_Many_Vehicle_Many_to_Many_User_details]
	// as we have mentioned it is an many to many, so both vehicle and user details tables containing information about each
	// other will be created if we dont use the mappedBy.
	@ManyToMany(mappedBy="vehicles")
	private Collection<ManyToManyUserDetails> manyToManyUserDetailsList = new ArrayList<ManyToManyUserDetails>();

	public Collection<ManyToManyUserDetails> getManyToManyUserDetailsList() {
		return manyToManyUserDetailsList;
	}
	public void setManyToManyUserDetailsList(Collection<ManyToManyUserDetails> manyToManyUserDetailsList) {
		this.manyToManyUserDetailsList = manyToManyUserDetailsList;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
/*		Class.forName("ManyToManyVehicle").newInstance();
		Constructor constructor = ManyToManyVehicle.class.getDeclaredConstructor();
		constructor.newInstance();*/
		this.vehicleName = vehicleName;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
}
