package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Expense_CategoryDAO;

import model.Expense_Category;
import utility.ConnectionProvider;

public class Expense_CategoryDAOimpl implements Expense_CategoryDAO {

	Connection con = ConnectionProvider.getConnection();

	@Override
	public boolean insertCategory(Expense_Category ec) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("insert into Expense_Category(category_name,c_description) values(?,?)");

			pstmt.setString(1, ec.getCategory_name());
			pstmt.setString(2, ec.getC_description());
			pstmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Something Went wrong while inserting category record.");
		}
		return false;
	}

	@Override
	public Expense_Category viewExpense_CategoryById(int category_id) {
		// TODO Auto-generated method stub
		Expense_Category e_category = new Expense_Category();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from expense_category where category_id=?");
			pstmt.setInt(1, category_id);
			ResultSet rs = pstmt.executeQuery();
			boolean res = rs.next();
			if (res == false) {
				System.out.println("NO expense_category with this id.");
				return null;
			} else {
				e_category.setCategory_id(rs.getInt(1));
				e_category.setCategory_name(rs.getString(2));
				e_category.setC_description(rs.getString(3));

				return e_category;
			}
		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println("Something Went wrong while retrieving record of Expense_category.");
			return null;
		}
	}

	@Override
	public List<Expense_Category> viewAllExpense_Category() {
		// TODO Auto-generated method stub
		List<Expense_Category> eclist = new ArrayList<Expense_Category>();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from expense_category");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Expense_Category e_category = new Expense_Category();
				e_category.setCategory_id(rs.getInt(1));
				e_category.setCategory_name(rs.getString(2));
				e_category.setC_description(rs.getString(3));

				eclist.add(e_category);
			}

			if (eclist.isEmpty()) {
				System.out.println("No expense category in DB");
				return null;
			}

			return eclist;

		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println("Something Went wrong while retrieving expense category list.");
			return null;
		}

	}

	@Override
	public boolean updateExpense_Category(Expense_Category ec) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"update expense_category set category_name=?,c_description=? where category_id=?");
			pstmt.setString(1, ec.getCategory_name());
			pstmt.setString(2, ec.getC_description());
			pstmt.setInt(3, ec.getCategory_id());
			int i = pstmt.executeUpdate();
			if (i > 0)
				return true;
			return false;
		} catch (SQLException e) {

			// e.printStackTrace();
			System.out.println("Something Went wrong while updating expense category.");
			return false;
		}

	}

	@Override
	public boolean deleteExpense_Category(int category_id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = con.prepareStatement("delete from expense_category where category_id=?");
			pstmt.setInt(1, category_id);
			int i = pstmt.executeUpdate();
			if (i > 0)
				return true;
			return false;
		} catch (SQLException e) {
			System.out.println("Something Went wrong while deleting the expense category.");
			return false;
		}
	}

}
