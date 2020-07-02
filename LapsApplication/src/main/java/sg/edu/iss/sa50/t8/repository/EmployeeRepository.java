package sg.edu.iss.sa50.t8.repository;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.sa50.t8.model.*;

@Primary
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value="UPDATE Employee SET totalOTHours=?2 WHERE id=?1",nativeQuery = true)
	public void updateTotalOTHoursByEmpId(int empId,int hr);
	
	@Query(value="SELECT totalOTHours FROM Employee WHERE id=?1",nativeQuery = true)
	public int findTotalOTHoursByEmpId(int empId);
	
	@Query("SELECT s FROM Staff s where s.manager = :manager") 
	ArrayList<Staff> findSubordinates(@Param("manager") Manager manager);
	
	@Query("SELECT s FROM Staff s where s.id = :stfId") 
	Staff findStaffById(@Param("stfId") int id);
	
}
