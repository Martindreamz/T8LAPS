package sg.edu.iss.sa50.t8.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class AnnualLeave extends Leaves{
	
	private LocalDate startDate;
	private LocalDate endDate;
	//private LeaveType super.leaveType;
	public AnnualLeave() {
		super();
	}
	
	public AnnualLeave(Staff staff,LocalDate startDate, LocalDate endDate) {
		super(staff);
		super.setLeavetype(LeaveType.AnnualLeave);
		this.startDate= startDate;
		this.endDate= endDate;
	}

	public LocalDate getStartdate() {
		return startDate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startDate = startdate;
	}

	public LocalDate getEnddate() {
		return endDate;
	}

	public void setEnddate(LocalDate enddate) {
		this.endDate = enddate;
	}
}