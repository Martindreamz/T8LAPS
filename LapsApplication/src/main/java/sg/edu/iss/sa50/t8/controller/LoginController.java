package sg.edu.iss.sa50.t8.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.sa50.t8.model.Admin;
import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.Staff;
import sg.edu.iss.sa50.t8.repository.AdminRepository;

@Controller
@RequestMapping("/employee")
public class LoginController {

	@Autowired
	AdminRepository aRepo;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	// admin-login
	@RequestMapping("/adminlogin")
	public String adminLogin(Model model) {
		model.addAttribute("admin",new Admin());
				
		return "adminlogin";
	}

	// employee-login 
	@RequestMapping("/login")
	public String employeeLogin(Model model) { 
		Employee emp = new Employee();
		model.addAttribute("employee", emp);

		/*
		 * model.addAttribute("Username", "test"); model.addAttributes("password",
		 * "password");
		 */        
		return "employeelogin";
	}
	
//	@RequestMapping("/home2")
//	public String testinghomepage(HttpSession session) {
//		return "home2";
//	}
//	
//	@RequestMapping("/general2")
//	public String testinghomepage2() {
//		return "fragments/general2";
//	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:/employee/home";
	}
}
