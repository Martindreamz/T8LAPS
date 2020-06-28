package sg.edu.iss.sa50.t8.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
public class Manager extends Staff{
	@OneToMany(mappedBy="manager") 
	private List<Staff> staffList;
	public Manager() {
		super();
	}
	//Bianca New constructors Jue 28th
	public Manager(String name, String email,
			Manager manager, 
			@Max(20) int annualLeaveDays, @Max(30) int medicalLeaveDays) {
		super(name,email,manager,annualLeaveDays,medicalLeaveDays);
	}
		
	/* remove this constructor changing manager into a subclass of Staff
	 * public Manager(String name, String email) {
			super(name,email);
		}*/
	
	@OneToMany
	public List<Staff> getStaffList() {
		return staffList;
	}
	@OneToMany
	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

}
