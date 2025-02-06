package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Expense_typeDAO;

import model.Expense_type;
import utility.ConnectionProvider;

public class Expense_typeDAOimpl implements Expense_typeDAO {
	
	Connection con = ConnectionProvider.getConnection();

	@Override
	public boolean insertType(Expense_type et) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("insert into Expense_type(type_name,t_description) values(?,?)");

			pstmt.setString(1, et.getType_name());
			pstmt.setString(2, et.getT_description());
			pstmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Something Went wrong while inserting expense type record.");
		}
		return false;
	}

	@Override
	public Expense_type viewExpense_typeById(int type_id) {
		// TODO Auto-generated method stub
		Expense_type e_type = new Expense_type();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from expense_type where type_id=?");
			pstmt.setInt(1, type_id);
			ResultSet rs = pstmt.executeQuery();
			boolean res = rs.next();
			if (res == false) {
				System.out.println("NO expense_type with this id.");
				return null;
			} else {
				e_type.setType_id(rs.getInt(1));
				e_type.setType_name(rs.getString(2));
				e_type.setT_description(rs.getString(3));

				return e_type;
			}
		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println("Something Went wrong while retrieving record of Expense_type.");
			return null;
		}
	}

	@Override
	public List<Expense_type> viewAllExpense_type() {
		// TODO Auto-generated method stub
		List<Expense_type> etlist = new ArrayList<Expense_type>();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from expense_type");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Expense_type e_type = new Expense_type();
				e_type.setType_id(rs.getInt(1));
				e_type.setType_name(rs.getString(2));
				e_type.setT_description(rs.getString(3));

				etlist.add(e_type);
			}

			if (etlist.isEmpty()) {
				System.out.println("No expense type in DB");
				return null;
			}

			return etlist;

		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println("Something Went wrong while retrieving expense type list.");
			return null;
		}
	}

	@Override
	public boolean updateExpense_type(Expense_type et) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"update expense_type set type_name=?,t_description=? where type_id=?");
			pstmt.setString(1, et.getType_name());
			pstmt.setString(2, et.getT_description());
			pstmt.setInt(3, et.getType_id());
			int i = pstmt.executeUpdate();
			if (i > 0)
				return true;
			return false;
		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println("Something Went wrong while updating expense type.");
			return false;
		}
	}

	@Override
	public boolean deleteExpense_type(int type_id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = con.prepareStatement("delete from expense_type where type_id=?");
			pstmt.setInt(1, type_id);
			int i = pstmt.executeUpdate();
			if (i > 0)
				return true;
			return false;
		} catch (SQLException e) {
			System.out.println("Something Went wrong while deleting the expense type.");
			return false;
		}
	}

}
