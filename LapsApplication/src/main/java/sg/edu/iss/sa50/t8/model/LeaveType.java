package sg.edu.iss.sa50.t8.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Name is mandatory")
    private String name;
	public LeaveType(@NotBlank(message = "Name is mandatory") String name) {
		super();
		this.name = name;
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
	@Override
	public String toString() {
		return "LeaveType [id=" + id + ", name=" + name + "]";
	}
    
    
    

}