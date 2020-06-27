package sg.edu.iss.sa50.t8.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.LeaveType;
import sg.edu.iss.sa50.t8.model.Leaves;
import sg.edu.iss.sa50.t8.repository.EmployeeRepository;

// a) Manage Leave Type (CRUD) - Joe 
// b) Manage Staff (CRUD)- Joe 
// c) Manage Leave Entitlement (CRUD) - Daryl 
// d) Manage Role and Approval Hierarchy (CRUD) - Manager, Staff and Admin - by Daryl 
// e) Enter / Update Employee annual leave entitlement for the year 
// f) Enter in calendar of public holidays (so that leave will not count in Public Holidays that happen on weekdays) 


@Controller
@RequestMapping("/employee")
public class AdminController {
	
	//admin
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	// JOE SECTION A ***
	
	
	@GetMapping("/admin-createleavetype")
	public String createleavetype(@RequestParam(name="leavetype", required=true, defaultValue="") String leavetype) {
		LeaveType.addAttribute("leavetype", leavetype);
		return "admin-manageleavetype.html";}
	
	@GetMapping("/admin-updateleavetype")
	public String updateleavetype(@RequestParam(name="leavetype", required=true, defaultValue="") String leavetype, LeaveType newleavetype) {
			LeaveType.updateAttribute("leavetype", leavetype);
			return "admin-manageleavetype.html";}
	
	@GetMapping("/admin-deleteleavetype")
	public String deleteleavetype(@RequestParam(name="leavetype", required=true, defaultValue="") LeaveType leavetype) {
			LeaveType.deleteAttribute("leavetype");
			return "admin-manageleavetype.html";}
					
	@GetMapping("/admin-viewleavelist")
	public String viewleavelist() {
			LeaveType.view();
			return "admin-manageleavetype.html";}
			
	
	
	// JOE SECTION B *** 
	
	// TESTING VERSION 1 

	@GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }
     
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
         
        EmployeeRepository.save(user);
        model.addAttribute("users", EmployeeRepository.findAll());
        return "redirect:/index";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
         
        model.addAttribute("user", user);
        return "update-user";
    }
    
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, 
      BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }
             
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/index";
    }
         
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
    
    
   //TESTING VERSION 2 
	
	@RequestMapping("/admin-manageemployee")
	public String ManageEmployee() {
		return "manageemployee";
	}
	
	@RequestMapping("/admin-listEmployee")
    public String listEmployee(Employee employee) {
		return "listEmployee";
    }
	
	@RequestMapping("/admin-createEmployee")
    public String createEmployee(Employee employee) {
		return "createEmployee";
    }
	
	@RequestMapping("/admin-updateEmployee")
    public String updateEmployee(Employee employee) {
		return "updateEmployee";
    }
	
	@RequestMapping("/admin-deleteEmployee")
    public String deleteEmployee(Employee employee) {
		return "deleteEmployee";
    }
	
	// END OF JOE SECTION 
	
	
	
	/*
	@RequestMapping("/admin-blockleave")
	public String adminBlockLeave() {
		return "admin-blockleave";
	}
	
	@RequestMapping("/admin-setblockleave")
	public String adminSetBlockLeave() {
		return "admin-setblockleave";
	}
	*/

	
	
}
