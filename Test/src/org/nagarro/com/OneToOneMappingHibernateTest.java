package org.nagarro.com;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.nagarro.com.dto.ManyToManyUserDetails;
import org.nagarro.com.dto.OneToOneMappingUserDetails;
import org.nagarro.com.dto.UserDetails;
import org.nagarro.com.dto.Vehicle;

public class OneToOneMappingHibernateTest {

	public static void main(String[] args) {

		// hibernate 4 or above way to create session
		Configuration configuration = new Configuration();
		configuration.configure("hibernate_sp.cfg.xml");

		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory ssf = configuration.buildSessionFactory(ssrb.build());
		Session currentSession = ssf.getCurrentSession();
		final SessionFactory sf = new Configuration().configure("criteria.cfg.xml").buildSessionFactory();

		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<ManyToManyUserDetails> criteriaQuery = criteriaBuilder.createQuery(ManyToManyUserDetails.class);

		Root<ManyToManyUserDetails> root = criteriaQuery.from(ManyToManyUserDetails.class);
		CriteriaQuery<ManyToManyUserDetails> selectQuery = criteriaQuery.select(root);

		Query<ManyToManyUserDetails> query = currentSession.createQuery(criteriaQuery);

		List<ManyToManyUserDetails> list = query.getResultList();
		List<ManyToManyUserDetails> resultList = currentSession.createQuery(selectQuery).getResultList();

		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("userName"), "chetan"));

		OneToOneMappingUserDetails oneMappingUserDetails = new OneToOneMappingUserDetails();
		oneMappingUserDetails.setUserName("new_user");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		oneMappingUserDetails.setVehicle(vehicle);

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(oneMappingUserDetails);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}

}
