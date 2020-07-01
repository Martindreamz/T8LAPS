package sg.edu.iss.sa50.t8.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.repository.EmployeeRepository;

//split to architecture design controller
//need to discuss to shift methods to respective controllers
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	// move 2 login methods into LoginControllers
	// admin
	// rest of methods all moved into admin controller

	// employee
	@Autowired // change this to a employee service
	EmployeeRepository eRepo;

	// employee
	@RequestMapping("/leaves")
	public String Leaves() {
		return "leaves";
	}

	@RequestMapping("/employeelogin")
	public String LoginSuccessful(@ModelAttribute("employee") Employee emp, Model model,HttpSession session) {
		emp.getName();
		eRepo.findAll();
		for (Employee e : eRepo.findAll()) {
			if (emp.getName().equals(e.getName())) {
				if (emp.getPassword().equals(e.getPassword())) {
					
					  session.setAttribute("user", e);
					 
					return "leaves";
				}
			}
		}
		return "employeelogin";
	}
	
}
