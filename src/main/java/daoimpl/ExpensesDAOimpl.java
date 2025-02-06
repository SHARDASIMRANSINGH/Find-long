package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ExpensesDAO;

import model.Expenses;
import utility.ConnectionProvider;

public class ExpensesDAOimpl implements ExpensesDAO {
	
	Connection con=ConnectionProvider.getConnection();

	@Override
	public boolean insertExpenses(Expenses exp) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into Expenses(emp_id,categoty_id,type_id,vendor_id,pm_id,amount,exp_date,exp_description) values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1,exp.getEmp_id());
			pstmt.setInt(2,exp.getCategory_id());
			pstmt.setInt(3,exp.getType_id());
			pstmt.setInt(4,exp.getVendor_id());
			pstmt.setInt(5,exp.getPm_id());
			pstmt.setDouble(6,exp.getAmount());
			pstmt.setDate(7,exp.getExp_date());
			pstmt.setString(8,exp.getExp_description());
			
			pstmt.executeUpdate();
		    return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Something Went wrong while inserting expenses.");
		}
		return false;
	}

	@Override
	public Expenses viewExpensesById(int exp_id) {
		// TODO Auto-generated method stub
		Expenses expenses=new Expenses();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from expenses where exp_id=?");
		    pstmt.setInt(1,exp_id);
			ResultSet rs=pstmt.executeQuery();
			boolean res=rs.next();
			if(res==false)
			{
				System.out.println("NO expenses with this id.");
			    return null;
			}
			else {
				expenses.setExp_id(rs.getInt(1));
				expenses.setEmp_id(rs.getInt(2));
				expenses.setCategory_id(rs.getInt(3));
				expenses.setType_id(rs.getInt(4));
				expenses.setVendor_id(rs.getInt(5));
				expenses.setPm_id(rs.getInt(6));
				expenses.setAmount(rs.getDouble(7));
				expenses.setExp_date(rs.getDate(8));
				expenses.setExp_description(rs.getString(9));
				
				
				return expenses;
			}
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while retrieving record of Expenses.");
			return null;
		}
	}

	@Override
	public List<Expenses> viewAllExpenses() {
		// TODO Auto-generated method stub
		List<Expenses> explist=new ArrayList<Expenses>();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from expenses");
		   	ResultSet rs=pstmt.executeQuery();
		  	
			while(rs.next())
			{
				Expenses expenses=new Expenses();
			    expenses.setExp_id(rs.getInt(1));
				expenses.setEmp_id(rs.getInt(2));
				expenses.setCategory_id(rs.getInt(3));
				expenses.setType_id(rs.getInt(4));
				expenses.setVendor_id(rs.getInt(5));
				expenses.setPm_id(rs.getInt(6));
				expenses.setAmount(rs.getDouble(7));
				expenses.setExp_date(rs.getDate(8));
				expenses.setExp_description(rs.getString(9));

				explist.add(expenses);
			}
			
			if(explist.isEmpty())
			{
				System.out.println("No expense in DB");
				return null;
			}
			
			return explist;	
			
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while retrieving expense list.");
			return null;
		}
	}

/*	@Override
	public boolean updateExpenses(Expenses exp) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt=con.prepareStatement("update expenses set emp_id=?,category_id=?,type_id=?,vendor_id=?,pm_id=?,emp_id=?,amount=?,exp_date=?,exp_description=? where exp_id=?");
			pstmt.setInt(1,exp.getEmp_id() );
			pstmt.setInt(2,exp.getCategory_id() );
			pstmt.setInt(3,exp.getType_id() );
			pstmt.setInt(4,exp.getVendor_id() );
			pstmt.setInt(5,exp.getPm_id() );
			pstmt.setDouble(6,exp.getAmount() );
			pstmt.setDate(1,exp.getExp_date() );
			pstmt.setString(1,exp.getExp_description() );
		     
		    int i=pstmt.executeUpdate();
		    if(i>0)
		      return true;
		    return false;
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while updating expense.");
			return false;
		}
		
	}

	@Override
	public boolean deleteExpenses(int exp_id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt=con.prepareStatement("delete from expenses where exp_id=?");
		    pstmt.setInt(1,exp_id);
		    int i=pstmt.executeUpdate();
		    if(i>0)
		    	return true;
		    return false;
		}
		catch(SQLException e) {
			System.out.println("Something Went wrong while deleting the expenses.");
			return false;
		}
	}
*/
}
