package sg.edu.iss.sa50.t8.service;

import sg.edu.iss.sa50.t8.model.Overtime;

public interface IOvertimeService {
	public boolean saveOvertime(Overtime overtime);	
	public int findTotalOvertimeByStaffId(int staff);
}
