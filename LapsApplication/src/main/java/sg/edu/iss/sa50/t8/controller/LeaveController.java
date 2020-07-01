package sg.edu.iss.sa50.t8.controller;

<<<<<<< Upstream, based on origin/master
import javax.validation.Valid;
=======
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
>>>>>>> 637e9ba updates of form apply and leave controller

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.model.CompensationLeave;
import sg.edu.iss.sa50.t8.model.MedicalLeave;
<<<<<<< Upstream, based on origin/master
import sg.edu.iss.sa50.t8.model.OvertimeStatus;
import sg.edu.iss.sa50.t8.service.ILeaveService;
import sg.edu.iss.sa50.t8.service.IOvertimeService;
import sg.edu.iss.sa50.t8.service.LeaveServiceImpl;
import sg.edu.iss.sa50.t8.service.OvertimeserviceImpl;
=======
import sg.edu.iss.sa50.t8.service.ILeaveService;
import sg.edu.iss.sa50.t8.service.LeaveServiceImpl;
>>>>>>> 637e9ba updates of form apply and leave controller

//split to architecture design controller
//need to discuss to shift methods to respective controllers
@Controller
@RequestMapping("/leaves")
public class LeaveController {

	@Autowired
	protected ILeaveService leaveService;
	
	@Autowired
	public void setILeaveService(LeaveServiceImpl leaveSerImpl) {
		this.leaveService = leaveSerImpl;
	}
<<<<<<< Upstream, based on origin/master
	
	@Autowired
	protected IOvertimeService overtimeService;
	
	@Autowired
	public void setIOvertimeService(OvertimeserviceImpl overtimeSerImpl) {
		this.overtimeService = overtimeSerImpl;
	}
	
	/*
	 * @InitBinder protected void initBinder(WebDataBinder binder) {
	 * binder.addValidators(new OvertimeValidator()); }
	 */
	
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
	public String compensationaddForm(Model model) {
		model.addAttribute("compensationLeave", new CompensationLeave());
		return "leaves-apply-compensation";
	}

	
	@RequestMapping("/annual/save")
	public String saveAnnualForm(@ModelAttribute("annualLeave") AnnualLeave annualLeave, 
			Model model) {
		leaveService.saveAnnualLeave(annualLeave);
		model.addAttribute("Leaves", leaveService.findAllLeaves());
		return "leaves-history";
	}
	
	@RequestMapping("/medical/save")
	public String saveMedicalForm(@ModelAttribute("medicalLeave") MedicalLeave medicalLeave, 
			Model model) {
		leaveService.saveMedicalLeave(medicalLeave);
		model.addAttribute("Leaves", leaveService.findAllLeaves());
		return "leaves-history";
	}
	
	/*
	 * @RequestMapping("/compensation/save") public String
	 * saveCompensationForm(@ModelAttribute("compLeave") @Valid CompensationLeave
	 * compLeave, BindingResult bindingResult,Model model) { if
	 * (bindingResult.hasErrors()) { model.addAttribute("compensationLeave",
	 * compLeave); return "leaves-apply-compensation"; } int overtimeId =
	 * overtimeService.findEarliestApprovedOvertimeId(6);
	 * overtimeService.updateOvertimeStatus(overtimeId,OvertimeStatus.Used);
	 * leaveService.saveCompensationLeave(compLeave); model.addAttribute("Leaves",
	 * leaveService.findAllLeaves()); return "leaves-history"; }
	 */
	@RequestMapping("/compensation/save")
	public String saveCompensationForm(@ModelAttribute("compLeave") CompensationLeave compLeave,
			Model model) {
		leaveService.saveCompensationLeave(compLeave);
		model.addAttribute("Leaves", leaveService.findAllLeaves());
		return "leaves-history";
	}
	
	@RequestMapping("/history")
	public String History(Model model) {
		model.addAttribute("Leaves", leaveService.findAllLeaves());
		return "leaves-history";
	}
	
=======

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
	public String compensationaddForm(Model model) {
		model.addAttribute("compensationLeave", new CompensationLeave());
		return "leaves-apply-compensation";
	}

	
	@RequestMapping("/annual/save")
	public String saveAnnualForm(@ModelAttribute("annualLeave") AnnualLeave annualLeave, 
			Model model) throws ParseException {
		
		int count = 0;
		int adays = 14;
        long dur;
        Date d1 = annualLeave.getStartDate();
		Date d2 = annualLeave.getEndDate();
		count = saturdaysundaycount(d1,d2);
		dur = duration(d1, d2); 
		
		/*
		 * if(count > 0) { return "leaves-applicationdetails"; } else {
		 * System.out.println("Count of Sats & Sundays = "+count);
		 * leaveService.saveAnnualLeave(annualLeave);
		 * model.addAttribute("Leaves",leaveService.findAllLeaves()); return
		 * "leaves-history"; }
		 */
		if(count > 0 &&  dur <= adays ) {
        	long minus = dur - count;
        	System.out.println("less than 14 = " + minus);
        	leaveService.saveAnnualLeave(annualLeave);
   		    model.addAttribute("Leaves",leaveService.findAllLeaves()); 
   		    return "leaves-history";
        }
        else {
        	System.out.println("greater than 14 = " + dur);
        	leaveService.saveAnnualLeave(annualLeave);
   		    model.addAttribute("Leaves",leaveService.findAllLeaves()); 
   		    return "leaves-history";
        }
	}
	
	@RequestMapping("/medical/save")
	public String saveMedicalForm(@ModelAttribute("medicalLeave") MedicalLeave medicalLeave, 
			Model model) {
		leaveService.saveMedicalLeave(medicalLeave);
		model.addAttribute("Leaves", leaveService.findAllLeaves());
		return "leaves-history";
	}
	
	@RequestMapping("/compensation/save")
	public String saveCompensationForm(@ModelAttribute("compLeave") CompensationLeave compLeave, 
			Model model) {
		leaveService.saveCompensationLeave(compLeave);
		model.addAttribute("Leaves", leaveService.findAllLeaves());
		return "leaves-history";
	}
	
	@RequestMapping("/history")
	public String History(Model model) {
		model.addAttribute("Leaves", leaveService.findAllLeaves());
		return "leaves-history";
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
>>>>>>> 637e9ba updates of form apply and leave controller
}
