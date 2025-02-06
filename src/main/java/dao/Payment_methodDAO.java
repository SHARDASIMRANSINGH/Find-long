package dao;

import java.util.List;

import model.Payment_method;



public interface Payment_methodDAO {

	boolean insertPayment_method(Payment_method pm);
	Payment_method viewPayment_methodById(int pm_id);
	List<Payment_method> viewAllPayment_method();
	//boolean updatePayment_method(Payment_method pm);
	//boolean deletePayment_method(int pm_id);
}
