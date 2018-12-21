package org.nagarro.com.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "New_User_Details")
public class NewUserDetails {

	@Id
	private int userId;
	
	//@Basic //Putting basic is good if u use fetch and option attribute with it. if u are not using then no need to  put it.
	//@Transient // putting this will make that attribute not to be persisted in the DB
	private String userName;
	
	//@Temporal(TemporalType.DATE) // it will save only date not the time
	private Date joinedDate;
	private String address;
	
	// @Lob // To store the large amout of data in any attribute as by default it will be 255 varchar
	private String description;
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
