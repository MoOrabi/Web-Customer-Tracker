package com.moorabi.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.moorabi.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session=sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery=session.createQuery("from Customer order by lastName",Customer.class);
		List<Customer> customers= theQuery.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(long id) {
		Session session=sessionFactory.getCurrentSession();
		Customer theCustomer=session.get(Customer.class, id);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(Customer theCustomer) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(theCustomer);
	}
	
	@Override
	public List<Customer> getCustomersByName(String name) {
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> theQuery = null;
		if(name!=null && name.trim().length()>0) {
			theQuery=session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name",Customer.class);
			theQuery.setParameter("name", "%" + name.toLowerCase() + "%");
		}else {
			theQuery=session.createQuery("from Customer ",Customer.class);
		}
		List<Customer> theCustomers=theQuery.getResultList();
		return theCustomers;
	}

}
