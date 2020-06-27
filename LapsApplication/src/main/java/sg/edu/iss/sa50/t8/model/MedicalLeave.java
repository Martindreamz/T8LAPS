package sg.edu.iss.sa50.t8.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class MedicalLeave extends Leaves {
	private LocalDate startDate;
	private LocalDate endDate;

	public MedicalLeave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicalLeave(Staff staff,LocalDate startDate, LocalDate endDate) {
		super(staff);
		super.setLeavetype(LeaveType.MedicalLeave);
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
