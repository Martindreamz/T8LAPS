package sg.edu.iss.sa50.t8.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.model.CompensationLeave;
import sg.edu.iss.sa50.t8.model.Leaves;
import sg.edu.iss.sa50.t8.model.MedicalLeave;
import sg.edu.iss.sa50.t8.repository.LeaveRepository;

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
		if (leaveRepo.save(mLeave) != null) {
			return true;
		} else {
			return false;
		}
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
	public ArrayList<Leaves> findAllLeaves() {
		return (ArrayList<Leaves>)leaveRepo.findAll();
	}

}
