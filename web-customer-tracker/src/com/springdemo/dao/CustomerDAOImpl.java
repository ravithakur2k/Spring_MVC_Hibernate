package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		//Get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create the Query
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
		
		//execute the query and get result list
		
		List<Customer> customers = theQuery.getResultList();
		
		//Return the results
		return customers;
		
		
	}

}
