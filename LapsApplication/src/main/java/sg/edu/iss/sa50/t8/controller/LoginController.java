package sg.edu.iss.sa50.t8.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.sa50.t8.model.Admin;
import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.repository.AdminRepository;
import sg.edu.iss.sa50.t8.service.AdminService;
import sg.edu.iss.sa50.t8.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class LoginController {

	@Autowired
	@Qualifier("adminService")
	protected IEmployeeService aservice;

	@Autowired
	public void setILeaveService(AdminService aservice) {
		this.aservice = aservice;}


	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	// admin-login

		@RequestMapping("/login2")
		public String adminLogin(Model model) { 
			Employee emp = new Employee();
			model.addAttribute("admin", emp);

			return "adminlogin";
		}
	
	
	@RequestMapping("/adminlogin")
	public String adminlogin(@ModelAttribute("employee") Employee emp,HttpSession session,Model model) {
		for(Admin a :((AdminService) aservice).findallAdmin()){
			System.out.println(a);
			if(emp.getName().equals(a.getName())){
				System.out.println("admin name exist");
				if (emp.getPassword().equals(a.getPassword())){
					System.out.println("admin password correct");

					session.setAttribute("user",a);					
					return "admin";
				}
			}
		}
		model.addAttribute("errorMsg","Password is not correct. Pls try again.");
		return "error";
	}

	// employee-login 
	@RequestMapping("/login")
	public String employeeLogin(Model model) { 
		Employee emp = new Employee();
		model.addAttribute("employee", emp);

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
