package sg.edu.iss.sa50.t8.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.model.CompensationLeave;
import sg.edu.iss.sa50.t8.model.LeaveStatus;
import sg.edu.iss.sa50.t8.model.Leaves;
import sg.edu.iss.sa50.t8.model.MedicalLeave;

@Service
public interface ILeaveService {
	public boolean saveAnnualLeave(AnnualLeave aLeave);	
	public boolean saveMedicalLeave(MedicalLeave mLeave);
	public boolean saveCompensationLeave(CompensationLeave cLeave);
	public void updateLeaveStatus(int leaveId,LeaveStatus status);
	public Leaves findLeaveById(int leaveId);
	public String findLeaveTypeById(int leaveId);
	public ArrayList<Leaves> findAllLeaves(int id);
	public int findCurAnnLeave(int id);
	public int findMedAnnLeave(int id);
	

}

