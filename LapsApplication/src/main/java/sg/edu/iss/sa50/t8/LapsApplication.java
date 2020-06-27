package sg.edu.iss.sa50.t8;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import sg.edu.iss.sa50.t8.model.*;
import sg.edu.iss.sa50.t8.repository.*;


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
	CompensationRepository compRepo;
	@Autowired
	CLRepository clRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(LapsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's start to see our models! ");
			
			Admin adm1 = new Admin("Martin","e0XXXXXXadm@u.nus.edu");
			Manager man1 = new Manager("Joe","e0XXXXXman@u.nus.edu");
			Manager man2 = new Manager("Joe","e0XXXXXman2@u.nus.edu");
			Staff s1 = new Staff("Bianca","e0533381@u.nus.edu",man1,10,10);
			Staff s2 = new Staff("Bianca2","e0533382@u.nus.edu",man1,12,10);
			Staff s3 = new Staff("Bianca3","e0533383@u.nus.edu",man1,14,10);
			//Constructor : Staff(name,email,int managerId, annualLeaveDays, @Max(30) int medicalLeaveDays)
			 
			LocalDate d1 = LocalDate.of(2020,5,1); 
			LocalDate d2 = LocalDate.of(2020,5,3);
			AnnualLeave al1 = new AnnualLeave(s1,d1,d2);
			LocalDate d3 = LocalDate.of(2020,6,1); 
			LocalDate d4 = LocalDate.of(2020,6,7);
			MedicalLeave ml2 = new MedicalLeave(s1,d3,d4);
			//Constructor : MedicalLeave(staff,startDate,endDate)
			Compensation com1 = new Compensation(d1,s2);
			CompensationLeave cl1 = new CompensationLeave(s2,d3,com1);
			
			
			admRepo.save(adm1);
			manRepo.save(man1);
			manRepo.save(man2);
			stfRepo.save(s1);
			stfRepo.save(s2);
			stfRepo.save(s3);
			alRepo.save(al1);
			mlRepo.save(ml2);
			compRepo.save(com1);
			clRepo.save(cl1);
			
			
			System.out.println("CHEERS! At Least Run Liao. Check all DB tables ba.");
			
		}; 
	}

}
