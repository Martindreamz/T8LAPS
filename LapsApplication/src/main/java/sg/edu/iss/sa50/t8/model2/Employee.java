package sg.edu.iss.sa50.t8.model2;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Inheritance
@DiscriminatorColumn(name="EMP_TYPE")
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Email is mandatory")
    private String email;
	private String password;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date startDate;


	public Employee() {
        super();
        // TODO Auto-generated constructor stub 
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


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
    
}