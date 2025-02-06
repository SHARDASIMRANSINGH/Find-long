package dao;

import java.util.List;


import model.Expense_Category;



public interface Expense_CategoryDAO {
	
	boolean insertCategory(Expense_Category ec);
	Expense_Category viewExpense_CategoryById(int category_id);
	List<Expense_Category> viewAllExpense_Category();
	boolean updateExpense_Category(Expense_Category ec);
	boolean deleteExpense_Category(int category_id);
	

}
