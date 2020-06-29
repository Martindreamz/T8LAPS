package sg.edu.iss.sa50.t8.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@DiscriminatorValue("Medical_Leave")
public class MedicalLeave extends Leaves {

	private LocalDate endDate;

	public MedicalLeave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicalLeave(LocalDate endDate) {
		super();
		this.endDate = endDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
}
