package sg.edu.iss.sa50.t8.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.Leaves;
import sg.edu.iss.sa50.t8.model.Manager;
import sg.edu.iss.sa50.t8.model.OvertimeStatus;
import sg.edu.iss.sa50.t8.model.Staff;
import sg.edu.iss.sa50.t8.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	@Qualifier("managerService")
	protected ManagerService manService;

	@Autowired
	public void setILeaveService(ManagerService manService) {
		this.manService = manService;
	}

	@RequestMapping("/list")
	public String home() {
		return "home";
	}

	@RequestMapping("/staffList")
	public String stafflist(Model model, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if (emp.getDiscriminatorValue().equals("Manager")) {
			Manager man = (Manager) emp;
			model.addAttribute("suboridateList", ((ManagerService) manService).findSub(man));
			return "manager-dashboard";
		}else {
			model.addAttribute("errorMsg","You are not a manger, pls login as a manager first.");
			return "error";}
	}
	
	@RequestMapping("/staffLeaveHistoryList/{id}")
	public String staffLeaveHistory(Model model,
			HttpSession session,@PathVariable("id") Integer id) {
		Employee emp = (Employee) session.getAttribute("user");
		if (emp.getDiscriminatorValue().equals("Manager")) {
			Manager man = (Manager) emp;
			Staff sub = ((ManagerService) manService).findStaffById(id);
			if (sub.getManager().getId()==man.getId()) {
				model.addAttribute("Leaves",
						((ManagerService) manService).findAllLeaveByStaff(sub));
				return "manager-LeavesHistoryList";
			}else {
				model.addAttribute("errorMsg","Sorry you don't have authority. "
						+ "This staff is not your subordinate.");
				return "error";
			}
			}
		model.addAttribute("errorMsg","Sorry you don't have authority. Pls Login as a manager.");
		return "error";
		
	}

	
	@RequestMapping("/leavesAppForApprovalList")
	public String listforApproval(Model model, HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if (emp.getDiscriminatorValue().equals("Manager")) {
			Manager man = (Manager) emp;
			model.addAttribute("Leaves", ((ManagerService) manService).findAllPendingLeaves(man));
			return "manager-leavesApprovalList";
		}
		model.addAttribute("errorMsg","Sorry you don't have authority. Pls Login as a manager.");
		return "error";
	}

	@RequestMapping("/leavesAppDetails/{id}")
	public String showLeaveAppDetail(Model model, @PathVariable("id") Integer id, 
			HttpSession session) {
		Employee emp = (Employee) session.getAttribute("user");
		if (emp == null) {
			model.addAttribute("errorMsg","Sorry you haven't log in."
					+ "Pls Log in as a manager.");
			return "error";}
		if (emp.getDiscriminatorValue().equals("Manager")) {
			Manager man = (Manager) emp;
			/*ArrayList<Staff> stfL = ((ManagerService) manService).findSub(man);*/
			Leaves l = ((ManagerService) manService).findById(id).get();
			if (l.getStaff().getManager().getId()== man.getId()) {
					session.setAttribute("leavesId", id);
					model.addAttribute("leaves", l);
					return "manager-leaveAppDetails";
				}
			else {
				model.addAttribute("errorMsg","Sorry you don't have authority. "
						+ "This staff is not your subordinate.");
				return "error";
			}
		} else {
			model.addAttribute("errorMsg","Sorry you don't have authority. "
					+ "Pls Log in as a manager.");
			return "error";
		}
	}

	@RequestMapping(value = "leavesAppDetails/respond")
	public String responseTrySessionID(@RequestParam(value = "managerComment") String manCom,
			@RequestParam(value = "action", required = true) String action, HttpSession session) {
		Integer id = (Integer) session.getAttribute("leavesId");
		Leaves leaves = manService.findById(id).get();
		if (action.equals("approve")) {
			// change status into approved
			manService.approveLeave(leaves);
			manService.setComment(leaves, manCom);
			session.removeAttribute("leavesId");
			return "forward:/manager/list";
		}
		if (action.equals("reject")) {
			// validate first: check if comment is not empty
			// if (bindingResult.hasErrors()) {return "manager-leaveAppDetails";}else {
			// change status into approved
			manService.rejectLeave(leaves);
			manService.setComment(leaves, manCom);
			session.removeAttribute("leavesId");
			return "forward:/manager/list";
		}
		return "forward:/manager/list";
	}

	//Overtime
	@RequestMapping("/overtimelist")
	public String approveovertime(@SessionAttribute("user") Employee emp, Model model) {
		if(emp.getDiscriminatorValue().equals("Manager")) {
			model.addAttribute("overtimelist",manService.findStaffOvertime((Manager) emp).stream().filter(x -> x.getOverTimeStatus() == OvertimeStatus.Applied).toArray());
//			manService.findStaffOvertime((Manager) emp).forEach(System.out::println);
			
			System.out.println("printing the applied below");
			manService.findStaffOvertime((Manager) emp).stream().filter(x -> x.getOverTimeStatus() == OvertimeStatus.Applied).forEach(System.out::print);
//			.stream().filter(x -> x.getOverTimeStatus().equals(OvertimeStatus.Applied))
			System.out.println("end of above");
//			System.out.println(manService.findStaffOvertime((Manager) emp).get(1).getOverTimeStatus());
			return "manager-OTApprovalList";
		}
		model.addAttribute("errorMsg","Sorry you don't have authority. Pls Login as a manager.");
		return "error";
	}
	
}
