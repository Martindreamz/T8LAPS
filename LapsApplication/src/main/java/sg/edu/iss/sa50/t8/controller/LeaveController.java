package sg.edu.iss.sa50.t8.controller;

import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sun.el.parser.ParseException;

import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.model.CompensationLeave;
import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.LeaveStatus;
import sg.edu.iss.sa50.t8.model.Leaves;
import sg.edu.iss.sa50.t8.model.MedicalLeave;
import sg.edu.iss.sa50.t8.model.Staff;
import sg.edu.iss.sa50.t8.repository.StaffRepository;
import sg.edu.iss.sa50.t8.service.AdminService;
import sg.edu.iss.sa50.t8.service.EmailService;
import sg.edu.iss.sa50.t8.service.IEmployeeService;
import sg.edu.iss.sa50.t8.service.ILeaveService;
import sg.edu.iss.sa50.t8.service.LeaveServiceImpl;

//split to architecture design controller
//need to discuss to shift methods to respective controllers
@Controller
@RequestMapping("/leaves")
public class LeaveController {

	private static final LeaveStatus Applied = null;
//	@Autowired
//	@Qualifier("StaffService")
//	protected IEmployeeService stService;
//	
//	@Autowired
//	public void setIEmployeeService(StaffService stService) {
//		this.stService = stService;
//	}
	
	@Autowired
	@Qualifier("adminService")
	protected IEmployeeService aservice;
	
	@Autowired
	public void setIEeaveService(AdminService aservice) {
		this.aservice = aservice;
	}

	@Autowired
	EmailService ems;

	@Autowired
	StaffRepository srepo;
	
	@Autowired
	protected ILeaveService leaveService;
	
	@Autowired
	public void setILeaveService(LeaveServiceImpl leaveSerImpl) {
		this.leaveService = leaveSerImpl;
	}

	@RequestMapping("/apply")
	public String apply() {
		return "leaves-apply";
	}
	
	@RequestMapping("/detail/{id}")
	public String detail(@RequestParam("formId") String formId,@PathVariable("id") Integer id
		,Model model) {
		String lType = leaveService.findLeaveTypeById(id);
		if(lType.equalsIgnoreCase("Annual Leave")) {
			model.addAttribute("formId", formId);
			model.addAttribute("annualLeave",leaveService.findLeaveById(id));
			return "leaves-apply-annual";
		}
		else if(lType.equalsIgnoreCase("Medical Leave")){
			model.addAttribute("formId", formId);
			model.addAttribute("medicalLeave",leaveService.findLeaveById(id));
			return "leaves-apply-medical";
		}
		else{
			model.addAttribute("formId", formId);
			model.addAttribute("compensationLeave",leaveService.findLeaveById(id));
			return "leaves-apply-compensation";
		}
	}

	@RequestMapping("/annualAdd")
	public String annualaddForm(@SessionAttribute("user") Employee emp, 
			Model model) {
		model.addAttribute("annualLeave", new AnnualLeave());
		int curAnn=leaveService.findCurAnnLeave(emp.getId());
		model.addAttribute("eCurAnnLeave", curAnn);
		return "leaves-apply-annual";
	}

	@RequestMapping("/medicalAdd")
	public String medicaladdForm(@SessionAttribute("user") Employee emp, Model model) {
		model.addAttribute("medicalLeave", new MedicalLeave());
		int medAnn=leaveService.findMedAnnLeave(emp.getId());
		model.addAttribute("eMedAnnLeave", medAnn);
		return "leaves-apply-medical";
	}

	@RequestMapping("/compensationAdd")
	public String compensationaddForm(Model model) {
		model.addAttribute("compensationLeave", new CompensationLeave());
		return "leaves-apply-compensation";
	}

	
	@RequestMapping("/annual/save")
	public String saveAnnualForm(@ModelAttribute("annualLeave") @Valid AnnualLeave annualLeave, 
			BindingResult bindingResult, Model model,@SessionAttribute("user") Employee emp) throws ParseException {
		int curAnn=leaveService.findCurAnnLeave(emp.getId());
		model.addAttribute("eCurAnnLeave", curAnn);
		if (bindingResult.hasErrors()) {
			annualLeave.setStaff((Staff) srepo.findById(emp.getId()).get());
			return "leaves-apply-annual";
		}
		int count = 0;
        long duration;
        Date d1 = annualLeave.getStartDate();
		Date d2 = annualLeave.getEndDate();
		count = saturdaysundaycount(d1,d2);
		duration = duration(d1, d2); 
		System.out.println("duration" + duration);

		if(count > 0 &&  duration <= 14 ) {
        	long minus = duration - count;
        	System.out.println("less than 14 = " + minus);
        	annualLeave.setStaff((Staff) srepo.findById(emp.getId()).get()); //use session later
        	annualLeave.setStatus(LeaveStatus.Applied);
//        	ems.notifyManager(annualLeave);
        	leaveService.saveAnnualLeave(annualLeave);
   		    model.addAttribute("Leaves",leaveService.findAllLeaves(emp.getId())); 
   		    return "leaves-history";
        }
        else {
        	System.out.println("greater than 14 = " + duration);
        	annualLeave.setStaff((Staff) srepo.findById(emp.getId()).get()); //use session later
        	annualLeave.setStatus(LeaveStatus.Applied);
//        	ems.notifyManager(annualLeave);
        	leaveService.saveAnnualLeave(annualLeave);
   		    model.addAttribute("Leaves",leaveService.findAllLeaves(emp.getId())); 
   		    return "leaves-history";
        }
	}
	
