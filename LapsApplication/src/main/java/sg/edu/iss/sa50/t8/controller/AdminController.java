package sg.edu.iss.sa50.t8.controller;

import javax.servlet.http.HttpSession;
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

import sg.edu.iss.sa50.t8.model.Admin;
import sg.edu.iss.sa50.t8.model.Employee;
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
	/*
	 * @RequestMapping("/admin-allEmp") public String createAllEmployee(Model model)
	 * { model.addAttribute("emp", new Employee());
	 * //model.addAttribute("managerList", ((AdminService)
	 * aservice).findAllManager()); //return "staff-edit";
	 * model.addAttribute("url","save-all"); return "BiancaJS-adminedit"; }
	 */

	/* Bianca Jul 3rd Bug fixing
	 * @RequestMapping("/save-staff") public String
	 * saveAllEmployee(@ModelAttribute("emp") Employee emp, Model model) {
	 * if(((AdminService) aservice).save(emp)) { return
	 * "forward:/employee/dashboard"; } return "error"; }
	 */


	//Admin create form
	@RequestMapping("/admin-create")

	public String createAdmin(Model model, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if(!emp.getDiscriminatorValue().equals("Admin") || emp == null) {
			model.addAttribute("errorMsg","Sorry you haven't log in."
					+ "Pls Log in as an admin.");
			return "error";
		}
		model.addAttribute("staff", new Staff());
		model.addAttribute("manlist",((AdminService) aservice).findAllManager());
		return "admin-create";
	}

	//	//Admin create form
	//	@RequestMapping("/admin-allEmp")
	//	public String createAllEmployee(Model model) {
	//		model.addAttribute("emp", new Employee());
	//		//model.addAttribute("managerList", ((AdminService) aservice).findAllManager());
	//		//return "staff-edit";
	//		model.addAttribute("url","save-all");
	//		return "BiancaJS-adminedit";
	//	}
	//	



	//	
	//	//Admin create form
	//	@RequestMapping("/admin-create")
	//	public String create(Model model) {
	//		model.addAttribute("admin", new Admin());
	//		return "admin-create";
	//	}


	//Staff create form
	@RequestMapping("/staff-create")
	public String staffCreate(Model model, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if(!emp.getDiscriminatorValue().equals("Admin") || emp == null) {
			model.addAttribute("errorMsg","Sorry you haven't log in."
					+ "Pls Log in as an admin.");
			return "error";
		}

		model.addAttribute("staff", new Staff());
		return "staff-create";
	}

	// Delete admin/staff Part
	@Transactional
	@RequestMapping("/admin-delete/{id}")
	public String deleteAdmin(@PathVariable("id") int id, Model model, HttpSession session) {
		((AdminService) aservice).deleteById(id);
		model.addAttribute("employeeList", ((AdminService) aservice).findAll());
		//need to set cascading delete to allow deletion of manager/staff
		return "dashboard";
	}


