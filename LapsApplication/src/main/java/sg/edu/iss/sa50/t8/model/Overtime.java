package sg.edu.iss.sa50.t8.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Past;

@Entity
public class Overtime {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	@Past
	private Date overtimeDate; 
	
	@ManyToOne @JoinColumn(name="staff_id")
	private Staff staff; 
	
	private double totalHours;
	
	public Overtime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Overtime(@Past Date overtimeDate, Staff staff, int totalHours) {
		super();
		this.overtimeDate = overtimeDate;
		this.staff = staff;
		this.totalHours = totalHours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOvertimeDate() {
		return overtimeDate;
	}

	public void setOvertimeDate(Date overtimeDate) {
		this.overtimeDate = overtimeDate;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}

	public Overtime(@Past Date overtimeDate, int totalHours) {
		super();
		this.overtimeDate = overtimeDate;
		this.totalHours = totalHours;
	}
	
	
}
