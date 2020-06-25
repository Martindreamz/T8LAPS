package sg.edu.iss.sa50.t8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	//admin
	@RequestMapping("/adminlogin")
	public String adminLogin() {
		return "adminlogin";
	}
	
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
	//employee
	@RequestMapping("/employeelogin")
	public String employeeLogin() {
		return "employeelogin";
	}
	
	@RequestMapping("/leaves")
	public String Leaves() {
		return "leaves";
	}
	
}
