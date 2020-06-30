package sg.edu.iss.sa50.t8.model2;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends Staff{
	@OneToOne
	private Team team;
	
	public Manager() {
		super();
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	

}
