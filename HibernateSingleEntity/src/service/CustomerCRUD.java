package service;

import java.time.LocalDate;
import java.util.List;

import dao.CustomerDao;
import data.Customer;

/* Java class implementing CRUD operations and others methods using the CustomerDAO
 * to interact with the database*/

public class CustomerCRUD {
	CustomerDao dao = new CustomerDao();
	
	/* Creates a new Customer and adds it to the database using the Customer DAO.
	 * 
	 * @param lastName The last name of the new customer.
	 * @param firstName The first name of the new customer.
	 * @param nationalId The national identifier of the new customer.
	 * @param birthdate The birth date of the new customer.
	 * @return The ID of the new customer added.
	 * @throws Exception If there is a customer with the same nationalId.
	 **/
	public int addCustomer(String  lastName, String firstName, int nationalId, LocalDate birthdate) throws Exception {
		
		Customer c = dao.retrieveCustomer(nationalId);
		
		if(c != null ) throw new Exception("ERROR(addCustomer): A customer with the same nationalId already exists.");
		
		return dao.addCustomer(new Customer(lastName, firstName, nationalId, birthdate));
	}

	/* Updates an existing Customer in the database.
	 * @param c The customer to update.
	 * @throws Exception If there is another customer with the same nationalId.
	 **/
	public void updateCustomer(Customer c) throws Exception {

		if(dao.retrieveCustomer(c.getNationalId())!= null ) throw new Exception("ERROR(updateCustomer): Another customer with the same nationalId already exists.");
		
		dao.updateCustomer(c);
	}
	
	/* Deletes an existing customer from the database by its ID.
	 * 
	 * @param idCustomer The identifier of the customer to delete.
	 * @throws Exception If the customer doesn't exist.
	 **/
	public void deleteCustomer(long idCustomer) throws Exception {
		Customer c = dao.retrieveCustomer(idCustomer);
		
		
		if(c==null) throw new Exception("ERROR(deleteCustomer): The customer to delete doesn't exist.");
		
		dao.deleteCustomer(c);
	}
	
	/* Retrieves a customer from the database by its ID.
	 * @param idCustomer The identifier of the Customer to retrieve.
	 * @return The Customer retrieved, or NULL if not found.
	 **/
	public Customer retrieveCustomer(long idCustomer) {
		return dao.retrieveCustomer(idCustomer);
	}
	
	/* Retrieves a list of all customers from the database ordered by surname and name.
	  * @return A list containing all customers with the specified order.
	 **/
	public List<Customer> retrieveCustomer(){
		return dao.retrieveCustomer();
	}
	
	/* Retrieves a customer from the database by its nationalId
	 * @param nationalId The national identifier to retrieve.
	 * @return The Customer retrieved, or null if not found.
	 **/
	public Customer retrieveCustomer(int nationalId) {
		return dao.retrieveCustomer(nationalId);
	}
}
