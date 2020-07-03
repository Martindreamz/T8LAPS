package sg.edu.iss.sa50.t8.model;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
@Inheritance
@DiscriminatorColumn(name="EMP_TYPE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
	private String password; 
	
	private long CurrentAnnualLeaves;
	private long CurrentMedicalLeaves; 
	private int totalOTHours;

	public Employee() {}

    public Employee(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    	  password = "000000"; 
        
    }
    public Employee(String name,String email,Long annualLeaveDays,Long medicalLeaveDays) {
    	this.name = name;
        this.email = email;
        this.CurrentAnnualLeaves = annualLeaveDays;
        this.CurrentMedicalLeaves = medicalLeaveDays;
        password = "000000"; 
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

 

    public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public int getTotalOTHours() {
		return totalOTHours;
	}

	public void setTotalOTHours(int totalOTHours) {
		this.totalOTHours = totalOTHours;
	}

	@Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
    }

	@Transient
	public String getDiscriminatorValue(){
		return this.getClass().getAnnotation(DiscriminatorValue.class).value();
	}
	
	//Theingi
	public long getAnnualLeaveDays() {
		return CurrentAnnualLeaves;
	}


	public void setAnnualLeaveDays(long annualLeaveDays) {
		this.CurrentAnnualLeaves = annualLeaveDays;
	}


	public void setMedicalLeaveDays(int medicalLeaveDays) {
		this.CurrentMedicalLeaves = medicalLeaveDays;
	}

	public long getCurrentAnnualLeaves() {
		return CurrentAnnualLeaves;
	}

	public void setCurrentAnnualLeaves(long currentAnnualLeaves) {
		CurrentAnnualLeaves = currentAnnualLeaves;
	}

	public long getCurrentMedicalLeaves() {
		return CurrentMedicalLeaves;
	}

	public void setCurrentMedicalLeaves(long currentMedicalLeaves) {
		CurrentMedicalLeaves = currentMedicalLeaves;
	}

}