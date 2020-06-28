package sg.edu.iss.sa50.t8.service;

import org.springframework.mail.MailException;

import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.model.Leaves;
import sg.edu.iss.sa50.t8.model.MedicalLeave;

public interface EmailService {

	public void notifyManager(MedicalLeave leave) throws MailException;

	public void notifyManager(AnnualLeave leave) throws MailException;

	public void notifyStaff(AnnualLeave leave) throws MailException;

	public void notifyStaff(MedicalLeave leave) throws MailException;

	public void confirmStaffCancellation(AnnualLeave leave) throws MailException;

	public void confirmStaffCancellation(MedicalLeave leave) throws MailException;

}
