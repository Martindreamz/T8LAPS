package sg.edu.iss.sa50.t8.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.Staff;
import sg.edu.iss.sa50.t8.repository.StaffRepository;
//split to architecture design controller
//need to discuss to shift methods to respective controllers
@Controller
@SessionAttributes("user")
@RequestMapping("/employee")
public class EmployeeController {
	//move 2 login methods into LoginControllers
	// admin
	// rest of methods all moved into admin controller

	//employee
	@Autowired
	StaffRepository sRepo;

	//employee
	@RequestMapping("/leaves")
	public String Leaves() {
		return "leaves";
	}

	@RequestMapping("/employeelogin")
	public String LoginSuccessful(@ModelAttribute("employee") Staff emp,  Employee user,HttpSession session) {
		
		for(Employee e: sRepo.findAll()){
			if(emp.getName().equals(e.getName())){
				if (emp.getPassword().equals(e.getPassword())){
					session.setAttribute("user",e);					
					return "leaves";
				}
			}
		}

		return "employeelogin";
	}
	
}
