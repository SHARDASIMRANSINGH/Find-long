package dao;

import java.util.List;

import model.Employees;

public interface EmployeesDAO {

	boolean insertEmployees(Employees emp);
	Employees viewEmployeesById(int emp_id);
	List<Employees> viewAllEmployees();
	boolean updateEmployees(Employees emp);
	boolean deleteEmployees(int emp_id);

	
}
