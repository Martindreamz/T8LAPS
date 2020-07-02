package sg.edu.iss.sa50.t8.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("staff")
public class Staff extends Employee{
	
	//Check & Edit by Bianca: add validation and mapping setting
	
	//managerid is the FK need to build mapping 
	@ManyToOne  @JoinColumn(name="manager_id")
	private Manager manager;
	@OneToMany(mappedBy="staff") 
	private List<Leaves> leaves;
	
	private int CurrentAnnualLeaves;
	private int CurrentMedicalLeaves; 
	private int TotalAnnualLeaves;
	private int TotalMedicalLeaves;
	
	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Staff() {
	}
	public Staff(String name, String email) {
		super(name,email);
	}
	//Bianca New constructors
	public Staff(String name, String email,Manager manager, int annualLeaveDays, int medicalLeaveDays) {
		super(name,email);
		this.manager = manager;
		this.CurrentAnnualLeaves = annualLeaveDays;
		this.CurrentMedicalLeaves = medicalLeaveDays;
	}

	public int getAnnualLeaveDays() {
		return CurrentAnnualLeaves;
	}


	public void setAnnualLeaveDays(int annualLeaveDays) {
		this.CurrentAnnualLeaves = annualLeaveDays;
	}


	public int getMedicalLeaveDays() {
		return CurrentMedicalLeaves;
	}


	public void setMedicalLeaveDays(int medicalLeaveDays) {
		this.CurrentMedicalLeaves = medicalLeaveDays;
	}


}
