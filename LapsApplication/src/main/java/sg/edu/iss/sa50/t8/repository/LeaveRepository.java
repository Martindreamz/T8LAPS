package sg.edu.iss.sa50.t8.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.sa50.t8.model.*;
@Primary
public interface LeaveRepository extends JpaRepository<Leaves, Integer>{
	/*
	 * @Query(value="SELECT * FROM Leaves where Leave_Type='Compensation_Leave'"
	 * ,nativeQuery = true) List<CompensationLeave> findAllCompensationLeaves();
	 * //@Query("select l from Leaves l where l.Leave_Type='Annual_Leave'") //Native
	 * Queries
	 * 
	 * @Query(value="SELECT * FROM Leaves where Leave_Type='Annual_Leave'"
	 * ,nativeQuery = true) List<AnnualLeave> findAllAnnualLeaves();
	 * //@Query("select l from Leaves l where l.Leave_Type='Medical_Leave'")
	 * 
	 * @Query(value="SELECT * FROM Leaves where Leave_Type='Medical_Leave'"
	 * ,nativeQuery = true) List<MedicalLeave> findAllMedicalLeaves();
	 */
	@Query(value="SELECT * FROM Leaves",nativeQuery = true)
	List<Leaves> findAll();
}
