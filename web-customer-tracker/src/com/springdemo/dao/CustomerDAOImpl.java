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

		// Get the current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();

		// Create the Query

		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute the query and get result list

		List<Customer> customers = theQuery.getResultList();

		// Return the results
		return customers;

	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// Get the current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();

		// Save/Update the customer

		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {
		// Get the current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();

		// Retrieve from database based on the id

		Customer theCustomer = currentSession.get(Customer.class, theId);

		// Return the result
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// Get the current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();

		// Delete object with primary key

		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerid");
			theQuery.setParameter("customerid", theId);
			
			theQuery.executeUpdate();

	}

}
