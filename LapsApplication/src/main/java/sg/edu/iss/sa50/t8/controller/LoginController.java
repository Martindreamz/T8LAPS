package sg.edu.iss.sa50.t8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.sa50.t8.model.Employee;

@Controller
@RequestMapping("/employee")
public class LoginController {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	// admin-login
	@RequestMapping("/adminlogin")
	public String adminLogin() {
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
}
