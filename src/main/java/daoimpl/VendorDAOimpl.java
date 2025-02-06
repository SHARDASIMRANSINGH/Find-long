package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.VendorDAO;

import model.Vendor;
import utility.ConnectionProvider;

public class VendorDAOimpl implements VendorDAO {
	
	Connection con=ConnectionProvider.getConnection();

	@Override
	public boolean insertVendor(Vendor ven) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into Vendor(vendor_name,v_contact,v_address) values(?,?,?)");
			pstmt.setString(1,ven.getVendor_name());
			pstmt.setString(2,ven.getV_contact());
			pstmt.setString(3,ven.getV_address());
			
			pstmt.executeUpdate();
		    return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Something Went wrong while inserting vendor.");
		}
		return false;
	}

	@Override
	public Vendor viewVendorById(int vendor_id) {
		// TODO Auto-generated method stub
		Vendor vendor = new Vendor();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from vendor where vendor_id=?");
			pstmt.setInt(1, vendor_id);
			ResultSet rs = pstmt.executeQuery();
			boolean res = rs.next();
			if (res == false) {
				System.out.println("NO vendor with this id.");
				return null;
			} else {
				vendor.setVendor_id(rs.getInt(1));
				vendor.setVendor_name(rs.getString(2));
				vendor.setV_contact(rs.getString(3));
				vendor.setV_address(rs.getString(4));

				return vendor;
			}
		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println("Something Went wrong while retrieving record of Vendor.");
			return null;
		}
	}

	@Override
	public List<Vendor> viewAllVendor() {
		// TODO Auto-generated method stub
		List<Vendor> vlist = new ArrayList<Vendor>();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from vendor");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Vendor vendor = new Vendor();
				vendor.setVendor_id(rs.getInt(1));
				vendor.setVendor_name(rs.getString(2));
				vendor.setV_contact(rs.getString(3));
				vendor.setV_address(rs.getString(4));

				vlist.add(vendor);
			}

			if (vlist.isEmpty()) {
				System.out.println("No vendor in DB");
				return null;
			}

			return vlist;

		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println("Something Went wrong while retrieving vendor list.");
			return null;
		}
	}

	@Override
	public boolean updateVendor(Vendor ven) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"update expense_category set vendor_name=?,v_contact=?,v_address where vendor_id=?");
			pstmt.setString(1, ven.getVendor_name());
			pstmt.setString(2, ven.getV_contact());
			pstmt.setString(3, ven.getV_address());
			pstmt.setInt(4, ven.getVendor_id());
			int i = pstmt.executeUpdate();
			if (i > 0)
				return true;
			return false;
		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println("Something Went wrong while updating vendor.");
			return false;
		}
	}

	@Override
	public boolean deleteVendor(int vendor_id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = con.prepareStatement("delete from vendor where vendor_id=?");
			pstmt.setInt(1, vendor_id);
			int i = pstmt.executeUpdate();
			if (i > 0)
				return true;
			return false;
		} catch (SQLException e) {
			System.out.println("Something Went wrong while deleting the vendor.");
			return false;
		}
	}

}
