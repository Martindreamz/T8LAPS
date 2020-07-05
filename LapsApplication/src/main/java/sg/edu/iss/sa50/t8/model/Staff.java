package sg.edu.iss.sa50.t8.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Staff")
public class Staff extends Employee{

	@ManyToOne(cascade={CascadeType.MERGE}) @JoinColumn(name="manager_id")
	private Manager manager;

	@OneToMany(mappedBy="staff",cascade={CascadeType.MERGE,CascadeType.REMOVE}) 
	private List<Leaves> leaves;
	
	@OneToMany(mappedBy="staff",cascade={CascadeType.MERGE,CascadeType.REMOVE}) 
	private List<Overtime> overtimes;

	public Staff() {}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Staff(String name, String email) {
		super(name,email);
	}
	//New constructors
	public Staff(String name, String email,Manager manager, Long annualLeaveDays, Long medicalLeaveDays) {
		super(name,email,annualLeaveDays,medicalLeaveDays);
		this.manager = manager;
	}


}
