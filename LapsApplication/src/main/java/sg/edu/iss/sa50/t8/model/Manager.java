package sg.edu.iss.sa50.t8.model;

import java.util.List;

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
			long annualLeaveDays, long medicalLeaveDays) {
		super(name,email,manager,annualLeaveDays,medicalLeaveDays);
	}
	

}
