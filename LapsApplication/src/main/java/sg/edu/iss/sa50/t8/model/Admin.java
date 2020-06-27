package sg.edu.iss.sa50.t8.model;

public class Admin extends Employee{
	private boolean adminuser;
	

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean isAdminuser() {
		return adminuser;
	}


	public void setAdminuser(boolean adminuser) {
		this.adminuser = adminuser;
	}

}
