package sg.edu.iss.sa50.t8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.sa50.t8.model.BlockedLeaves;

public interface BlockedLeavesRepository extends JpaRepository<BlockedLeaves, Integer> {

	void deleteAll();
	
}
