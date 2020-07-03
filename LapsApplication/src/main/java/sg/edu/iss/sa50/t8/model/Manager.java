package sg.edu.iss.sa50.t8.model;

import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends Staff{
	
	public Manager() {
		super();
	}
	//Bianca New constructors Jue 28th
	public Manager(String name, String email,
			Manager manager, 
			int annualLeaveDays, int medicalLeaveDays) {
		super(name,email,manager,annualLeaveDays,medicalLeaveDays);
	}
	public Manager(String name, String email,
			Manager manager) {
		super(name,email,manager);
	}

}
