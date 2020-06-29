package sg.edu.iss.sa50.t8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.sa50.t8.model.AnnualLeave;

public interface ALRepository extends LeaveRepository {
	//@Query("select l from Leaves l where l.Leave_Type='Annual_Leave'")
	//Native Queries
	@Query(value="SELECT * FROM Leaves where Leave_Type='Annual_Leave'",nativeQuery = true)
	List<AnnualLeave> findAllAnnualLeaves();
}
