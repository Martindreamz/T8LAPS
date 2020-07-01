package sg.edu.iss.sa50.t8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.Staff;

public interface AdminRepository extends EmployeeRepository {
	/*@Query("SELECT e FROM Employee e"
			+ "WHERE e.name LIKE %?1"
			+ "OR e.name LIKE ?1%")
	List<Employee> searchEmployee(String searchTerm);*/
	
	List<Employee> findByNameContaining(String searchTerm);
	
	Employee findById(int id); 
	
	
	@Query("SELECT e FROM Employee e WHERE e.class != 'Admin'")
	List<Staff> findAllNonAdminStaff();
} 
