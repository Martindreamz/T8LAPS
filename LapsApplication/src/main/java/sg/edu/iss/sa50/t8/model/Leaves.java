package sg.edu.iss.sa50.t8.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Leaves{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private LocalDate startdate;
	private LocalDate enddate;
	private LeaveStatus leaveStatus;


	public Leaves() {
		// TODO Auto-generated constructor stub
	}

}
