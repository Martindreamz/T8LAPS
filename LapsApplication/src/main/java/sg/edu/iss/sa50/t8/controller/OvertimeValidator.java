package sg.edu.iss.sa50.t8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sg.edu.iss.sa50.t8.model.CompensationLeave;
import sg.edu.iss.sa50.t8.service.IOvertimeService;
import sg.edu.iss.sa50.t8.service.OvertimeserviceImpl;

public class OvertimeValidator implements Validator{
	@Autowired
	protected IOvertimeService overtimeService;
	
	@Autowired
	public void setIOvertimeService(OvertimeserviceImpl overtimeSerImpl) {
		this.overtimeService = overtimeSerImpl;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return CompensationLeave.class.equals(clazz);
	} 

	@Override
	public void validate(Object target, Errors errors) {
		CompensationLeave cl = (CompensationLeave)target;
		//int totalOT = overtimeService.findTotalOvertimeByStaffId(cl.getStaff().getId());
		int totalOT = overtimeService.findTotalOvertimeByStaffId(6);
		
		if(totalOT < 4) {
			errors.rejectValue("err_msg", "Sry you can't claim compensation leave.");
		}
		
	}

}
