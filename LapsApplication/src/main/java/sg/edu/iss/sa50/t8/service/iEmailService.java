package sg.edu.iss.sa50.t8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.model.Leaves;
import sg.edu.iss.sa50.t8.model.MedicalLeave;
import sg.edu.iss.sa50.t8.repository.EmployeeRepository;
import sg.edu.iss.sa50.t8.repository.LeaveRepository;

@Service
public class iEmailService implements EmailService{

	private JavaMailSender jvm;

	@Autowired
	public iEmailService(JavaMailSender jvm) {
		this.jvm = jvm;
	}

	@Override
	public void notifyManager(AnnualLeave leave) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(leave.getStaff().getManager().getEmail());
		msg.setFrom("martni.dreamz@gmail.com");
		msg.setSubject("Leave application from " + leave.getStaff().getName());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\n\n"+leave.getStaff().getName()+ " applied annual leave from "+leave.getStartdate().toString()+" to "+
				leave.getEnddate().toString()+"\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);
	}

	@Override
	public void notifyManager(MedicalLeave leave) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(leave.getStaff().getManager().getEmail());
		msg.setFrom("martni.dreamz@gmail.com");
		msg.setSubject("Leave application from " + leave.getStaff().getName());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\n\n"+leave.getStaff().getName()+ " applied medical leave from "+leave.getStartdate().toString()+" to "+
				leave.getEnddate().toString()+"\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);

	}
	@Override
	public void notifyStaff(AnnualLeave leave) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(leave.getStaff().getManager().getEmail());
		msg.setFrom("martni.dreamz@gmail.com");
		msg.setSubject("Leave application on " + leave.getStartdate() + " " + leave.getLeaveStatus());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\n\nYour application for annual leave from "+leave.getStartdate().toString()+" to "+
				leave.getEnddate().toString() +" has been " + leave.getLeaveStatus()+"\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);

	}

	@Override
	public void notifyStaff(MedicalLeave leave) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(leave.getStaff().getManager().getEmail());
		msg.setFrom("martni.dreamz@gmail.com");
		msg.setSubject("Leave application on " + leave.getStartdate() + " " + leave.getLeaveStatus());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\n\nYour application for medical leave from "+leave.getStartdate().toString()+" to "+
				leave.getEnddate().toString() +" has been " + leave.getLeaveStatus()+"\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);
	}

	@Override
	public void confirmStaffCancellation(AnnualLeave leave) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(leave.getStaff().getManager().getEmail());
		msg.setFrom("martni.dreamz@gmail.com");
		msg.setSubject("Leave cancellation on " + leave.getStartdate());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\n\nThis is to confirm your cancellation of annual leave from "+leave.getStartdate().toString()+" to "+
				leave.getEnddate().toString()+"\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);
	}

	@Override
	public void confirmStaffCancellation(MedicalLeave leave) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(leave.getStaff().getManager().getEmail());
		msg.setFrom("martni.dreamz@gmail.com");
		msg.setSubject("Leave cancellation on " + leave.getStartdate());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\nThis is to confirm your cancellation of medical leave from "+leave.getStartdate().toString()+" to "+
				leave.getEnddate().toString()+"\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);

	}
}
