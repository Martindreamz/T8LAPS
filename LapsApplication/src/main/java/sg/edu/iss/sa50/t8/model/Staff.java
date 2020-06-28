package sg.edu.iss.sa50.t8.model;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Staff extends Employee{
	
	//Check & Edit by Bianca: add validation and mapping setting
	
	//managerid is the FK need to build mapping 
	@ManyToOne  @JoinColumn(name="manager_id")
	private Manager manager;
	@OneToMany(mappedBy="staff") 
	private List<Leaves> leaves;
	@OneToMany(mappedBy="staff") 
	private List<Compensation> compensations;
	@Max(20)
	private int annualLeaveDays;
	@Max(60)
	private int medicalLeaveDays; 

	
	public Staff() {
	}

	//Bianca New constructors
	public Staff(String name, String email,Manager manager, @Max(20) int annualLeaveDays, @Max(60) int medicalLeaveDays) {
		super(name,email);
		this.manager = manager;
		this.annualLeaveDays = annualLeaveDays;
		this.medicalLeaveDays = medicalLeaveDays;
	}


	public List<Compensation> getCompensations() {
		return compensations;
	}

	public void setCompensations(List<Compensation> compensations) {
		this.compensations = compensations;
	}
	 
	public int getAnnualLeaveDays() {
		return annualLeaveDays;
	}


	public void setAnnualLeaveDays(int annualLeaveDays) {
		this.annualLeaveDays = annualLeaveDays;
	}


	public int getMedicalLeaveDays() {
		return medicalLeaveDays;
	}


	public void setMedicalLeaveDays(int medicalLeaveDays) {
		this.medicalLeaveDays = medicalLeaveDays;
	}


}
