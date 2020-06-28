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
	private LeaveStatus leaveStatus;
	private String leaveReason;
	private String managerComment;

	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getManagerComment() {
		return managerComment;
	}
	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}
	public Leaves() {
		super();
	}
	public Leaves(Staff  staff,String leaveReason) {
		super();
		this.leaveStatus = LeaveStatus.Applied;
		this.staff = staff;
		this.leaveReason=leaveReason;
		
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



}
