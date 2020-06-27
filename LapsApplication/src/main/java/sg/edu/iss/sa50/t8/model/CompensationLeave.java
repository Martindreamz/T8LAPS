package sg.edu.iss.sa50.t8.model;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class CompensationLeave extends Leaves{
	
	private LocalDate leaveDate;
	@OneToOne(cascade = CascadeType.REFRESH)
	private Compensation compensation;
	
	public CompensationLeave() {
		super();
	}
	public CompensationLeave(Staff  staff,LocalDate leaveDate,Compensation compensation) {
		super(staff);
		this.leaveDate=leaveDate;
		this.compensation=compensation;
		super.setLeavetype(LeaveType.CompensationLeave);
	}
	
	public LocalDate getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(LocalDate leaveDate) {
		this.leaveDate = leaveDate;
	}

}
