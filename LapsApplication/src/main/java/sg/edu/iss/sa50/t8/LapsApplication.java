package sg.edu.iss.sa50.t8;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import sg.edu.iss.sa50.t8.model.Admin;
import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.model.BlockedLeaves;
import sg.edu.iss.sa50.t8.model.CompensationLeave;
import sg.edu.iss.sa50.t8.model.LeaveStatus;
import sg.edu.iss.sa50.t8.model.Manager;
import sg.edu.iss.sa50.t8.model.MedicalLeave;
import sg.edu.iss.sa50.t8.model.Overtime;
import sg.edu.iss.sa50.t8.model.OvertimeStatus;
import sg.edu.iss.sa50.t8.model.Staff;
import sg.edu.iss.sa50.t8.repository.BlockedLeavesRepository;
import sg.edu.iss.sa50.t8.repository.EmployeeRepository;
import sg.edu.iss.sa50.t8.repository.LeaveRepository;
import sg.edu.iss.sa50.t8.repository.OvertimeRepository;
import sg.edu.iss.sa50.t8.service.EmailService;


@SpringBootApplication
public class LapsApplication {

	@Autowired
	EmployeeRepository empRepo;
	/*
	 * @Autowired StaffRepository stfRepo;
	 * 
	 * @Autowired AdminRepository admRepo;
	 * 
	 * @Autowired ManagerRepository manRepo;
	 */
	@Autowired
	LeaveRepository lRepo;
	@Autowired
	OvertimeRepository oRepo;
	
	@Autowired
	EmailService ems;
	
