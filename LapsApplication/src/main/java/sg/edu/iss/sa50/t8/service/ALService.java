package sg.edu.iss.sa50.t8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import sg.edu.iss.sa50.t8.model.AnnualLeave;
import sg.edu.iss.sa50.t8.repository.ALRepository;

@Service
@Primary
public class ALService implements ILeaveService {

	@Autowired
	ALRepository alRepo;

	@Override
	public boolean saveAnnualLeave(AnnualLeave aLeave) {
		if (alRepo.save(aLeave) != null) {
			return true;
		} else {
			return false;
		}
	}

}
