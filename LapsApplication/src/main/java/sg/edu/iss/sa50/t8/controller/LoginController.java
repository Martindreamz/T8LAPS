package sg.edu.iss.sa50.t8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("/employeelogin")
	public String employeeLogin() {
		return "employeelogin";
	}

}
