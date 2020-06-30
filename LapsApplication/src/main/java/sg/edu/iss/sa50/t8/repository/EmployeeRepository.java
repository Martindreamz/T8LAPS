package sg.edu.iss.sa50.t8.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.iss.sa50.t8.model.Employee;

@Primary
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
