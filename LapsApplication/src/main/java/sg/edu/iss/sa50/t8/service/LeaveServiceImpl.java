
package sg.edu.iss.sa50.t8.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.model.CompensationLeave;
import sg.edu.iss.sa50.t8.model.LeaveStatus;
import sg.edu.iss.sa50.t8.model.Leaves;
import sg.edu.iss.sa50.t8.model.MedicalLeave;
import sg.edu.iss.sa50.t8.model.Staff;
import sg.edu.iss.sa50.t8.repository.LeaveRepository;
import sg.edu.iss.sa50.t8.repository.StaffRepository;

@Service
public class LeaveServiceImpl implements ILeaveService{

	@Autowired
	LeaveRepository leaveRepo;

	@Override
	public boolean saveAnnualLeave(AnnualLeave aLeave) {
		if (leaveRepo.save(aLeave) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean saveMedicalLeave(MedicalLeave mLeave) {
		/*
		 * int id =mLeave.getId(); if (id>0) { Leaves l = leaveRepo.findLeaveById(id);
		 * l.setId(id); leaveRepo.save(l); } else { return leaveRepo.save(mLeave) !=
		 * null?true:false; } return true;
		 */
		return leaveRepo.save(mLeave) != null?true:false;
	}

	@Override
	public boolean saveCompensationLeave(CompensationLeave cLeave) {
		if (leaveRepo.save(cLeave) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<Leaves> findAllLeaves(int id) {
		return (ArrayList<Leaves>)leaveRepo.findAll(id);
	}

	@Override
	public void updateLeaveStatus(int leaveId,LeaveStatus status) {
		Leaves leave = leaveRepo.findLeaveById(leaveId);
		leave.setStatus(status);
		leaveRepo.save(leave);
	}

	@Override
	public Leaves findLeaveById(int leaveId) {
		return leaveRepo.findLeaveById(leaveId);
	}
	
	@Override
	public String findLeaveTypeById(int leaveId) {
		return leaveRepo.findLeaveTypeById(leaveId);
	}
	
	@Autowired
	StaffRepository staffRepo;
	
	
	@Override
	public int findCurAnnLeave(int id) {
		Staff s = (Staff) staffRepo.findEmployeeById(id);
		int c = s.getCurrentAnnualLeaves();
		return c;
	}

	@Override
	public int findMedAnnLeave(int id) {
		Staff s = (Staff) staffRepo.findEmployeeById(id);
		int c = s.getCurrentMedicalLeaves();
		return c;
	}

}

