package sg.edu.iss.sa50.t8.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.sa50.t8.model.Overtime;
import sg.edu.iss.sa50.t8.model.Staff;
import sg.edu.iss.sa50.t8.service.IOvertimeService;
import sg.edu.iss.sa50.t8.service.OvertimeserviceImpl;
import sg.edu.iss.sa50.t8.service.StaffService;

@Controller
@RequestMapping("/overtime")
public class OvertimeController {
	@Autowired
	protected IOvertimeService overtimeService;
	
	@Autowired
	public void setIOvertimeService(OvertimeserviceImpl overtimeSerImpl) {
		this.overtimeService = overtimeSerImpl;
	}
	
	@RequestMapping("/claim")
	public String claim(Model model,HttpSession session) {
		model.addAttribute("overtime", new Overtime());
		Staff s = new Staff("staff1","staff1@gmail.com");
		model.addAttribute("staff", s);
		return "overtime-claim";
	}

	/*
	 * @RequestMapping("/save") public String
	 * save(@ModelAttribute("overtime") @Valid Overtime overtime, BindingResult
	 * bindingResult,Model model) { if (bindingResult.hasErrors()) { return
	 * "overtime-claim"; } overtimeService.saveOvertime(overtime);
	 * model.addAttribute("overtime", overtimeService.findAllOvertimeByStaffId(6));
	 * return "overtime-history"; }
	 */
	
	@RequestMapping("/save")
	public String save(@ModelAttribute("overtime") Overtime overtime,
			Model model) {
		overtimeService.saveOvertime(overtime);
		model.addAttribute("overtime", overtimeService.findAllOvertimeByStaffId(6));
		return "overtime-history";
	}
}
