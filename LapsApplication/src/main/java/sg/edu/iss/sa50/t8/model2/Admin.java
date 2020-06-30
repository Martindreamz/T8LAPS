package sg.edu.iss.sa50.t8.model2;
import javax.persistence.*;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Employee {

	public Admin() {
		super();
	}

}
