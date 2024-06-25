package test;

import service.CustomerCRUD;

public class TestDeleteCustomer {

	public static void main(String[] args) {
		
		CustomerCRUD crud = new CustomerCRUD();
		
		// Show the customer to delete 
		long idCustomerToDelete = 1L;
		System.out.printf("\nCustomer to delete: %s", crud.retrieveCustomer(idCustomerToDelete));

		System.out.println("\n===========================================\n");
		
		// Delete the customer
		try {
			crud.deleteCustomer(idCustomerToDelete);
			System.out.println("\n-Deleted.\n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n===========================================\n");
		
		// Show all current customer in database
		System.out.println("Customers saved in database: "+crud.retrieveCustomer());
	}

}
