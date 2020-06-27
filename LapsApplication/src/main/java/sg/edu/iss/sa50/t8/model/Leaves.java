package sg.edu.iss.sa50.t8.model;

import javax.persistence.*;
//import java.time.LocalDate;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Leaves{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne @JoinColumn(name="staff_id") 
	private Staff staff;
	//this is the Foreign Key 
	private LeaveType leavetype;
	private LeaveStatus leaveStatus;

	// a full Constructor
	public Leaves() {
		super();
		this.leaveStatus = LeaveStatus.Applied;
	}
	public Leaves(Staff  staff) {
		super();
		this.leaveStatus = LeaveStatus.Applied;
		this.staff = staff;
	}


	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}


	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}


	/*
	 * public int getStaffId() { return StaffId; }
	 * 
	 * 
	 * public void setStaffId(int staffId) { StaffId = staffId; }
	 */


	public LeaveType getLeavetype() {
		return leavetype;
	}


	public void setLeavetype(LeaveType leavetype) {
		this.leavetype = leavetype;
	}

}
