package dao;

import java.util.List;

import model.Vendor;

public interface VendorDAO {
	
	boolean insertVendor(Vendor ven);
	Vendor viewVendorById(int vendor_id);
	List<Vendor> viewAllVendor();
	boolean updateVendor(Vendor ven);
	boolean deleteVendor(int vendor_id);

}
