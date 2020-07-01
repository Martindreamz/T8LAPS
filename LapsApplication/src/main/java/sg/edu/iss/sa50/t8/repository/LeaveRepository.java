package sg.edu.iss.sa50.t8.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.sa50.t8.model.*;
@Primary
public interface LeaveRepository extends JpaRepository<Leaves, Integer>{

	@Query(value="SELECT * FROM Leaves",nativeQuery = true)
	List<Leaves> findAll();
	
	@Query(value="SELECT l FROM Leaves l WHERE l.staff = :staff "
			+ "and l.status in (sg.edu.iss.sa50.t8.model.LeaveStatus.Applied,"
			 +"sg.edu.iss.sa50.t8.model.LeaveStatus.Updated)") 
	List<Leaves> findPendingleavesByStaff(@Param("staff") Staff Staff);
	
	@Query(value="SELECT l FROM Leaves l WHERE l.staff = :staff") 
	List<Leaves> findAllLeavesByStaff(@Param("staff") Staff Staff);
	 
}
