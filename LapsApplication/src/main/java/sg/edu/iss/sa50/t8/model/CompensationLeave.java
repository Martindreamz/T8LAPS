package sg.edu.iss.sa50.t8.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Compensation_Leave")
public class CompensationLeave extends Leaves{

	private int comLeaveHours;

	public CompensationLeave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompensationLeave(int comLeaveHours) {
		super();
		this.comLeaveHours = comLeaveHours;
	}

	public int getComLeaveHours() {
		return comLeaveHours;
	}

	public void setComLeaveHours(int comLeaveHours) {
		this.comLeaveHours = comLeaveHours;
	}

	

}
