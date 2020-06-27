package sg.edu.iss.sa50.t8.model;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.Past;


@Entity
public class Compensation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int compensationId;
	@Past
	private LocalDate overtimeDate; 
	@ManyToOne @JoinColumn(name="staff_id")
	private Staff staff; 
	private CompensationStatus compStatus; //Declared/approved/rejected/...
	//private LeaveStatus leaveStatus; // Relationship?
	@OneToOne @JoinColumn(name="leave_id")
	private Leaves leaveMatch;

	public Compensation() {
		super();
	}

	public Compensation(@Past LocalDate overtimeDate, Staff staff) {
		super();
		this.overtimeDate = overtimeDate;
		this.staff = staff;
		this.compStatus=CompensationStatus.Declared;
	}

	public int getCompensationId() {
		return compensationId;
	}

	public void setCompensationId(int compensationId) {
		this.compensationId = compensationId;
	}

	public LocalDate getOvertimeDate() {
		return overtimeDate;
	}

	public void setOvertimeDate(LocalDate overtimeDate) {
		this.overtimeDate = overtimeDate;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public CompensationStatus getCompStatus() {
		return compStatus;
	}

	public void setCompStatus(CompensationStatus compStatus) {
		this.compStatus = compStatus;
	}

	public Leaves getLeaveMatch() {
		return leaveMatch;
	}

	public void setLeaveMatch(Leaves leaveMatch) {
		this.leaveMatch = leaveMatch;
	} 

	

}
