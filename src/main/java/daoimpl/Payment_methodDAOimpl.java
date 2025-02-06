package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Payment_methodDAO;

import model.Payment_method;
import utility.ConnectionProvider;

public class Payment_methodDAOimpl implements Payment_methodDAO {
	
	Connection con = ConnectionProvider.getConnection();

	@Override
	public boolean insertPayment_method(Payment_method pm) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("insert into Payment_method(pm_name,pm_description) values(?,?)");

			pstmt.setString(1, pm.getPm_name());
			pstmt.setString(2, pm.getPm_description());
			pstmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Something Went wrong while inserting Payment method record.");
		}
		return false;
	}

	@Override
	public Payment_method viewPayment_methodById(int pm_id) {
		// TODO Auto-generated method stub
		Payment_method paymentm = new Payment_method();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from payment_method where pm_id=?");
			pstmt.setInt(1, pm_id);
			ResultSet rs = pstmt.executeQuery();
			boolean res = rs.next();
			if (res == false) {
				System.out.println("NO payment with this id.");
				return null;
			} else {
				paymentm.setPm_id(rs.getInt(1));
				paymentm.setPm_name(rs.getString(2));
				paymentm.setPm_description(rs.getString(3));

				return paymentm;
			}
		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println("Something Went wrong while retrieving record of Payment method.");
			return null;
		}
	}

	@Override
	public List<Payment_method> viewAllPayment_method() {
		// TODO Auto-generated method stub
		List<Payment_method> pmlist = new ArrayList<Payment_method>();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from Payment_method");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Payment_method paymentm = new Payment_method();
				paymentm.setPm_id(rs.getInt(1));
				paymentm.setPm_name(rs.getString(2));
				paymentm.setPm_description(rs.getString(3));

				pmlist.add(paymentm);
			}

			if (pmlist.isEmpty()) {
				System.out.println("No payment in DB");
				return null;
			}

			return pmlist;

		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println("Something Went wrong while retrieving payment list.");
			return null;
		}
	}

//	@Override
//	public boolean updatePayment_method(Payment_method pm) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean deletePayment_method(int pm_id) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
