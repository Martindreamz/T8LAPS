package sg.edu.iss.sa50.t8.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Compensation Leave")
public class CompensationLeave extends Leaves{

	private int comLeaveHours;

	public CompensationLeave() {
		super();
		//super.setLeaveType("Compensation Leave");
	}

	public CompensationLeave(int comLeaveHours) {
		super();
		this.comLeaveHours = comLeaveHours;
		//super.setLeaveType("Compensation Leave");
	}

	public int getComLeaveHours() {
		return comLeaveHours;
	}

	public void setComLeaveHours(int comLeaveHours) {
		this.comLeaveHours = comLeaveHours;
	}

	

}
