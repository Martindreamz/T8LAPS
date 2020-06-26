package sg.edu.iss.sa50.t8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//split to architecture design controller
//need to discuss to shift methods to respective controllers
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	//move 2 login methods into LoginControllers
	// admin
	// rest of methods all moved into admin controller
	
	//employee
	@RequestMapping("/leaves")
	public String Leaves() {
		return "leaves";
	}
	
}
