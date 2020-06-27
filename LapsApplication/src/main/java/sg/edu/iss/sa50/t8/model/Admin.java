package sg.edu.iss.sa50.t8.model;
import javax.persistence.*;

@Entity
public class Admin extends Employee {

	// this I am not sure haha
	private boolean IsAdmin;

	public Admin() {
		super();
	}
	
	public Admin(String name, String email) { 
		super(name,email);
		IsAdmin = true;
		super.setPassword("admin");
        
    }

	public boolean isIsAdmin() {
		return IsAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		IsAdmin = isAdmin;
	}

}
