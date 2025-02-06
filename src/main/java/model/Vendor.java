package model;

//import java.sql.Date;

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
//@Data
public class Vendor {
	
	private int vendor_id;
	private String vendor_name;
	private String v_contact;
	private String v_address;
	
	// Constructor for creating a new employee (without emp_id)
    public Vendor(String venName, String v_contact, String v_address) {
        this.vendor_name = venName;
        this.v_contact = v_contact;
        this.v_address = v_address;
        
    }

}
