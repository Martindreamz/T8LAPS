package sg.edu.iss.sa50.t8.model2;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.*;

@Entity
@DiscriminatorValue("staff")
public class Staff extends Employee{
	
	@ManyToOne
	private Team team;
	@ManyToOne  @JoinColumn(name="manager_id")
	private Manager manager;
	
	public Staff() {
		
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	
}