//	@RequestMapping("/admin-edit/{id}")
//	public String editAdmin(@PathVariable("id") int id, Model model, HttpSession session) {
//		Employee emp = (Employee) session.getAttribute("user");
//		if(!emp.getDiscriminatorValue().equals("Admin") || emp == null) {
//			model.addAttribute("errorMsg","Sorry you haven't log in."
//					+ "Pls Log in as an admin.");
//			return "error";
//
//		}
////		check the type
//		Employee currentemp = ((AdminService) aservice).findById(id);
//
//
//		if(currentemp.getDiscriminatorValue().equals("Staff")) {
//			currentemp.setType("Staff");
//			currentemp.setFromedit(true);
//			model.addAttribute("staff", currentemp);
//			return "admin-create";
//		}
//
//		if(currentemp.getDiscriminatorValue().equals("Admin")) {
//			currentemp.setType("Admin");
//			currentemp.setFromedit(true);
//			model.addAttribute("staff", currentemp);
//			return "admin-create";
//		}
//
//		if(currentemp.getDiscriminatorValue().equals("Manager")) {
//			currentemp.setType("Manager");
//			currentemp.setFromedit(true);
//			model.addAttribute("staff", currentemp);
//			return "admin-create";
//		}
//		return "admin-create";
//	}
//

	//	//Theingi old
	//	@RequestMapping("/staff-edit/{id}")
	//	public String editStaff(@PathVariable("id") int id, Model model, HttpSession session) {
	//		Employee emp = (Employee) session.getAttribute("user");
	//		if(!emp.getDiscriminatorValue().equals("Admin") || emp == null) {
	//			model.addAttribute("errorMsg","Sorry you haven't log in."
	//					+ "Pls Log in as an admin.");
	//			return "error";
	//		}
	//
	//		model.addAttribute("staff", ((AdminService) aservice).findStaffById(id));
	//		return "staff-edit";
	//	}

	/*@RequestMapping("/admin-edit/{id}")
>>>>>>> branch 'master' of https://github.com/Martindreamz/T8LAPS.git
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
	}*/

	@RequestMapping("/search-employee")
	public String searchEmployee(@RequestParam("searchTerm") String searchTerm, Model model, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if(emp.getDiscriminatorValue().equals("Staff") || emp == null) {
			model.addAttribute("errorMsg", "Sorry you should log in as a manager or admin.");
			return "error";
			}
		model.addAttribute("employeeList", ((AdminService) aservice).searchEmployee(searchTerm));
		return "dashboard";
	}
	
	@RequestMapping("/dashboard")
	//this page is visible for both manager and admin 
	public String dashboard(Model model, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if(emp.getDiscriminatorValue().equals("Staff") || emp == null) {
			model.addAttribute("errorMsg","Sorry you haven't log in."
					+ "Pls Log in as an admin.");
			return "error";
		}
		model.addAttribute("employeeList", ((AdminService) aservice).findAll());
		return "dashboard";
	}

	@RequestMapping("/save")
	public String saveAdmin(@ModelAttribute("staff") @Valid Staff staff, BindingResult result, Model model, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if(!emp.getDiscriminatorValue().equals("Admin") || emp == null) {
			model.addAttribute("errorMsg","Sorry Pls Log in as an admin.");
			return "error";}
		System.out.println("id"+staff.getId());
		System.out.println("Managerid" + staff.getManId());
		System.out.println("name"+staff.getName());
		System.out.println("pw"+staff.getPassword());
		System.out.println("email"+staff.getEmail());
		System.out.println("type"+staff.getType());
		System.out.println("annualleave"+staff.getAnnualLeaveDays());
		if(staff.getType().equals("Staff") && staff.getManId() == 0 && staff.getTotalAnnualLeaves()==0) {
			staff.setFromedit(false);
			model.addAttribute("staff",staff);		
			model.addAttribute("manlist",((AdminService) aservice).findAllManager());
			return "admin-create";
		}
		if(staff.getType().equals("Staff") && staff.getTotalAnnualLeaves()==0) {
			staff.setFromedit(false);
			model.addAttribute("staff",staff);		
			model.addAttribute("manlist",((AdminService) aservice).findAllManager());
			return "admin-create";
		}
		if(staff.getType().equals("Manager") && staff.getTotalAnnualLeaves()==0) {
			staff.setFromedit(false);
			model.addAttribute("staff",staff);		
			return "admin-create";
		}
		if(staff.getType().equals("Staff")) {
			if(((AdminService) aservice).findById(staff.getId())!=null) {
				((AdminService) aservice).deleteById(staff.getId());
			} //this are newly added
			((AdminService) aservice).SeedNewStaff(staff);;			
		}
		if(staff.getType().equals("Manager")) {
			if(((AdminService) aservice).findById(staff.getId())!=null) {
				((AdminService) aservice).deleteById(staff.getId());
			}//this are newly added	
			((AdminService) aservice).SeedNewManager(staff);;			
		}
		if(staff.getType().equals("Admin")) {
			if(((AdminService) aservice).findById(staff.getId())!=null) {
				((AdminService) aservice).deleteById(staff.getId());
			}//this are newly added
			((AdminService) aservice).SeedNewAdmin(staff);;			
		}
		return "forward:/employee/dashboard";
	}


	@RequestMapping("/save-staff")
	public String saveStaff(@ModelAttribute("staff") @Valid Staff staff, BindingResult result, Model model, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if(!emp.getDiscriminatorValue().equals("Admin") || emp == null) {
			model.addAttribute("errorMsg","Sorry Pls Log in as an admin.");
			return "error";}
		Staff toSave = ((AdminService) aservice).findStaffById(staff.getId());
		if(result.hasFieldErrors()) {
			model.addAttribute("staff", toSave);
			return "staff-edit";
		}
		else {
			toSave.setName(staff.getName());
			toSave.setPassword(staff.getPassword());
			toSave.setEmail(staff.getEmail());
			toSave.setAnnualLeaveDays(staff.getAnnualLeaveDays());
			toSave.setManager(((AdminService) aservice).findManagerById(staff.getManId()));
			if(((AdminService) aservice).save(toSave)) {
				return "forward:/employee/dashboard";
			}
			else {
				model.addAttribute("staff", toSave);
				return "staff-edit";
			}
		}
	}
	
	@RequestMapping("/save-admin")
	public String saveAdmin(@ModelAttribute("admin") @Valid Admin admin, BindingResult result, Model model, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if(!emp.getDiscriminatorValue().equals("Admin") || emp == null) {
			model.addAttribute("errorMsg","Sorry Pls Log in as an admin.");
			return "error";}
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

	@RequestMapping("/admin-edit/{id}")
	public String editAdmin(@PathVariable("id") int id, Model model, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if(!emp.getDiscriminatorValue().equals("Admin") || emp == null) {
			model.addAttribute("errorMsg","Sorry you haven't log in."
					+ "Pls Log in as an admin.");
			return "error";
		}
		
		model.addAttribute("admin", ((AdminService) aservice).findAdminById(id));
		return "admin-edit";
	}
	
	@RequestMapping("/staff-edit/{id}")
	public String editStaff(@PathVariable("id") int id, Model model, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if(!emp.getDiscriminatorValue().equals("Admin") || emp == null) {
			model.addAttribute("errorMsg","Sorry you haven't log in."
					+ "Pls Log in as an admin.");
			return "error";
		}
		
		model.addAttribute("staff", ((AdminService) aservice).findStaffById(id));
		model.addAttribute("manlist",((AdminService) aservice).findAllManager());

		return "staff-edit";
	}


}


