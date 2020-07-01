package sg.edu.iss.sa50.t8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.Staff;
import sg.edu.iss.sa50.t8.service.AdminService;
import sg.edu.iss.sa50.t8.service.IEmployeeService;

@Configuration
@EnableScheduling
public class SchedulerController {
	
	@Autowired
	@Qualifier("adminService")
	private IEmployeeService aservice;
	
	@Autowired
	public void setILeaveService(AdminService aservice) {
		this.aservice = aservice;
	}
	
	/*@Scheduled(cron = "0 0 18 L * ?") //trigger at 6pm on the last day of every month
	public void scheduledLeavesIncrement() {
		List<Staff> list = ((AdminService) aservice).findAllNonAdminStaff();
		list.stream().forEach(e -> {
			e.setAnnualLeaveDays(e.getAnnualLeaveDays() + e.getTotalAnnualLeaves()/12);
			((AdminService) aservice).save(e);
		});
	}*/
	/*
	//Testing purposes only
	@Scheduled(fixedRate = 10000)
	public void scheduleIncrementLeaves() {
		List<Staff> list = ((AdminService) aservice).findAllNonAdminStaff();
		list.stream().forEach(e -> {
			System.out.print(e+ " ");
			System.out.println("AL: "+e.getAnnualLeaveDays());
		});
		
		list.stream().forEach(e -> {
			e.setAnnualLeaveDays(e.getAnnualLeaveDays() + e.getTotalAnnualLeaves()/12);
			((AdminService) aservice).save(e);
		});
		
		
		list.stream().forEach(e -> {
			System.out.print(e + " ");
			System.out.println("AL: "+e.getAnnualLeaveDays());
		});
	}*/
}
