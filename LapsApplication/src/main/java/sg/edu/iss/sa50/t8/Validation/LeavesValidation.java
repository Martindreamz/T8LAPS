package sg.edu.iss.sa50.t8.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import sg.edu.iss.sa50.t8.model.Staff;


public class LeavesValidation implements ConstraintValidator<Leave, Staff> {

	@Override
	public boolean isValid(Staff staff, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return (staff.getCurrentAnnualLeaves() <= staff.getTotalAnnualLeaves())? true : false;	
	}
	
	@Override
	public void initialize(Leave constraintAnnotation) {
		
	}
}
