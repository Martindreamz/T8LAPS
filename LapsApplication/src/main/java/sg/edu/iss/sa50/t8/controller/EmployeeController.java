package sg.edu.iss.sa50.t8.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.repository.StaffRepository;
//split to architecture design controller
//need to discuss to shift methods to respective controllers
@Controller
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
	public String LoginSuccessful(@ModelAttribute("employee") Employee emp, Model model,HttpSession session) {

		for(Employee e: sRepo.findAllNonAdmin()){
			System.out.println(e);
			if(emp.getName().equals(e.getName())){
				System.out.println("staff exist");
				if (emp.getPassword().equals(e.getPassword())){
					System.out.println("staff password correct");
//					if (e.getDiscriminatorValue().equals("Admin")) {
//						System.out.println("too bad is admin");
//						model.addAttribute("errorMsg","You are admin. Pls go to admin login entrance");
//						return "error";
//					}
//					else {
					session.setAttribute("user",e);					
					return "leaves";
					}
//				}
//				else {
					model.addAttribute("errorMsg","Name or Password is not correct. Pls try again. OR U ARE ADMIN :)");
					return "error";
				}

			}
//		}
		return "employeelogin";
	}
}