package sg.edu.iss.sa50.t8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leaves")
public class LeaveController {

	@RequestMapping("/pending")
	public String Pending() {
		return "leaves-applications";
	}
	
	@RequestMapping("/applicationdetail")
	public String Details() {
		return "leaves-aplicationdetails";
	}
	
	@RequestMapping("/history")
	public String History() {
		return "leaves-history";
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
