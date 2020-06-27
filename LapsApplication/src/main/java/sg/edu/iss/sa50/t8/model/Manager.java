package sg.edu.iss.sa50.t8.model;

import java.util.List;

public class Manager extends Employee{
	private String dept;
	private List<Staff> staffList;
	private boolean IsManager;
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

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
