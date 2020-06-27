package sg.edu.iss.sa50.t8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.LeaveType;
import sg.edu.iss.sa50.t8.model.Leaves;

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
	
	// JOE SECTION A 
	
	@RequestMapping("/admin-createleavetype")
    public String createleavetype(LeaveType leavetype) {
		return "createleavetype";
    }
	
	@RequestMapping("/admin-updateleavetype")
    public String updateleavetype(LeaveType leavetype) {
		return "updateleavetype";
    }
	
	@RequestMapping("/admin-deleteleavetype")
    public String deleteleavetype(LeaveType leavetype) {
		return "deleteleavetype";
    }
	
	@RequestMapping("/admin-viewleavetype")
    public String viewleavetype(LeaveType leavetype) {
		return "viewleavetype"; 
    }
	
	// JOE SECTION B

	
	@RequestMapping("/admin-manageemployee")
	public String ManageEmployee() {
		return "manageemployee";
	}
	
	@RequestMapping("/admin-listEmployee")
    public String listEmployee(Employee employee) {
		return "listEmployee";
    }
	
	@RequestMapping("/admin-createEmployee")
    public String createEmployee(Employee employee) {
		return "createEmployee";
    }
	
	@RequestMapping("/admin-updateEmployee")
    public String updateEmployee(Employee employee) {
		return "updateEmployee";
    }
	
	@RequestMapping("/admin-deleteEmployee")
    public String deleteEmployee(Employee employee) {
		return "deleteEmployee";
    }
	
	// END OF JOE SECTION 
	
	
	
	/*
	@RequestMapping("/admin-blockleave")
	public String adminBlockLeave() {
		return "admin-blockleave";
	}
	
	@RequestMapping("/admin-setblockleave")
	public String adminSetBlockLeave() {
		return "admin-setblockleave";
	}
	*/

	
	
}
