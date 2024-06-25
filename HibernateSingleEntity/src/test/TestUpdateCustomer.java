package test;

import data.Customer;
import service.CustomerCRUD;

public class TestUpdateCustomer {

	public static void main(String[] args) {

		CustomerCRUD  crud = new CustomerCRUD(); 
		Customer c = crud.retrieveCustomer(1L);
		
		//Show a customer retrieved from the database
		System.out.println(c);
		
		System.out.println("\n===========================================\n");
		
		//Update that customer's national ID and save the changes in the database
		try {
			c.setNationalId(22222222);
			crud.updateCustomer(c);
			System.out.println("\n-Customer updated.\n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n===========================================\n");
		
		//Show the customer after the update
		System.out.println(crud.retrieveCustomer(1L)); //Retrieve again to show the updated customer
		

	}

}
