package sg.edu.iss.sa50.t8.model2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class OverTime {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int overtimeHours;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date startDate;
	
	@ManyToOne
	private Employee employee;
	
	public OverTime() {}

	public int getOvertimeHours() {
		return overtimeHours;
	}

	public void setOvertimeHours(int overtimeHours) {
		this.overtimeHours = overtimeHours;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
