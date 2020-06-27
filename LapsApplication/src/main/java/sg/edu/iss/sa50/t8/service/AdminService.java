package sg.edu.iss.sa50.t8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.repository.AdminRepository;

@Service
public class AdminService implements IEmployeeService {
	
	@Autowired
	AdminRepository arepo;
	
	public List<Employee> searchEmployee(String searchTerm){
		return arepo.searchEmployee(searchTerm);
	}
}
