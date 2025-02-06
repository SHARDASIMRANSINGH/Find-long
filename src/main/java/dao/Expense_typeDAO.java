package dao;

import java.util.List;


import model.Expense_type;

public interface Expense_typeDAO {
	
	boolean insertType(Expense_type et);
	Expense_type viewExpense_typeById(int type_id);
	List<Expense_type> viewAllExpense_type();
	boolean updateExpense_type(Expense_type et);
	boolean deleteExpense_type(int type_id);

}
