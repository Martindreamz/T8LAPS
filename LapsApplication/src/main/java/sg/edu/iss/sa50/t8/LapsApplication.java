package sg.edu.iss.sa50.t8;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

import sg.edu.iss.sa50.t8.model.*;
import sg.edu.iss.sa50.t8.repository.*;
import sg.edu.iss.sa50.t8.service.EmailService;
import sg.edu.iss.sa50.t8.service.iEmailService;


@SpringBootApplication
public class LapsApplication {

	@Autowired
	EmployeeRepository empRepo;
	@Autowired
	StaffRepository stfRepo;
	@Autowired
	AdminRepository admRepo;
	@Autowired
	ManagerRepository manRepo;
	@Autowired
	LeaveRepository lRepo;
	@Autowired
	ALRepository alRepo;
	@Autowired
	MLRepository mlRepo;
	@Autowired
	CLRepository clRepo;
	
	@Autowired
	EmailService ems;
	
	

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
			Staff s1 = new Staff("Martin","martin.dreamz@hotmail.com",man2,10,10);
			Staff s2 = new Staff("Bianca2","e0533382@u.nus.edu",man1,12,10);
			Staff s3 = new Staff("Bianca3","e0533383@u.nus.edu",man3,14,10);
			Staff s4 = new Staff("Yirui","e0533384@u.nus.edu",man1,20,60);
			Staff s5 = new Staff("Yirui2","e0533385@u.nus.edu",man2,4,18);
			//Constructor : Staff(name,email,int managerId, annualLeaveDays, @Max(30) int medicalLeaveDays)
			 
			Date d1 = new SimpleDateFormat("dd-mm-yyyy").parse("1-5-2020");
			Date d2 = new SimpleDateFormat("dd-mm-yyyy").parse("3-5-2020");

			AnnualLeave al1 = new AnnualLeave(d2, "oversea travel");
		
			al1.setStartDate(d1);
			al1.setStatus(LeaveStatus.Applied);
			al1.setStaff(s1);
			al1.setLeaveReason("Moving House");
			al1.setMangerComment("hello");
			
			admRepo.save(adm1);
			admRepo.save(adm2);
			manRepo.save(man1);
			manRepo.save(man2);
			manRepo.save(man3);
			
			stfRepo.save(s1);
			stfRepo.save(s2);
			stfRepo.save(s3);
			stfRepo.save(s4);
			stfRepo.save(s5);
			
			alRepo.save(al1);
			
			System.out.println("CHEERS! At Least Run Liao. Check all DB tables ba.");
			System.out.println("CHEERS! At Least Run Liao. Check all DB tables ba.");
			
			
			/*
			 * ems.notifyManager(al1); ems.notifyManager(ml1); ems.notifyStaff(al1);
			 * ems.notifyStaff(ml1); ems.confirmStaffCancellation(al1);
			 * ems.confirmStaffCancellation(ml1); System.out.println("emails sent");
			 */

			
			
		}; 
	}

}
