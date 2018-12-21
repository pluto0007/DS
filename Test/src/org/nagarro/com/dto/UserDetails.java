package org.nagarro.com.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="User_Details") // @entity gives different name to the Entity(UserDetails) itself which is not in the case of the using @table
public class UserDetails {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Embedded // this will tell hibernate its embeddable value type within userdetails
	
	// @AttributeOverrides along with @AttributeOverride is used to override the address column name which we have defined in address entity as multiPle type of address
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="pincode", column=@Column(name="HOME_PINCODE")),
		@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME"))
	})
	private Address homeAddress;
	
	private Address officeAddress;

	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
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
	
	
}
