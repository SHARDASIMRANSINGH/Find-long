package dao;

import java.util.List;

import model.Expenses;



public interface ExpensesDAO {
	
	boolean insertExpenses(Expenses exp);
	Expenses viewExpensesById(int exp_id);
	List<Expenses> viewAllExpenses();
//	boolean updateExpenses(Expenses exp);
//	boolean deleteExpenses(int exp_id);

}
