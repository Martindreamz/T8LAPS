package sg.edu.iss.sa50.t8.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.model.CompensationLeave;
import sg.edu.iss.sa50.t8.model.Leaves;
<<<<<<< Upstream, based on origin/master
import sg.edu.iss.sa50.t8.model.MedicalLeave;
=======
import sg.edu.iss.sa50.t8.model.MedicalLeave;
>>>>>>> 637e9ba updates of form apply and leave controller

<<<<<<< Upstream, based on origin/master
@Service
public interface ILeaveService {
	public boolean saveAnnualLeave(AnnualLeave aLeave);	
	public boolean saveMedicalLeave(MedicalLeave mLeave);	
	public boolean saveCompensationLeave(CompensationLeave cLeave);
	
	public ArrayList<Leaves> findAllLeaves();
}
=======

@Service
public interface ILeaveService {
	public boolean saveAnnualLeave(AnnualLeave aLeave);	
	public boolean saveMedicalLeave(MedicalLeave mLeave);	
	public boolean saveCompensationLeave(CompensationLeave cLeave);
	
	public ArrayList<Leaves> findAllLeaves();

}
>>>>>>> 637e9ba updates of form apply and leave controller
