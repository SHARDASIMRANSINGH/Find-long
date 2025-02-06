package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeesDAO;
import model.Employees;
import utility.ConnectionProvider;

public class EmployeesDAOimpl implements EmployeesDAO{
	
	
	Connection con=ConnectionProvider.getConnection();


	@Override
	public boolean insertEmployees(Employees emp) {
		
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into Employees(emp_name,contact,department,doj) values(?,?,?,?)");
			pstmt.setString(1,emp.getEmp_name());
			pstmt.setString(2,emp.getContact());
			pstmt.setString(3,emp.getDepartment());
			pstmt.setDate(4,emp.getDoj());
			pstmt.executeUpdate();
		    return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Something Went wrong while inserting record.");
		}
		return false;
	}

	@Override
	public Employees viewEmployeesById(int emp_id) {
		// TODO Auto-generated method stub
		Employees employees=new Employees();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from employees where emp_id=?");
		    pstmt.setInt(1,emp_id);
			ResultSet rs=pstmt.executeQuery();
			boolean res=rs.next();
			if(res==false)
			{
				System.out.println("NO employee with this id.");
			    return null;
			}
			else {
				employees.setEmp_id(rs.getInt(1));
				employees.setEmp_name(rs.getString(2));
				employees.setContact(rs.getString(3));
				employees.setDepartment(rs.getString(4));
				employees.setDoj(rs.getDate(5));
				
				return employees;
			}
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while retrieving record of Employees.");
			return null;
		}
	}

	@Override
	public List<Employees> viewAllEmployees() {
		// TODO Auto-generated method stub
		List<Employees> emplist=new ArrayList<Employees>();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from employees");
		   	ResultSet rs=pstmt.executeQuery();
		  	
			while(rs.next())
			{
			    Employees employees=new Employees();
			    employees.setEmp_id(rs.getInt(1));
			    employees.setEmp_name(rs.getString(2));
			    employees.setContact(rs.getString(3));
			    employees.setDepartment(rs.getString(4));
			    employees.setDoj(rs.getDate(5));
				emplist.add(employees);
			}
			
			if(emplist.isEmpty())
			{
				System.out.println("No employee in DB");
				return null;
			}
			
			return emplist;	
			
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while retrieving employee list.");
			return null;
		}
		 
		
	}

	@Override
	public boolean updateEmployees(Employees emp) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt=con.prepareStatement("update employees set emp_name=?,contact=?,department=?,doj=? where emp_id=?");
		    pstmt.setString(1,emp.getEmp_name() );
			pstmt.setString(2, emp.getContact());
		    pstmt.setString(3, emp.getDepartment());
		    pstmt.setDate(4, emp.getDoj());
		    pstmt.setInt(5, emp.getEmp_id());
		    int i=pstmt.executeUpdate();
		    if(i>0)
		      return true;
		    return false;
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something Went wrong while updating employee.");
			return false;
		}
		
		
	}

	@Override
	public boolean deleteEmployees(int emp_id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt=con.prepareStatement("delete from employees where emp_id=?");
		    pstmt.setInt(1,emp_id);
		    int i=pstmt.executeUpdate();
		    if(i>0)
		    	return true;
		    return false;
		}
		catch(SQLException e) {
			System.out.println("Something Went wrong while deleting the employee.");
			return false;
		}
	}

}
