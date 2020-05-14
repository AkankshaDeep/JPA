package com.cognizant.EmployeeH;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.cognizant.EmployeeH.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee emp=new Employee();
        
        emp.setFirstName("Ak");
        emp.setLastName("Deep");
        emp.setSalary(10000);
        
        int eid=addEmployee(emp);
        displayEmployee();
        
    }
    public static Integer addEmployee(Employee emp){
    	Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        int eid=emp.getEid();
        Transaction tx = null;
        try {

        	tx=session.beginTransaction();
            session.save(emp);
            
            tx.commit();
            
        	} catch (HibernateException e) {

        	if (tx != null) tx.rollback();

        	e.printStackTrace();

        	} finally {

        	session.close();

        	}
		return eid;
    }
    public static void displayEmployee() {
    	Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sf=con.buildSessionFactory();
    	Session session = sf.getCurrentSession();
    	Query query=null;
    	List<Employee> emplist=null;  
    	Transaction tx=session.beginTransaction();
    	query=session.createQuery("from Employee");   
    	emplist=query.list();
    	
    	for(Employee emp:emplist){
    		System.out.println("Employee:"+emp.toString());
    	}
    	Employee e= (Employee)session.get(Employee.class, new Integer(11));
    	System.out.println("Get employee="+e.toString());
    	int delId=e.getEid();
    	session.delete(e);
    	System.out.println("Deleted "+delId);
    	tx.commit();
    	session.close();
    }
     
    
    
}
