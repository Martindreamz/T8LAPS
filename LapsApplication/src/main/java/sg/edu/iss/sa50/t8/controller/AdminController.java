package sg.edu.iss.sa50.t8.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import sg.edu.iss.sa50.t8.model.Admin;
import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.Overtime;
import sg.edu.iss.sa50.t8.model.Staff;
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

	//After Login, show this method
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	

	//Admin create form
	@RequestMapping("/admin-allEmp")
	public String createAllEmployee(Model model) {
		model.addAttribute("emp", new Employee());
		//model.addAttribute("managerList", ((AdminService) aservice).findAllManager());
		//return "staff-edit";
		model.addAttribute("url","save-all");
		return "BiancaJS-adminedit";
	}
	
	/* Bianca Jul 3rd Bug fixing
	 * @RequestMapping("/save-staff") public String
	 * saveAllEmployee(@ModelAttribute("emp") Employee emp, Model model) {
	 * if(((AdminService) aservice).save(emp)) { return
	 * "forward:/employee/dashboard"; } return "error"; }
	 */

	
	//Admin create form
	@RequestMapping("/admin-create")
	public String createAdmin(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin-create";
	}
	//Admin create form
	@RequestMapping("/admin-allEmp")
	public String createAllEmployee(Model model) {
		model.addAttribute("emp", new Employee());
		//model.addAttribute("managerList", ((AdminService) aservice).findAllManager());
		//return "staff-edit";
		model.addAttribute("url","save-all");
		return "BiancaJS-adminedit";
	}
	

//	
//	//Admin create form
//	@RequestMapping("/admin-create")
//	public String create(Model model) {
//		model.addAttribute("admin", new Admin());
//		return "admin-create";
//	}
//	
	//Staff create form
	@RequestMapping("/staff-create")
	public String staffCreate(Model model) {
		model.addAttribute("staff", new Staff());
		return "staff-create";
	}
	
	// Delete admin/staff Part
	@Transactional
	@RequestMapping("/admin-delete/{id}")
	public String deleteAdmin(@PathVariable("id") int id, Model model) {
		((AdminService) aservice).deleteAdminById(id);
		model.addAttribute("employeeList", ((AdminService) aservice).findAll());
		return "dashboard";
	}
	
	@Transactional
	@RequestMapping("/staff-delete/{id}")
	public String deleteStaff(@PathVariable("id") int id, Model model) {
		((AdminService) aservice).deleteStaffById(id);
		model.addAttribute("employeeList", ((AdminService) aservice).findAll());
		return "dashboard";
	}

	//Save Part	
	@RequestMapping("/save-admin")
	public String saveAdmin(@ModelAttribute("admin") Admin admin, Model model) {
		if(((AdminService) aservice).save(admin)) {
			return "forward:/employee/dashboard";
		}
		else {
			model.addAttribute("admin", admin);
			return "admin-edit";
		}
	}
	
	@RequestMapping("/save-staff")
	public String saveStaff(@ModelAttribute("staff") Staff staff, Model model) {
		if(((AdminService) aservice).save(staff)) {
			return "forward:/employee/dashboard";
		}
		else {
			model.addAttribute("staff", staff);
			return "staff-edit";

		}
	}
	

	
	@RequestMapping("/admin-edit/{id}")
	public String editAdmin(@PathVariable("id") int id, Model model) {
		model.addAttribute("emp", ((AdminService) aservice).findAdminById(id));
		model.addAttribute("url","save-admin");
		return "BiancaJS-adminedit";
	}
	
	@RequestMapping("/staff-edit/{id}")
	public String editStaff(@PathVariable("id") int id, Model model) {
		model.addAttribute("emp", ((AdminService) aservice).findStaffById(id));
		model.addAttribute("managerList", ((AdminService) aservice).findAllManager());
		//return "staff-edit";
		model.addAttribute("url","save-staff");
		return "BiancaJS-adminedit";
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

//	@RequestMapping("/admin-create")
//	public String create(Model model) {
//		model.addAttribute("employee", new Staff());
//		model.addAttribute("employeeList", ((AdminService) aservice).findAll());
//		return "admin-create";
//	}

	@RequestMapping("/save-admin")
	public String saveAdmin(@ModelAttribute("admin") @Valid Admin admin, BindingResult result, Model model) {
		if(result.hasFieldErrors()) {
			model.addAttribute("admin", admin);
			return "admin-edit";
		}
		else {
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
	}
	
	@RequestMapping("/save-staff")
	public String saveStaff(@ModelAttribute("staff") @Valid Staff staff, BindingResult result, Model model) {
		if(result.hasFieldErrors()) {
			model.addAttribute("staff", staff);
			return "staff-edit";
		}
		else {
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
}