	@Autowired
	BlockedLeavesRepository blRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(LapsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's start to see our models! ");
			
			Admin adm1 = new Admin("Martin","martin.dreamz@hotmail.com");
			Admin adm2 = new Admin("Martin2","e0533410@u.nus.edu");
			Manager man1 = new Manager("Joe","martin.dreamz@hotmail.com",null,16,20);
			Manager man2 = new Manager("Joe2","martin.dreamz@hotmail.com",man1,16,15);
			Manager man3 = new Manager("Joe3","martin.dreamz@hotmail.com",man2,15,15);
			Staff s1 = new Staff("Martin1","martin.dreamz@hotmail.com",man2,10,10);
			s1.setTotalOTHours(4);
			Staff s2 = new Staff("Bianca2","e0533382@u.nus.edu",man1,12,10);
			Staff s3 = new Staff("Bianca3","e0533383@u.nus.edu",man3,14,10);
			Staff s4 = new Staff("Yirui","e0533384@u.nus.edu",man1,20,60);
			Staff s5 = new Staff("Yirui2","martin.dreamz@hotmail.com",man2,4,18);
			
			
			
			//set max leaves
			man1.setAnnualLeaveDays(18);
			man2.setAnnualLeaveDays(18);
			man3.setAnnualLeaveDays(18);
			s1.setAnnualLeaveDays(14);
			s2.setAnnualLeaveDays(14);
			s3.setAnnualLeaveDays(14);
			s4.setAnnualLeaveDays(14);
			s5.setAnnualLeaveDays(14);
			
			Date d1 = new SimpleDateFormat("MM/dd/yyyy").parse("01/05/2020");
			Date d2 = new SimpleDateFormat("MM/dd/yyyy").parse("03/05/2020");

			Date d3 = new SimpleDateFormat("MM/dd/yyyy").parse("01/05/2019");
			Date d4 = new SimpleDateFormat("MM/dd/yyyy").parse("03/05/2019");
			
			Date d5 = new SimpleDateFormat("MM/dd/yyyy").parse("09/09/2020");
			Date d6 = new SimpleDateFormat("MM/dd/yyyy").parse("09/12/2020");
			
			Date d7 = new SimpleDateFormat("MM/dd/yyyy").parse("08/08/2020");
			Date d8 = new SimpleDateFormat("MM/dd/yyyy").parse("08/12/2020");

			AnnualLeave al1 = new AnnualLeave(d2, "oversea travel");
			al1.setStartDate(d1);
			al1.setStaff(s1);
			al1.setLeaveReason("Moving House");
			al1.setStatus(LeaveStatus.Approved);
			
			AnnualLeave al2 = new AnnualLeave(d8, "asia missing");
			al2.setStartDate(d7);
			al2.setStaff(s1);
			al2.setLeaveReason("visit korea");
			al2.setStatus(LeaveStatus.Approved);
			
			AnnualLeave al3 = new AnnualLeave(d2, "oversea travel");
			al3.setStartDate(d1);
			al3.setStaff(s5);
			al3.setLeaveReason("Moving House");
			al3.setStatus(LeaveStatus.Approved);
			
			AnnualLeave al4 = new AnnualLeave(d2, "oversea travel");
			al4.setStartDate(d1);
			al4.setStaff(man2);
			al4.setLeaveReason("Moving House");
			al4.setStatus(LeaveStatus.Approved);
			
			AnnualLeave al5 = new AnnualLeave(d6, "oversea travel");
			al5.setStartDate(d5);
			al5.setStaff(s5);
			al5.setLeaveReason("Moving House");
			al5.setStatus(LeaveStatus.Approved);
			
			MedicalLeave ml2 = new MedicalLeave(d4);
			ml2.setStartDate(d3);
			ml2.setStaff(s3);
			ml2.setLeaveReason("Fever");
			ml2.setManagerComment("Not Set");
			
			MedicalLeave ml3 = new MedicalLeave(d6);
			ml3.setStartDate(d5);
			ml3.setStaff(s1);
			ml3.setLeaveReason("High Fever");
			ml3.setManagerComment("Not Set");
			ml3.setStatus(LeaveStatus.Approved);
			
			MedicalLeave ml1 = new MedicalLeave(d2);
			ml1.setStartDate(d1);
			ml1.setStaff(s3);
			ml1.setLeaveReason("Stomatch ache");
			ml1.setManagerComment("Not Set");
			
			Overtime ot1 = new Overtime(d1,s1,4);
			ot1.setOverTimeStatus(OvertimeStatus.Approved);
			Overtime ot2 = new Overtime(d2,s1,4);
			ot2.setOverTimeStatus(OvertimeStatus.Rejected);
			Overtime ot3 = new Overtime(d1,s1,1);
			ot3.setOverTimeStatus(OvertimeStatus.Applied);
			Overtime ot4 = new Overtime(d2,s1,3);
			ot4.setOverTimeStatus(OvertimeStatus.Applied);
			Overtime ot5 = new Overtime(d1,s5,4);
			ot5.setOverTimeStatus(OvertimeStatus.Applied);
			Overtime ot6 = new Overtime(d2,s5,4);
			ot6.setOverTimeStatus(OvertimeStatus.Applied);
			Overtime ot7 = new Overtime(d1,s5,1);
			ot7.setOverTimeStatus(OvertimeStatus.Applied);
			Overtime ot8 = new Overtime(d2,s5,3);
			ot8.setOverTimeStatus(OvertimeStatus.Applied);
			
			
			
			
			
			CompensationLeave c =new CompensationLeave("Half Day PM");
			c.setStartDate(d2);
			c.setStaff(s1);
			c.setLeaveReason("Compensation 1");
			c.setStatus(LeaveStatus.Approved);
			
			empRepo.save(adm1);
			empRepo.save(adm2);
			empRepo.save(man1);
			empRepo.save(man2);
			empRepo.save(man3);
			
			empRepo.save(s1);
			empRepo.save(s2);
			empRepo.save(s3);
			empRepo.save(s4);
			empRepo.save(s5);
			
			lRepo.save(al1);
			lRepo.save(al2);
			lRepo.save(al3);
			lRepo.save(al4);
			lRepo.save(al5);
			lRepo.save(ml1);
			lRepo.save(ml2);
			lRepo.save(ml3);
			lRepo.save(al2);
			lRepo.save(c);
			
			oRepo.save(ot1);
			oRepo.save(ot2);
			oRepo.save(ot3);
			oRepo.save(ot4);
			oRepo.save(ot5);
			oRepo.save(ot6);
			oRepo.save(ot7);
			oRepo.save(ot8);
		

			Date h1 = new SimpleDateFormat("yyyy/MM/dd").parse("2020/01/01");
			Date h2 = new SimpleDateFormat("yyyy/MM/dd").parse("2020/01/25");
			Date h3 = new SimpleDateFormat("yyyy/MM/dd").parse("2020/01/26");
			Date h4 = new SimpleDateFormat("yyyy/MM/dd").parse("2020/04/10");			
			Date h5 = new SimpleDateFormat("yyyy/MM/dd").parse("2020/05/01");
			Date h6 = new SimpleDateFormat("yyyy/MM/dd").parse("2020/05/07");			
			Date h7 = new SimpleDateFormat("yyyy/MM/dd").parse("2020/05/24");
			Date h8 = new SimpleDateFormat("yyyy/MM/dd").parse("2020/07/31");
			Date h9 = new SimpleDateFormat("yyyy/MM/dd").parse("2020/08/09");
			Date h10 = new SimpleDateFormat("yyyy/MM/dd").parse("2020/11/14");
			Date h11 = new SimpleDateFormat("yyyy/MM/dd").parse("2020/12/25");

			BlockedLeaves blLeaves1 = new BlockedLeaves("New Year", h1);
			BlockedLeaves blLeaves2 = new BlockedLeaves("Chinese New Year", h2);
			BlockedLeaves blLeaves3 = new BlockedLeaves("Chinese New Year", h3);
			BlockedLeaves blLeaves4 = new BlockedLeaves("Good Friday", h4);
			BlockedLeaves blLeaves5 = new BlockedLeaves("Labour's Day", h5);
			BlockedLeaves blLeaves6 = new BlockedLeaves("Vesak's Day", h6);
			BlockedLeaves blLeaves7 = new BlockedLeaves("Hari Raya Puasa", h7);
			BlockedLeaves blLeaves8 = new BlockedLeaves("Hari Raya Hagi", h8);
			BlockedLeaves blLeaves9 = new BlockedLeaves("National Day", h9);
			BlockedLeaves blLeaves10 = new BlockedLeaves("Deepavali", h10);
			BlockedLeaves blLeaves11 = new BlockedLeaves("Christmas Day", h11);
			
			blRepo.save(blLeaves1);
			blRepo.save(blLeaves2);
			blRepo.save(blLeaves3);
			blRepo.save(blLeaves4);
			blRepo.save(blLeaves5);
			blRepo.save(blLeaves6);
			blRepo.save(blLeaves7);
			blRepo.save(blLeaves8);
			blRepo.save(blLeaves9);
			blRepo.save(blLeaves10);
			blRepo.save(blLeaves11);
			
			
			System.out.println("CHEERS! At Least Run Liao. Check all DB tables ba.");
			System.out.println("I want to test the discriminator:");
			System.out.println(al1.getDiscriminatorValue());
			System.out.println(adm1.getDiscriminatorValue());
			
	
			

		}; 
	}

}
