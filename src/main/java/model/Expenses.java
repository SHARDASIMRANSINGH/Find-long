package model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Expenses {
	private int exp_id;
	private int emp_id;
	private int category_id;
	private int type_id;
	private int vendor_id;
	private int pm_id;
	private double amount;
	private Date exp_date;
	private String exp_description;

	// Constructor for creating a new employee (without emp_id)
	public Expenses(int emp_id, int category_id, int type_id, int vendor_id, int pm_id, double amount, Date dateexp,
			String description) {
		this.exp_id = emp_id;
		this.category_id = category_id;
		this.vendor_id = vendor_id;
		this.pm_id = pm_id;
		this.amount = amount;
		this.exp_date = dateexp;
		this.exp_description = description;

	}
}
