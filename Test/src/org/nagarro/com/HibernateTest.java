package org.nagarro.com;

import java.util.Date;

import javax.persistence.FetchType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.nagarro.com.dto.Address;
import org.nagarro.com.dto.CollectionUserDetails;
import org.nagarro.com.dto.NewUserDetails;
import org.nagarro.com.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		//userDetails.setUserId(1); you dont have to set it as we have used @generatedvalue
		userDetails.setUserName("chetan");
		
		Address address = new Address();
		address.setCity("first city");
		address.setPincode("first pincode");
		address.setState("first state");
		address.setStreet("first street");
		
		Address address2 = new Address();
		address2.setCity("second city");
		address2.setPincode("second pincode");
		address2.setState("second state");
		address2.setStreet("second street");
		
		userDetails.setHomeAddress(address);
		userDetails.setOfficeAddress(address2);
		
		UserDetails userDetails2 = new UserDetails();// this is for auto increatment feature to test
		userDetails2.setUserName("chetan");
		userDetails2.setHomeAddress(address);
		userDetails2.setOfficeAddress(address2);
		
		NewUserDetails newUserDetails = new NewUserDetails(); // this is for not auto generated ID and other feature which are commented in the entity
		newUserDetails.setAddress("address1");
		newUserDetails.setDescription("description");
		newUserDetails.setJoinedDate(new Date());
		newUserDetails.setUserId(1);
		newUserDetails.setUserName("kapoor");
		
		CollectionUserDetails collectionUserDetails = new CollectionUserDetails(); // this is for addresses as set(collection)
		collectionUserDetails.getListOfAddress().add(address);
		collectionUserDetails.getListOfAddress().add(address2);
		collectionUserDetails.setUserName("hibernate");
		
		// Sessionfactory is created only once per application
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.save(userDetails2);
		session.save(newUserDetails);
		session.save(collectionUserDetails);
		session.getTransaction().commit(); // we have to rollback as well in catch block
		session.close();
		
		newUserDetails = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		newUserDetails = (NewUserDetails) session.get(NewUserDetails.class, 1);
		
		System.out.println(newUserDetails.getAddress());
		
		collectionUserDetails = (CollectionUserDetails) session.get(CollectionUserDetails.class, 3);
		// If you close the session and then try to perform certain action on the second level attribute[collection within entity] of entity,
		// it will throw the exception of LazyInitializationException as by default hibernate is wired for lazy initialization.
		// this can be overriden by using "(fetch=FetchType.EAGER)" with the entity's second level attribute.
		
		session.close();
		System.out.println(collectionUserDetails.getUserId());
		System.out.println(collectionUserDetails.getListOfAddress().size());
		

	}

}
