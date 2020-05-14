package com.cognizant.CriteriaQuery;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.cognizant.CriteriaQuery.Utility.HibernateUtility;

import com.cognizant.CriteriaQuery.model.Laptop;

public class SaveData {
	public static void main(String[] args) {

		try (Session session = HibernateUtility.getSessionFactory().openSession()) {
			session.beginTransaction();
			Laptop laptop=new Laptop();
			laptop.setLaptopName("Leneovo");
			laptop.setCpu("Core i3");
			laptop.setCpuSpeed(1.70);
			laptop.setHardDiskSize(1.00);
			laptop.setOs("Windows 10");
			laptop.setRamSize(8.00);
			laptop.setReview(4);
			laptop.setWeight(1.5);
		

			Laptop laptop1=new Laptop();
			laptop1.setLaptopName("HP");
			laptop1.setCpu("Core i5");
			laptop1.setCpuSpeed(2.70);
			laptop1.setHardDiskSize(1.00);
			laptop1.setOs("Windows 10");
			laptop1.setRamSize(4.00);
			laptop1.setReview(3);
			laptop1.setWeight(1.3);
		
			Laptop laptop2=new Laptop();
			laptop2.setLaptopName("HP");
			laptop2.setCpu("Core i3");
			laptop2.setCpuSpeed(1.99);
			laptop2.setHardDiskSize(1.00);
			laptop2.setOs("Windows 8");
			laptop2.setRamSize(8.00);
			laptop2.setReview(2);
			laptop2.setWeight(1.5);
			
			Laptop laptop3=new Laptop();
			laptop3.setLaptopName("Dell");
			laptop3.setCpu("Core i5");
			laptop3.setCpuSpeed(2.70);
			laptop3.setHardDiskSize(1.00);
			laptop3.setOs("Windows 10");
			laptop3.setRamSize(4.00);
			laptop3.setReview(3);
			laptop3.setWeight(1.3);
	
			Laptop laptop4=new Laptop();
			laptop4.setLaptopName("Lenovo");
			laptop4.setCpu("Core i7");
			laptop4.setCpuSpeed(2.70);
			laptop4.setHardDiskSize(1.00);
			laptop4.setOs("Windows 10");
			laptop4.setRamSize(4.00);
			laptop4.setReview(3);
			laptop4.setWeight(1.3);
	
			session.save(laptop);
			session.save(laptop1);
			session.save(laptop2);
			session.save(laptop3);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
