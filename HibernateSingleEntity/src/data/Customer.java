package data;

import java.time.LocalDate;

public class Customer {
	//Atributes
	private long customerId;
	private String lastName;
	private String firstName;
	private int nationalId;
	private LocalDate birthdate;
	private boolean inactive;
	
	//Empty constructor
	public Customer(){}

	//Constructor using fields
	public Customer(String lastName, String firstName, int nationalId, LocalDate birthdate) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.nationalId = nationalId;
		this.birthdate = birthdate;
		this.inactive = false;
	}

	//Getters and Setters
	public long getCustomerId() {
		return customerId;
	}


	protected void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public int getNationalId() {
		return nationalId;
	}


	public void setNationalId(int nationalId) {
		this.nationalId = nationalId;
	}


	public LocalDate getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}


	public boolean isInactive() {
		return inactive;
	}


	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}

	//toString method
	@Override
	public String toString() {
		return "Customer\n\tcustomerId: " + customerId + "\n\tlastName: " + lastName + "\n\tfirstName: " + firstName
				+ "\n\tnationalId: " + nationalId + "\n\tbirthdate: " + birthdate + "\n\tinactive: " + inactive + "]";
	}
	
	
	
}