	@RequestMapping("/medical/save")
	public String saveMedicalForm(@ModelAttribute("medicalLeave") @Valid MedicalLeave medicalLeave, 
			BindingResult bindingResult, Model model,@SessionAttribute("user") Employee emp) {
		int medAnn=leaveService.findMedAnnLeave(emp.getId());
		model.addAttribute("eMedAnnLeave", medAnn);
		if (bindingResult.hasErrors()) {
			return "leaves-apply-medical";
		}
		Date d1 = medicalLeave.getStartDate();
		Date d2 = medicalLeave.getEndDate();
		long duration = duration(d1, d2);
		if(duration <= 60) {
			medicalLeave.setStaff((Staff) srepo.findById(emp.getId()).get()); //use session later
			medicalLeave.setStatus(LeaveStatus.Applied);
//	    	ems.notifyManager(medicalLeave);
			leaveService.saveMedicalLeave(medicalLeave);
			model.addAttribute("Leaves", leaveService.findAllLeaves(emp.getId()));
			return "leaves-history";
			
		}
		else {
			return "leaves-applicationdetails";
		}
		
	}
	
	@RequestMapping("/compensation/save")
	public String saveCompensationForm(@ModelAttribute("compLeave") CompensationLeave compLeave, 
			Model model,@SessionAttribute("user") Employee emp) {
		compLeave.setStaff((Staff) srepo.findById(emp.getId()).get()); //use session later
		compLeave.setStatus(LeaveStatus.Applied);
		//int totalOtHr =((StaffService) stService).findTotalOTHoursByEmpId(6);
		int totalOtHr =((AdminService) aservice).findTotalOTHoursByEmpId(emp.getId());
		
		if(totalOtHr < 4) {
			model.addAttribute("error","Sorry!You don't have eligilibility to apply this compensation leave.");
			model.addAttribute("compensationLeave",compLeave);
			return "leaves-apply-compensation";
		}
		leaveService.saveCompensationLeave(compLeave);
		model.addAttribute("Leaves", leaveService.findAllLeaves(emp.getId()));
		return "leaves-history";
	}
	
	@RequestMapping("/history")
	public String History(Model model,@SessionAttribute("user") Employee emp) {
		model.addAttribute("Leaves", leaveService.findAllLeaves(emp.getId()));
		return "leaves-history";
	}
	
	@RequestMapping(value="/cancel/{id}")
	public String cancel(@PathVariable("id") Integer id,Model model) {
		Leaves l = leaveService.findLeaveById(id);
		String lType = l.getDiscriminatorValue();
		if(lType.equalsIgnoreCase("Annual Leave")) {
			
		}
		else if(lType.equalsIgnoreCase("Medical Leave")) {
			
		}
		else {
			if(l.getStatus().equals(LeaveStatus.Approved)) {
				int updateHr = ((AdminService) aservice).findTotalOTHoursByEmpId(l.getStaff().getId());
				updateHr += 4;
				((AdminService) aservice).updateTotalOTHoursByEmpId(l.getStaff().getId(), updateHr);
			}
		}
		leaveService.updateLeaveStatus(id,LeaveStatus.Cancelled);
		return "forward:/leaves/history";
	}
	
	@RequestMapping(value="/update/{id}")
	public String update(@PathVariable("id") Integer id,Model model) {
		String lType = leaveService.findLeaveTypeById(id);
		if(lType.equalsIgnoreCase("Annual Leave")) {
			model.addAttribute("annualLeave",leaveService.findLeaveById(id));
			return "leaves-apply-annual";
		}
		else if(lType.equalsIgnoreCase("Medical Leave")){
			model.addAttribute("medicalLeave",leaveService.findLeaveById(id));
			return "leaves-apply-medical";
		}
		else{
			model.addAttribute("compensationLeave",leaveService.findLeaveById(id));
			return "leaves-apply-compensation";
		}
	}
	
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") Integer id,Model model) {
		Leaves l = leaveService.findLeaveById(id);
		String lType = l.getDiscriminatorValue();
		if(lType.equalsIgnoreCase("Annual Leave")) {
			
		}
		else if(lType.equalsIgnoreCase("Medical Leave")) {
			
		}
		else {
			if(l.getStatus().equals(LeaveStatus.Approved)) {
				int updateHr = ((AdminService) aservice).findTotalOTHoursByEmpId(l.getStaff().getId());
				updateHr += 4;
				((AdminService) aservice).updateTotalOTHoursByEmpId(l.getStaff().getId(), updateHr);
			}
		}
		leaveService.updateLeaveStatus(id,LeaveStatus.Deleted);
		return "forward:/leaves/history";
	}
	
	public static int saturdaysundaycount(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        int sundays = 0;
        int saturday = 0;

        while (! c1.after(c2)) {
            if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ){
                saturday++; 
            }
            if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                sundays++;
            }

            c1.add(Calendar.DATE, 1);
        }

        System.out.println("Saturday Count = "+saturday);
        System.out.println("Sunday Count = "+sundays);
        return saturday + sundays;
    }
	
	//check duration of date
		public static long duration(Date time1, Date time2) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(time1);
			cal.setTime(time2);
			long diff = (time2.getDate()- time1.getDate())+1;
			return diff;
		}

}