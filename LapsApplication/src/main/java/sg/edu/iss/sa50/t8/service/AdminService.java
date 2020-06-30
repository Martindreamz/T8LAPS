package sg.edu.iss.sa50.t8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.repository.AdminRepository;

@Service
public class AdminService implements IEmployeeService {
	
	@Autowired
	AdminRepository arepo;

	
	public List<Employee> searchEmployee(String searchTerm){
		//return arepo.searchEmployee(searchTerm);
		return arepo.findByNameContaining(searchTerm);
	}
	
	public List<Employee> findAll(){
		return arepo.findAll();
	}
	
	public Optional<Employee> findById(int id) {
		return arepo.findById(id);
	}
	
	public boolean save(Employee entry) {
		return arepo.save(entry)!=null? true : false;
	}
	
}
