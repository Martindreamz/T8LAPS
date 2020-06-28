package sg.edu.iss.sa50.t8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.sa50.t8.model.Employee;

public interface AdminRepository extends EmployeeRepository {
	/*@Query("SELECT e FROM Staff s, Manager m"
			+ "WHERE s.name LIKE %?1"
			+ "OR s.name LIKE ?1%"
			+ "OR s.email LIKE %?1"
			+ "OR s.email LIKE ?1%"
			+ "OR m.name LIKE %?1"
			+ "OR m.name LIKE ?1%"
			+ "OR m.email LIKE %?1"
			+ "OR m.email LIKE ?1%")
	List<Employee> searchEmployee(String searchTerm);*/
}
