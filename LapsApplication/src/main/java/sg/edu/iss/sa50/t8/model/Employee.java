package sg.edu.iss.sa50.t8.model;

 

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

 

@MappedSuperclass
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    private String email;
    
    @NotBlank(message = "EmployeeType is mandatory")
    private employeeType employeetype; 
    
    
    public Employee() {
        super();
        // TODO Auto-generated constructor stub 
    }

 

    public Employee(int id, String name, String email) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        
    }

 

    public Employee(String name, String email) {
        super();
        this.name = name;
        this.email = email;
        
    }

 

    public int getId() {
        return id;
    }

 

    public void setId(int id) {
        this.id = id;
    }

 

    public String getName() {
        return name;
    }

 

    public void setName(String name) {
        this.name = name;
    }

 

    public String getEmail() {
        return email;
    }

 

    public void setEmail(String email) {
        this.email = email;
    }

 

    

 

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
    }



	public employeeType getEmployeetype() {
		return employeetype;
	}



	public void setEmployeetype(employeeType employeetype) {
		this.employeetype = employeetype;
	}
    
    
    

 

}