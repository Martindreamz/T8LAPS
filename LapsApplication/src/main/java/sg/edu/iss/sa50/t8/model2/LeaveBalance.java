package sg.edu.iss.sa50.t8.model2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class LeaveBalance {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne
	private LeaveTypes leaveType;
	@OneToMany
	private Employee employee;
	private int currentBalance;
	
	public LeaveBalance() {
		
	}

	public LeaveTypes getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveTypes leaveType) {
		this.leaveType = leaveType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}
}
