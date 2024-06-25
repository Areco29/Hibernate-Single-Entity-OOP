package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Customer;
/*
 *  Data Access Object (DAO) for managing Customer entities using Hibernate.
 **/
public class CustomerDao {
	private Session session;
	private Transaction tx;
	
	/* Begins a new database transaction.
	 * 
	 * throws HibernateException If there is an issue starting the transaction.
	 **/
	private void beginOperation() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	/* Handles HibernateException by rolling back the transaction and throwing
	 * a wrapped exception.
	 * 
	 * @param he The HibernateException to handle.
	 * @throws HibernateException The wrapped exception with a custom message.
	 **/
	private void handleException(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("\nERROR in data access object.",he);
	}
	
	
	/* Adds a new customer to the database.
	 * 
	 * @param newCustomer The new Customer to add.
	 * @return The ID of the new customer added.
	 * @throws HibernateException If there is an issue adding the customer.
	 **/
	public int addCustomer(Customer newCustomer) {
		int id = 0;
		
		try {
			beginOperation();
			id = (int)session.save(newCustomer);
			tx.commit();
			
		}catch(HibernateException he) {
			
			handleException(he);
			
		}finally {
			session.close();
		}
		
		return id;
	}
	
	/* Updates an existing Customer in the database.
	 * @param c The customer to update.
	 * @throws HibernateException If there is an issue updating the customer.
	 **/
	public void updateCustomer(Customer c) {
		
		try {
			beginOperation();
			session.update(c);
			tx.commit();
		}catch(HibernateException he) {
			
			handleException(he);
			
		}finally {
			session.close();
		}
		
	}
	
	/* Deletes an existing customer from the database.
	 * 
	 * @param c The customer to delete.
	 * @throws HibernateException If there is an issue deleting the customer.
	 **/
	public void deleteCustomer(Customer c) {
		
		try {
			beginOperation();
			session.delete(c);
			tx.commit();
		}catch(HibernateException he) {
			
			handleException(he);
			
		}finally {
			session.close();
		}
		
	}
	
	/* Retrieves a customer from the database by its ID.
	 * @param idCustomer The identifier of the Customer to retrieve.
	 * @return The Customer retrieved, or NULL if not found.
	 **/
	public Customer retrieveCustomer(long idCustomer) {
		Customer customer = null;
		
		try {
			beginOperation();
			customer = session.get(Customer.class, idCustomer);
		}finally {
			session.close();
		}
		
		return customer;
	}

	 /* Retrieves a list of all customers from the database ordered by surname and name.
	  * @return A list containing all customers with the specified order.
	 **/
	public List<Customer> retrieveCustomer() {
		List<Customer> list = new ArrayList<Customer>();
		
		try {
			beginOperation();
			list = session.createQuery("from Customer c order by c.lastName asc, c.firstName asc",Customer.class)
					.getResultList();
		}finally {
			session.close();
		}
		
		return list;
	}
	
	/* Retrieves a customer from the database by its nationalId
	 * @param nationalId The national identifier to retrieve.
	 * @return The Customer retrieved.
	 **/
	public Customer retrieveCustomer(int nationalId) {
		Customer c= null;
	
		try {
			beginOperation();
			c = session.createQuery("from Customer c where c.nationalId = :nationalId",Customer.class)
					.setParameter("nationalId", nationalId)
					.uniqueResult();
		}finally {
			session.close();
		}
		
		return c;
	}
	
}
