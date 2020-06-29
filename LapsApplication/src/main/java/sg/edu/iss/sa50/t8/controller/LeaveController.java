package sg.edu.iss.sa50.t8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.model.MedicalLeave;
import sg.edu.iss.sa50.t8.repository.ALRepository;
import sg.edu.iss.sa50.t8.repository.CLRepository;
import sg.edu.iss.sa50.t8.repository.MLRepository;
import sg.edu.iss.sa50.t8.service.ALService;
import sg.edu.iss.sa50.t8.service.ILeaveService;
//split to architecture design controller
//need to discuss to shift methods to respective controllers
@Controller
@RequestMapping("/leaves")
public class LeaveController {

	@Autowired
	ALRepository alRepo;
	
	@Autowired
	MLRepository mlRepo;
	
	@Autowired
	CLRepository clRepo;
	
	@Autowired
	protected MLRepository mRepo;

	@Autowired
	protected ILeaveService leaveService;

	@Autowired
	public void setILeaveService(ALService alService) {
		this.leaveService = alService;
	}

	@RequestMapping("/apply")
	public String apply() {
		return "leaves-apply";
	}

	@RequestMapping("/annualAdd")
	public String annualaddForm(Model model) {
		model.addAttribute("annualLeave", new AnnualLeave());
		return "leaves-apply-annual";
	}

	@RequestMapping("/medicalAdd")
	public String medicaladdForm(Model model) {
		model.addAttribute("medicalLeave", new MedicalLeave());
		return "leaves-apply-medical";
	}

	@RequestMapping("/compensationAdd")
	public String compensationaddForm() {
		return "leaves-apply-compensation";
	}

	
	@RequestMapping("/annual/save")
	public String saveAnnualForm(@ModelAttribute("annualLeave") AnnualLeave annualLeave, Model model) {
		leaveService.saveAnnualLeave(annualLeave);
		model.addAttribute("alLeaves", alRepo.findAllAnnualLeaves());
		model.addAttribute("mlLeaves", mlRepo.findAllMedicalLeaves());
		model.addAttribute("clLeaves", clRepo.findAllCompensationLeaves());
		return "leaves-history";
	}
	
	@RequestMapping("/medical/save")
	public String saveMedicalForm(@ModelAttribute("medicalLeave") MedicalLeave medicalLeave, Model model) {
		mRepo.save(medicalLeave);
		return "leaves-applicationdetails";
	}
	
	@RequestMapping("/history")
	public String History(Model model) {
		model.addAttribute("alLeaves", alRepo.findAllAnnualLeaves());
		model.addAttribute("mlLeaves", mlRepo.findAllMedicalLeaves());
		model.addAttribute("clLeaves", clRepo.findAllCompensationLeaves());
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

	@RequestMapping("/movement-register")
	public String MovementRegister() {
		return "leaves-movement-register";
	}
	
	@RequestMapping("/generate-report")
	public String GenerateReport() {
		return "leaves-printpreview";
	}
	
	
}
