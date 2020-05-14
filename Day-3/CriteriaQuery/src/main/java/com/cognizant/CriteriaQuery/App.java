package com.cognizant.CriteriaQuery;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.swing.Spring;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cognizant.CriteriaQuery.Utility.HibernateUtility;

import com.cognizant.CriteriaQuery.model.Laptop;

public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);


	public static void main(String[] args) {
		try (Session session = HibernateUtility.getSessionFactory().openSession()) {
			LOGGER.info("Start");
			String os="Windows 10";
			CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaQuery<Laptop> criteriaQuery=builder.createQuery(Laptop.class);
			Root<Laptop> root=criteriaQuery.from(Laptop.class);
			ParameterExpression<String> osParameter=builder.parameter(String.class);
			
			criteriaQuery.where(builder.equal(root.get("os"), osParameter));
			
			Query<Laptop> query=session.createQuery(criteriaQuery);
			query.setParameter(osParameter,os);
			
			List<Laptop> empList=query.list();
			empList.forEach(System.out::println);
			
			LOGGER.debug("Laptop{}:",empList);
			LOGGER.info("End");
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	
}
