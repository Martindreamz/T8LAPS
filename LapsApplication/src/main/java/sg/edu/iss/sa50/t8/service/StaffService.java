package sg.edu.iss.sa50.t8.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.Staff;
import sg.edu.iss.sa50.t8.repository.AdminRepository;
import sg.edu.iss.sa50.t8.repository.EmployeeRepository;
import sg.edu.iss.sa50.t8.repository.StaffRepository;

@Service
public class StaffService implements IEmployeeService {
	
	@Autowired
	StaffRepository sRepo;

	
	public List<Employee> searchEmployee(String searchTerm){
		//return arepo.searchEmployee(searchTerm);
		return sRepo.findByNameContaining(searchTerm);
	}
	
	public List<Employee> findAll(){
		return sRepo.findAll();
	}
	
	public Staff findById(int id) {
		return sRepo.findByStaffId(id);
	}
	
	public boolean save(Employee entry) {
		return sRepo.save(entry)!=null? true : false;
	}
	
	
	public List<Staff> findAllNonAdminStaff(){
		return sRepo.findAllNonAdmin();
	}

	
	@Autowired
	EmployeeRepository eRepo;
	
	public void updateTotalOTHoursByEmpId(int empId, int hr) {
		eRepo.updateTotalOTHoursByEmpId(empId, hr);
	}

	public int findTotalOTHoursByEmpId(int empId) {
		return eRepo.findTotalOTHoursByEmpId(empId);
	}
}

//@Service
//public class StaffService implements IEmployeeService {
//	@Autowired
//	EmployeeRepository eRepo;
//	
//	public void updateTotalOTHoursByEmpId(int empId, int hr) {
//		eRepo.updateTotalOTHoursByEmpId(empId, hr);
//	}
//
//	public int findTotalOTHoursByEmpId(int empId) {
//		return eRepo.findTotalOTHoursByEmpId(empId);
//	}
//
//}
