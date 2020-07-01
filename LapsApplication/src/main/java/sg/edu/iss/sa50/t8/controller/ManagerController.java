package sg.edu.iss.sa50.t8.controller;

import org.springframework.web.bind.annotation.*;

import sg.edu.iss.sa50.t8.model.*;
import sg.edu.iss.sa50.t8.service.*;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

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
		return "home";
	}

	@GetMapping("/leavesAppDetails/{id}")
	public String showLeaveAppDetail(Model model, @PathVariable("id") Integer id, HttpSession session) {
		model.addAttribute("leaves", ((ManagerService) manService).findById(id).get());
		session.setAttribute("leavesId", id);
		return "manager-leaveAppDetails";
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

}
