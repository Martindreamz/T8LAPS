package sg.edu.iss.sa50.t8.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Compensation Leave")
public class CompensationLeave extends Leaves{

	private String claimQuota;

	public CompensationLeave() {
		super();
		super.setStatus(LeaveStatus.Applied);
		super.setLeaveType(LeaveType.Compensation);
	}

	public CompensationLeave(String claimQuota) {
		super();
		this.claimQuota = claimQuota;
		super.setStatus(LeaveStatus.Applied);
		super.setLeaveType(LeaveType.Compensation);
	}

	public String getClaimQuota() {
		return claimQuota;
	}

	public void setClaimQuota(String claimQuota) {
		this.claimQuota = claimQuota;
	}

}
