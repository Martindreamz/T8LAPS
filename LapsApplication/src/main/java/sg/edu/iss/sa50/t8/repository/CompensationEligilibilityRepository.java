package sg.edu.iss.sa50.t8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.sa50.t8.model.Compensation_eligibility;


public interface CompensationEligilibilityRepository extends JpaRepository<Compensation_eligibility, Integer>{
	@Query(value="UPDATE Compensation_eligibility SET availableHours=?2 WHERE staff_id=?1",nativeQuery = true)
	public void updateOvertimeStatus(int staffId,int hr);
	
	@Query(value="SELECT availableHours FROM Compensation_eligibility WHERE staff_id=?1",nativeQuery = true)
	public int findAvailableHoursByStaffId(int staff);
	
}
