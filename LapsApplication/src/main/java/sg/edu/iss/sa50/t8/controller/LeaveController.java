package sg.edu.iss.sa50.t8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.sa50.t8.repository.ALRepository;
//split to architecture design controller
//need to discuss to shift methods to respective controllers
@Controller
@RequestMapping("/leaves")
public class LeaveController {
	
	@Autowired
	ALRepository alRepo;

	@RequestMapping("/history")
	public String History(Model model) {
		model.addAttribute("alLeaves", alRepo.findAll());
		return "leaves-history";
	}
	
	@RequestMapping("/pending")
	public String Pending() {
		return "leaves-applications";
	}
	
	@RequestMapping("/applicationdetail")
	public String Details() {
		return "leaves-aplicationdetails";
	}
	
	@RequestMapping("/cancel")
	public String Cancel() {
		return "leaves-cancel";
	}
	
	@RequestMapping("/manage")
	public String Manage() {
		return "leaves-manage";
	}
	
	@RequestMapping("/apply")
	public String Apply() {
		return "leaves-apply";
	}
	
	@RequestMapping("/movement-register")
	public String MovementRegister() {
		return "leaves-movement-register";
	}
	
	@RequestMapping("/generate-report")
	public String GenerateReport() {
		return "leaves-printpreview";
	}
	
	
}
