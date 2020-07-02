package sg.edu.iss.sa50.t8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

	@Query("SELECT e FROM Employee e WHERE e.class != 'Admin'")
	List<Staff> findAllNonAdmin();
	
	Employee findEmployeeById(int id);
	
	@Query("SELECT s FROM Staff s WHERE s.id= ?1")
	Staff findStaffById(int id);
}
