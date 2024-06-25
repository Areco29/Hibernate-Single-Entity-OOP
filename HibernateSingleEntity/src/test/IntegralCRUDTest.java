package test;

import java.time.LocalDate;

import data.Customer;
import service.CustomerCRUD;

public class IntegralCRUDTest {

	public static void main(String[] args) {
		
		CustomerCRUD crud = new CustomerCRUD();
		
		// Retrieve list of all customers in Database.
		System.out.println("Customers saved in database: "+crud.retrieveCustomer());

		System.out.println("\n===========================================\n");
		
		// Add new Customers
		try {
			crud.addCustomer("LastName1", "FirstName1", 36000000, LocalDate.now());
			crud.addCustomer("LastName2", "FirstName2", 37000000, LocalDate.now());
			crud.addCustomer("LastName3", "FirstName3", 38000000, LocalDate.now());
			System.out.println("\n-New customers Added.\n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n===========================================\n");
		
		// Retrieve the object of the first customer
		Customer customerRetrieved = crud.retrieveCustomer().get(0);
		System.out.printf("\nCustomer retrieved: %s\n",customerRetrieved);

		System.out.println("\n===========================================\n");
		
		// Modify a field of the retrieved customer and update it.
		customerRetrieved.setNationalId(77777777);
		try {
			crud.updateCustomer(customerRetrieved);
			System.out.println("\n-Customer modified.\n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n===========================================\n");
		
		// Retrieve list of all customers in Database.
		System.out.println("Customers saved in database: "+crud.retrieveCustomer());
	}

}
