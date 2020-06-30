package sg.edu.iss.sa50.t8.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.sa50.t8.model.*;
@Primary
public interface LeaveRepository extends JpaRepository<Leaves, Integer>{

	@Query(value="SELECT * FROM Leaves",nativeQuery = true)
	List<Leaves> findAll();
}
