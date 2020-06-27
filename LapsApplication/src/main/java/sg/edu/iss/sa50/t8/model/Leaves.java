package sg.edu.iss.sa50.t8.model;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@MappedSuperclass
public abstract class Leaves{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int StaffId; 
	//this is the Foreign Key 
	private LeaveType leavetype;
	private LocalDate startdate;
	private LocalDate enddate;
	private LeaveStatus leaveStatus;


	public Leaves() {
		// TODO Auto-generated constructor stub
	}


	public LocalDate getStartdate() {
		return startdate;
	}


	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}


	public LocalDate getEnddate() {
		return enddate;
	}


	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}


	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}


	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}


	public int getStaffId() {
		return StaffId;
	}


	public void setStaffId(int staffId) {
		StaffId = staffId;
	}


	public LeaveType getLeavetype() {
		return leavetype;
	}


	public void setLeavetype(LeaveType leavetype) {
		this.leavetype = leavetype;
	}

}
