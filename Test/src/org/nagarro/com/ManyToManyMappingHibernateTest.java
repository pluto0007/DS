package org.nagarro.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.nagarro.com.dto.ManyToManyUserDetails;
import org.nagarro.com.dto.ManyToManyVehicle;
import org.nagarro.com.dto.OneToManyVehicleWithOneTable;
import org.nagarro.com.dto.Vehicle;

public class ManyToManyMappingHibernateTest {

	public static void main(String[] args) {
		ManyToManyUserDetails manyMappingUserDetails = new ManyToManyUserDetails();
		manyMappingUserDetails.setUserName("kapoor");
		
		ManyToManyVehicle vehicles = new ManyToManyVehicle();
		vehicles.setVehicleName("Car");
		vehicles.getManyToManyUserDetailsList().add(manyMappingUserDetails);
		
		ManyToManyVehicle vehicle2 = new ManyToManyVehicle();
		vehicle2.setVehicleName("jeep");
		vehicle2.getManyToManyUserDetailsList().add(manyMappingUserDetails);
		
		manyMappingUserDetails.getVehicles().add(vehicles);
		manyMappingUserDetails.getVehicles().add(vehicle2);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// Vehicle loadedVehcile = (Vehicle)session.load(Vehicle.class,1); // to load the proxy object
		
		// session.evict(loadedVehcile); to delete the particular object from first level cache.
		// session.clear(); // to delete entire cache.
		// session.contains(loadedVehicle) // To check the object in the cache
		
		session.save(manyMappingUserDetails);
		session.save(vehicles);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}

}
