package model;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Expense_type {

	private int type_id;
	private String type_name;
	private String t_description;
	
	
	// Constructor for creating a new category (without emp_id)
    public Expense_type(String tName, String t_description) {
        this.type_name = tName;
        this.t_description = t_description;
      
        }
	
}
