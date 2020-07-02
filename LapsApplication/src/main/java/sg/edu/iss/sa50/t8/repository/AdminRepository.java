package sg.edu.iss.sa50.t8.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.edu.iss.sa50.t8.model.Admin;
import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.Staff;

@Repository
public interface AdminRepository extends EmployeeRepository {
	/*@Query("SELECT e FROM Employee e"
			+ "WHERE e.name LIKE %?1"
			+ "OR e.name LIKE ?1%")
	List<Employee> searchEmployee(String searchTerm);*/
	
	@Query("SELECT e from Employee e where e.name LIKE :searchTerm")
	List<Employee> findByNameContaining(@Param("searchTerm") String searchTerm);
	
	/* 
	Employee saveAdminNew(Employee employee);
	
	Employee saveStaffNew(Employee employee);
	
	Employee Create(Employee employee);
	
	Employee CreateAdmin(Employee employee);
	
	Employee saveAdmin(Employee employee);
	
	Employee saveStaff(Employee employee);
	
	Employee deleteStaff(Employee employee); */
	
	@Query("SELECT e FROM Employee e WHERE e.id = :id")
	Employee findById(@Param("id") int id); 
	
	@Query("SELECT s FROM Admin s")
	List<Admin> findAllAdmin();
	
	@Query("SELECT e FROM Employee e WHERE e.class = 'Manager'")
	List<Staff> findAllManager();
	
	@Query("SELECT e FROM Employee e WHERE e.class != 'Admin'")
	List<Staff> findAllNonAdminStaff();
	
	@Query("SELECT e FROM Employee e WHERE e.class = 'Admin' AND e.id = :id")
	Admin findAdminById(@Param("id") int id);
} 
