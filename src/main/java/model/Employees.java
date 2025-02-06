package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employees {

	private int emp_id;
	private String emp_name;
	private String contact;
	private String department;
	private Date doj;
	
	// Constructor for creating a new employee (without emp_id)
    public Employees(String empName, String contact, String department, Date dateOfJoining) {
        this.emp_name = empName;
        this.contact = contact;
        this.department = department;
        this.doj= dateOfJoining;
    }
}
