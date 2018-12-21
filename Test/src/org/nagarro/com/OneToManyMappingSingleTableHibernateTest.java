package org.nagarro.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.nagarro.com.dto.OneToManyMappingUserDetailsWithOnetable;
import org.nagarro.com.dto.OneToManyVehicle;
import org.nagarro.com.dto.OneToManyVehicleWithOneTable;

public class OneToManyMappingSingleTableHibernateTest {

	public static void main(String[] args) {
		OneToManyMappingUserDetailsWithOnetable manyMappingUserDetails = new OneToManyMappingUserDetailsWithOnetable();
		manyMappingUserDetails.setUserName("kapoor");
		
		OneToManyVehicleWithOneTable vehicles = new OneToManyVehicleWithOneTable();
		vehicles.setVehicleName("Car");
		vehicles.setOneToManyMappingUserDetailsWithOnetable(manyMappingUserDetails);
		
		
		OneToManyVehicleWithOneTable vehicle2 = new OneToManyVehicleWithOneTable();
		vehicle2.setVehicleName("jeep");
		vehicle2.setOneToManyMappingUserDetailsWithOnetable(manyMappingUserDetails);
		
		manyMappingUserDetails.getVehicles().add(vehicles);
		manyMappingUserDetails.getVehicles().add(vehicle2);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(manyMappingUserDetails);
		session.save(vehicles);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}

}
