package sg.edu.iss.sa50.t8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.sa50.t8.model.CompensationLeave;

public interface CLRepository extends LeaveRepository {
	@Query(value="SELECT * FROM Leaves where Leave_Type='Compensation_Leave'",nativeQuery = true)
	List<CompensationLeave> findAllCompensationLeaves();
}
