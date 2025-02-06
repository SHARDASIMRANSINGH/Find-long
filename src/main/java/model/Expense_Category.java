package model;



//import java.sql.Date;

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
public class Expense_Category {
	
	private int category_id;
	private String category_name;
	private String c_description;
	
	// Constructor for creating a new category (without emp_id)
    public Expense_Category(String cName, String c_description) {
        this.category_name = cName;
        this.c_description = c_description;
      
        }
	

}
