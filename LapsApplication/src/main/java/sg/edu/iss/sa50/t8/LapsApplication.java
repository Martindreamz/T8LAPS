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
			Admin adm2 = new Admin("Martin2","e0533410@u.nus.edu");
			Manager man1 = new Manager("Joe","e0XXXXXman@u.nus.edu",null,16,20);
			Manager man2 = new Manager("Joe2","e0XXXXXman2@u.nus.edu",man1,16,15);
			Manager man3 = new Manager("Joe3","e0XXXXXman2@u.nus.edu",man2,15,15);
			Staff s1 = new Staff("Bianca","e0533381@u.nus.edu",man2,10,10);
			Staff s2 = new Staff("Bianca2","e0533382@u.nus.edu",man1,12,10);
			Staff s3 = new Staff("Bianca3","e0533383@u.nus.edu",man3,14,10);
			Staff s4 = new Staff("Yirui","e0533384@u.nus.edu",man1,20,60);
			Staff s5 = new Staff("Yirui2","e0533385@u.nus.edu",man2,4,18);
			//Constructor : Staff(name,email,int managerId, annualLeaveDays, @Max(30) int medicalLeaveDays)
			 
			LocalDate d1 = LocalDate.of(2020,5,1); 
			LocalDate d2 = LocalDate.of(2020,5,3);
			LocalDate d3 = LocalDate.of(2020,6,1); 
			LocalDate d4 = LocalDate.of(2020,6,7);
			LocalDate d5 = LocalDate.of(2020,3,3); 
			LocalDate d6 = LocalDate.of(2020,3,21);
			LocalDate d7 = LocalDate.of(2020,7,21); 
			LocalDate d8 = LocalDate.of(2020,7,23);
			LocalDate d9 = LocalDate.of(2020,9,5); 
			LocalDate d10 = LocalDate.of(2020,9,13);
			AnnualLeave al1 = new AnnualLeave(s1,d1,d2,"oversea travel");
			AnnualLeave al2 = new AnnualLeave(man2,d1,d2,"manager oversea travel");
			AnnualLeave al3 = new AnnualLeave(s2,d2,d1,"oversea travel");
			AnnualLeave al4 = new AnnualLeave(man1,d4,d5,"Family Trip");
			AnnualLeave al5 = new AnnualLeave(s3,d7,d8,"oversea travel");
			AnnualLeave al6 = new AnnualLeave(man3,d3,d4,"manager oversea travel");
			AnnualLeave al7 = new AnnualLeave(s4,d5,d6,"oversea travel");
			AnnualLeave al8 = new AnnualLeave(man1,d7,d8,"manager oversea travel");
			AnnualLeave al9 = new AnnualLeave(s5,d9,d10,"oversea travel");
			AnnualLeave al10 = new AnnualLeave(man2,d8,d9,"manager oversea travel");
	
			
			MedicalLeave ml1 = new MedicalLeave(s1,d1,d2,"covid-19");
			MedicalLeave ml2 = new MedicalLeave(man2,d1,d2,"manager covid-19");
			MedicalLeave ml3 = new MedicalLeave(s2,d2,d1,"covid-19");
			MedicalLeave ml4 = new MedicalLeave(man1,d4,d5,"manager covid-19");
			MedicalLeave ml5 = new MedicalLeave(s3,d7,d8,"covid-19");
			MedicalLeave ml6 = new MedicalLeave(man3,d3,d4,"manager covid-19");
			MedicalLeave ml7 = new MedicalLeave(s4,d5,d6,"covid-19");
			MedicalLeave ml8 = new MedicalLeave(man1,d7,d8,"manager covid-19");
			MedicalLeave ml9 = new MedicalLeave(s5,d9,d10,"covid-19");
			MedicalLeave ml10 = new MedicalLeave(man2,d8,d9,"manager covid-19");
			
			//Constructor : MedicalLeave(staff,startDate,endDate)
			Compensation com1 = new Compensation(d1,s3);
			CompensationLeave cl1 = new CompensationLeave(s3,d3,com1);
			
			
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
			alRepo.save(al2);
			alRepo.save(al3);
			alRepo.save(al4);
			alRepo.save(al5);
			alRepo.save(al6);
			alRepo.save(al7);
			alRepo.save(al8);
			alRepo.save(al9);
			alRepo.save(al10);
			mlRepo.save(ml1);
			mlRepo.save(ml2);
			mlRepo.save(ml3);
			mlRepo.save(ml4);
			mlRepo.save(ml5);
			mlRepo.save(ml6);
			mlRepo.save(ml7);
			mlRepo.save(ml8);
			mlRepo.save(ml9);
			mlRepo.save(ml10);
			
			compRepo.save(com1);
			clRepo.save(cl1);
			
			
			System.out.println("CHEERS! At Least Run Liao. Check all DB tables ba.");
			
		}; 
	}

}
