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
			
			Admin adm1 = new Admin("Martin","e0533409@u.nus.edu");
			Manager man1 = new Manager("Joe","e0XXXXXman@u.nus.edu",null,16,20);
			Manager man2 = new Manager("Joe2","e0XXXXXman2@u.nus.edu",man1,16,15);
			Manager man3 = new Manager("Joe2","e0XXXXXman2@u.nus.edu",man2,15,15);
			Staff s1 = new Staff("Bianca","e0533381@u.nus.edu",man2,10,10);
			Staff s2 = new Staff("Bianca2","e0533382@u.nus.edu",man1,12,10);
			Staff s3 = new Staff("Bianca3","e0533383@u.nus.edu",man3,14,10);
			//Constructor : Staff(name,email,int managerId, annualLeaveDays, @Max(30) int medicalLeaveDays)
			 
			LocalDate d1 = LocalDate.of(2020,5,1); 
			LocalDate d2 = LocalDate.of(2020,5,3);
			AnnualLeave al1 = new AnnualLeave(s1,d1,d2,"oversea travel");
			AnnualLeave al2 = new AnnualLeave(man2,d1,d2,"manager oversea travel");
			LocalDate d3 = LocalDate.of(2020,6,1); 
			LocalDate d4 = LocalDate.of(2020,6,7);
			MedicalLeave ml1 = new MedicalLeave(s1,d3,d4,"covid-19");
			MedicalLeave ml2 = new MedicalLeave(man3,d3,d4,"manager covid-19");
			//Constructor : MedicalLeave(staff,startDate,endDate)
			Compensation com1 = new Compensation(d1,s3);
			CompensationLeave cl1 = new CompensationLeave(s3,d3,com1);
			
			
			admRepo.save(adm1);
			manRepo.save(man1);
			manRepo.save(man2);
			manRepo.save(man3);
			stfRepo.save(s1);
			stfRepo.save(s2);
			stfRepo.save(s3);
			alRepo.save(al1);
			alRepo.save(al2);
			mlRepo.save(ml1);
			mlRepo.save(ml2);
			compRepo.save(com1);
			clRepo.save(cl1);
			
			
			System.out.println("CHEERS! At Least Run Liao. Check all DB tables ba.");
			
		}; 
	}

}
