package sg.edu.iss.sa50.t8.model;

import javax.persistence.*;
import javax.validation.constraints.*;

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
	@NotNull
    @Min(0) 
	private long CurrentAnnualLeaves;
	private long CurrentMedicalLeaves; 
	private int TotalAnnualLeaves;
	@Max(60)
	private int TotalMedicalLeaves;
	

	private int totalOTHours;

	
	@Transient
	private String type;
	@Transient
	private int manId;
	@Transient
	private boolean fromedit;
	@Transient
	private int tempid;
	
	
	
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
    
    

    public Employee(int totalAnnualLeaves, int totalMedicalLeaves) {
		super();
		TotalAnnualLeaves = totalAnnualLeaves;
		TotalMedicalLeaves = 60;
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
	public int getTotalAnnualLeaves() {
		return TotalAnnualLeaves;
	}

	public void setTotalAnnualLeaves(int totalAnnualLeaves) {
		TotalAnnualLeaves = totalAnnualLeaves;
	}

	public int getTotalMedicalLeaves() {
		return TotalMedicalLeaves;
	}

	public void setTotalMedicalLeaves(int totalMedicalLeaves) {
		TotalMedicalLeaves = totalMedicalLeaves;
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getManId() {
		return manId;
	}

	public void setManId(int manId) {
		this.manId = manId;
	}

	public boolean isFromedit() {
		return fromedit;
	}

	public void setFromedit(boolean fromedit) {
		this.fromedit = fromedit;
	}

	public int getTempid() {
		return tempid;
	}

	public void setTempid(int tempid) {
		this.tempid = tempid;
	}

}