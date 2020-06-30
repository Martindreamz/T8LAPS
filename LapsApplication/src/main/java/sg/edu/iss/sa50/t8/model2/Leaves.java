package sg.edu.iss.sa50.t8.model2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Null;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Leaves {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String leaveReason;
	private String managerComment;
	@Null
	private String contactDetails;
	private LeaveStatus status;
	private int comLeaveHours;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	@Null
	private Date endDate;
	
	@OneToOne
	private LeaveTypes leaveType;
	@ManyToOne
	private Employee employee;
	
	public Leaves() {}

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

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public LeaveStatus getStatus() {
		return status;
	}

	public void setStatus(LeaveStatus status) {
		this.status = status;
	}

	public int getComLeaveHours() {
		return comLeaveHours;
	}

	public void setComLeaveHours(int comLeaveHours) {
		this.comLeaveHours = comLeaveHours;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public LeaveTypes getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveTypes leaveType) {
		this.leaveType = leaveType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
