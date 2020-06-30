package sg.edu.iss.sa50.t8.model2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LeaveTypes {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int MaxLimitCount;
	
	public LeaveTypes() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxLimitCount() {
		return MaxLimitCount;
	}

	public void setMaxLimitCount(int maxLimitCount) {
		MaxLimitCount = maxLimitCount;
	}
	
	
}
