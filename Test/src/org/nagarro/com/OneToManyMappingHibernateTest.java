package org.nagarro.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.nagarro.com.dto.OneToManyMappingUserDetails;
import org.nagarro.com.dto.OneToManyVehicle;

public class OneToManyMappingHibernateTest {

	public static void main(String[] args) {
		OneToManyMappingUserDetails manyMappingUserDetails = new OneToManyMappingUserDetails();
		manyMappingUserDetails.setUserName("kapoor");
		
		OneToManyVehicle vehicles = new OneToManyVehicle();
		vehicles.setVehicleName("Car");
		vehicles.setOneToManyMappingUserDetails(manyMappingUserDetails);
		
		OneToManyVehicle vehicle2 = new OneToManyVehicle();
		vehicle2.setVehicleName("jeep");
		vehicle2.setOneToManyMappingUserDetails(manyMappingUserDetails);
		
		manyMappingUserDetails.getVehicles().add(vehicles);
		manyMappingUserDetails.getVehicles().add(vehicle2);

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.getCriteriaBuilder().createQuery();
		session.beginTransaction();
		session.save(manyMappingUserDetails);
		session.save(vehicles);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}

}
