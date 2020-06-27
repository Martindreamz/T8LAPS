package sg.edu.iss.sa50.t8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// a) Manage Leave Type (CRUD) - Joe 
// b) Manage Staff (CRUD)- Joe 
// c) Manage Leave Entitlement (CRUD) - Daryl 
// d) Manage Role and Approval Hierarchy (CRUD) - Manager, Staff and Admin - by Daryl 
// e) Enter / Update Employee annual leave entitlement for the year 
// f) Enter in calendar of public holidays (so that leave will not count in Public Holidays that happen on weekdays) 


@Controller
@RequestMapping("/employee")
public class AdminController {
	// admin
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/admin-manage")
	public String adminManage() {
		return "admin-manage";
	}
	
	@RequestMapping("/admin-blockleave")
	public String adminBlockLeave() {
		return "admin-blockleave";
	}
	
	@RequestMapping("/admin-setblockleave")
	public String adminSetBlockLeave() {
		return "admin-setblockleave";
	}

	
	
}
