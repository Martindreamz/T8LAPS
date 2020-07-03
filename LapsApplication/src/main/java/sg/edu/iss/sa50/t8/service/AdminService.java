package sg.edu.iss.sa50.t8.service;

import java.util.List;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.sa50.t8.model.Admin;
import sg.edu.iss.sa50.t8.model.Employee;
import sg.edu.iss.sa50.t8.model.Staff;
import sg.edu.iss.sa50.t8.repository.AdminRepository;
import sg.edu.iss.sa50.t8.repository.EmployeeRepository;
import sg.edu.iss.sa50.t8.repository.ManagerRepository;
import sg.edu.iss.sa50.t8.repository.StaffRepository;

@Service
public class AdminService implements IEmployeeService {
	
	@Autowired
	AdminRepository arepo;
	
	@Autowired
	StaffRepository srepo;
	
	@Transactional
	public void deleteAdminById(int adminId) {
		arepo.deleteAdminById(adminId);
	}
	
	@Transactional
	public void deleteStaffById(int adminId) {
		srepo.deleteStaffById(adminId);
	}
	
	public List<Employee> findAllManager() {
		return eRepo.findAllManager();
	}
	
	public boolean saveAdmin(Admin admin) {
		return arepo.save(admin)!=null? true : false;
	}
	
	public List<Employee> searchEmployee(String searchTerm){
		//return arepo.searchEmployee(searchTerm);
		return arepo.findByNameContaining(searchTerm);
	}
	
	public List<Employee> findAll(){
		return arepo.findAll();
	}
	
	public Employee findById(int id) {
		return arepo.findById(id);
	}
	
	public boolean save(Employee entry) {
		return arepo.save(entry)!=null? true : false;
	}
	
	
	public List<Staff> findAllNonAdminStaff(){
		return arepo.findAllNonAdminStaff();
	}

	public List<Admin> findallAdmin(){
		return arepo.findAllAdmin();
	}
	
	public Admin findAdminById(int id) {
		// TODO Auto-generated method stub
		return arepo.findAdminById(id);
	}
	
	public Staff findStaffById(int id) {
		// TODO Auto-generated method stub
		return arepo.findStaffById(id);
	}
	
	@Autowired
	EmployeeRepository eRepo;
	
	public void updateTotalOTHoursByEmpId(int empId, int hr) {
		Employee emp = eRepo.findEmployeeById(empId);
		emp.setTotalOTHours(hr);
		eRepo.save(emp);
	}

	public Employee findEmployeeById(int EmpId) {
		return eRepo.findEmployeeById(EmpId);
	}
	public int findTotalOTHoursByEmpId(int empId) {
		return (Integer)eRepo.findTotalOTHoursByEmpId(empId);
	}


}
