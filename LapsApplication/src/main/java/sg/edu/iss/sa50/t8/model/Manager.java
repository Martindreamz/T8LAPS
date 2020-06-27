package sg.edu.iss.sa50.t8.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class Manager extends Employee{
	//private String dept;
	@OneToMany(mappedBy="manager") 
	private List<Staff> staffList;
	private boolean IsManager;
	public Manager() {
		super();
		IsManager = true;
	}
	//Bianca New constructors
	public Manager(String name, String email) {
			super(name,email);
		}
	
	@OneToMany
	public List<Staff> getStaffList() {
		return staffList;
	}
	@OneToMany
	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	public boolean isIsManager() {
		return IsManager;
	}

	public void setIsManager(boolean isManager) {
		IsManager = isManager;
	}

}
