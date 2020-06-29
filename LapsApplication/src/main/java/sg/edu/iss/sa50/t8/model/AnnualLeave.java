package sg.edu.iss.sa50.t8.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@DiscriminatorValue("Annual_Leave")
public class AnnualLeave extends Leaves{
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="dd/mm/yyyy")
	private Date endDate;
	private String contactDetails;

	//private LeaveType super.leaveType;
	public AnnualLeave() {
		super();
	}

	public AnnualLeave(Date endDate, String contactDetails) {
		super();
		this.endDate = endDate;
		this.contactDetails = contactDetails;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	
	
	
}