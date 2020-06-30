package sg.edu.iss.sa50.t8.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compensation_eligibility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne @JoinColumn(name="staff_id")
	private Staff staff;
	
	private int availableHours;
	public Compensation_eligibility() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compensation_eligibility(Staff staff, int availableHours) {
		super();
		this.staff = staff;
		this.availableHours = availableHours;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	public int getAvailableHours() {
		return availableHours;
	}
	public void setAvailableHours(int availableHours) {
		this.availableHours = availableHours;
	}
	
	
}
