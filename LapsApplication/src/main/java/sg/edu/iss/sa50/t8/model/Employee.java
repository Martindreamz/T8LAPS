package sg.edu.iss.sa50.t8.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;


	private String name;


	public Employee() {
		// TODO Auto-generated constructor stub
	}


}
