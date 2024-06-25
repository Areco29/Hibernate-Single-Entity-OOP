package test;

import java.time.LocalDate;

import service.CustomerCRUD;

public class TestAddCustomer {

	public static void main(String[] args) {

		CustomerCRUD  crud = new CustomerCRUD(); 

		//Show all current customers saved in the database
		System.out.println(crud.retrieveCustomer());
		
		System.out.println("\n===========================================\n");
		
		//Add a new customer
		try {
			crud.addCustomer("LastName", "FirstName", 35000000, LocalDate.now());
			System.out.println("\n-Customer added.\n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		System.out.println("\n===========================================\n");
		//Show current customers saved after adding new customer
		System.out.println(crud.retrieveCustomer());
		
		
	}

}
