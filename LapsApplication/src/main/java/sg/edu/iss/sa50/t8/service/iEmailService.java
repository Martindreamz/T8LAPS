package sg.edu.iss.sa50.t8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.model.MedicalLeave;
import sg.edu.iss.sa50.t8.model.Overtime;

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
		msg.setFrom("gdipsa50t8@gmail.com");
		msg.setSubject("Leave application from " + leave.getStaff().getName());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\n\n"+leave.getStaff().getName()+ " applied annual leave from "+leave.getStartDate().toString()+" to "+
				leave.getEndDate().toString()+".\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);
	}

	@Override
	public void notifyManager(MedicalLeave leave) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(leave.getStaff().getManager().getEmail());
		msg.setFrom("gdipsa50t8@gmail.com");
		msg.setSubject("Leave application from " + leave.getStaff().getName());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\n\n"+leave.getStaff().getName()+ " applied medical leave from "+leave.getStartDate().toString()+" to "+
				leave.getEndDate().toString()+".\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);

	}
	@Override
	public void notifyStaff(AnnualLeave leave) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(leave.getStaff().getManager().getEmail());
		msg.setFrom("gdipsa50t8@gmail.com");
		msg.setSubject("Leave application on " + leave.getStartDate() + " " + leave.getStatus());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\n\nYour application for annual leave from "+leave.getStartDate().toString()+" to "+
				leave.getEndDate().toString() +" has been " + leave.getStatus()+".\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);

	}

	@Override
	public void notifyStaff(MedicalLeave leave) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(leave.getStaff().getManager().getEmail());
		msg.setFrom("gdipsa50t8@gmail.com");
		msg.setSubject("Leave application on " + leave.getStartDate() + " " + leave.getStatus());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\n\nYour application for medical leave from "+leave.getStartDate().toString()+" to "+
				leave.getEndDate().toString() +" has been " + leave.getStatus()+".\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);
	}

	@Override
	public void confirmStaffCancellation(AnnualLeave leave) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(leave.getStaff().getManager().getEmail());
		msg.setFrom("gdipsa50t8@gmail.com");
		msg.setSubject("Leave cancellation on " + leave.getStartDate());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\n\nThis is to confirm your cancellation of annual leave from "+leave.getStartDate().toString()+" to "+
				leave.getEndDate().toString()+".\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);
	}

	@Override
	public void confirmStaffCancellation(MedicalLeave leave) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(leave.getStaff().getManager().getEmail());
		msg.setFrom("gdipsa50t8@gmail.com");
		msg.setSubject("Leave cancellation on " + leave.getStartDate());
		msg.setText("Dear " + leave.getStaff().getName()+ ",\nThis is to confirm your cancellation of medical leave from "+leave.getStartDate().toString()+" to "+
				leave.getEndDate().toString()+".\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);

	}
	
	@Override
	public void notifyManagerForOT(Overtime ot) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(ot.getStaff().getManager().getEmail());
		msg.setFrom("gdipsa50t8@gmail.com");
		msg.setSubject("Overtime Application on " + ot.getOvertimeDate());
		msg.setText("Dear " + ot.getStaff().getManager().getName()+ ",\nYour Staff "+ot.getStaff().getName() +" applied "+ot.getOvertimeHours()+" hours of overtime on "+
				ot.getOvertimeDate()+".\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);
	}
	
	@Override
	public void notifyStaffForOT(Overtime ot) throws MailException{
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(ot.getStaff().getEmail());
		msg.setFrom("gdipsa50t8@gmail.com");
		msg.setSubject("Overtime Application on " + ot.getOvertimeDate() + " " + ot.getOverTimeStatus());
		msg.setText("Dear " + ot.getStaff().getName()+ ",\nYour application of "+ot.getOvertimeHours()+" hours of overtime on "+
				ot.getOvertimeDate()+" has been "+ ot.getOverTimeStatus()+".\n\nFrom,\nTeam8LAPS");
		jvm.send(msg);
	}
}
