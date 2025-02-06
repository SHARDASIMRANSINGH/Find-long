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
public class Payment_method {
	
	private int pm_id;
	private String pm_name;
	private String pm_description;

	
	// Constructor for creating a new category (without emp_id)
    public Payment_method(String pmName, String pm_description) {
        this.pm_name = pmName;
        this.pm_description = pm_description;
      
        }
	
}
