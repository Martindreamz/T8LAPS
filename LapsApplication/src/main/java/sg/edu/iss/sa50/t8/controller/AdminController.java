package sg.edu.iss.sa50.t8.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.sa50.t8.model.*;
import sg.edu.iss.sa50.t8.repository.EmployeeRepository;
import sg.edu.iss.sa50.t8.service.AdminService;
import sg.edu.iss.sa50.t8.service.IEmployeeService;

// a) Manage Leave Type (CRUD) - Joe 
// b) Manage Staff (CRUD)- Joe 
// c) Manage Leave Entitlement (CRUD) - Daryl 
// d) Manage Role and Approval Hierarchy (CRUD) - Manager, Staff and Admin - by Daryl 
// e) Enter / Update Employee annual leave entitlement for the year 
// f) Enter in calendar of public holidays (so that leave will not count in Public Holidays that happen on weekdays) 


@Controller
@RequestMapping("/employee")
public class AdminController {

	@Autowired
	@Qualifier("adminService")
	protected IEmployeeService aservice;

	@Autowired
	public void setILeaveService(AdminService aservice) {
		this.aservice = aservice;
	}

	//admin
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}




	@RequestMapping("/admin-delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", ((AdminService) aservice).findById(id));
		return "admin-delete";
	}

	@RequestMapping("/admin-edit/{id}")
	public String editAdmin(@PathVariable("id") int id, Model model) {
		model.addAttribute("admin", ((AdminService) aservice).findAdminById(id));
		return "admin-edit";
	}
	
	@RequestMapping("/staff-edit/{id}")
	public String editStaff(@PathVariable("id") int id, Model model) {
		model.addAttribute("staff", ((AdminService) aservice).findStaffById(id));
		return "staff-edit";
	}


	@RequestMapping("/search-employee")
	public String searchEmployee(@RequestParam("searchTerm") String searchTerm, Model model) {
		model.addAttribute("employeeList", ((AdminService) aservice).searchEmployee(searchTerm));
		return "dashboard";
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("employeeList", ((AdminService) aservice).findAll());
		return "dashboard";
	}


	@RequestMapping("/admin-create")
	public String create(Model model) {
		model.addAttribute("employee", new Staff());
		model.addAttribute("employeeList", ((AdminService) aservice).findAll());
		return "admin-create";
	}







	@RequestMapping("/save-admin")
	public String saveAdmin(@ModelAttribute("admin") Admin admin, Model model) {
		Admin toSave = ((AdminService) aservice).findAdminById(admin.getId());
		toSave.setName(admin.getName());
		toSave.setPassword(admin.getPassword());
		toSave.setEmail(admin.getEmail());
		if(((AdminService) aservice).save(toSave)) {
			return "forward:/employee/dashboard";
		}
		else {
			model.addAttribute("admin", toSave);
			return "admin-edit";
		}
		
	}
	
	@RequestMapping("/save-staff")
	public String saveStaff(@ModelAttribute("staff") Staff staff, Model model) {
		Staff toSave = ((AdminService) aservice).findStaffById(staff.getId());
		toSave.setName(staff.getName());
		toSave.setPassword(staff.getPassword());
		toSave.setEmail(staff.getEmail());
		toSave.setAnnualLeaveDays(staff.getAnnualLeaveDays());
		if(((AdminService) aservice).save(toSave)) {
			return "forward:/employee/dashboard";
		}
		else {
			model.addAttribute("staff", toSave);
			return "staff-edit";
		}
	}


}


