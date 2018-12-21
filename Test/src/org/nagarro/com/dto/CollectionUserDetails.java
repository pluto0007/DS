package org.nagarro.com.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name="Collection_User_Details") // @entity gives different name to the Entity(UserDetails) itself which is not in the case of the using @table
public class CollectionUserDetails {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	// This is used for collection as the attribute
	@ElementCollection(fetch=FetchType.EAGER)
	
	// This is to override the name given by hibernate automatically to the table "CollectionUserDetails_listOfAddress"
	@JoinTable(name="USER_ADDRESS",
				// this is to override the name given by hibernate automatically to the column name "CollectionUserDetails_listOfAddress(CollectionUserDetails_user_id, ..)"
				joinColumns=@JoinColumn(name="USER_ID")
			)
	
	// This is to generate primary Id in the USER_ADDRESS table along with that we have provided the generator as well
	// we are going to change the data type from SET to arraylist as it has index which set don't have it.
	
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	//private Set<Address> listOfAddress = new HashSet();
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	
	
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
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

