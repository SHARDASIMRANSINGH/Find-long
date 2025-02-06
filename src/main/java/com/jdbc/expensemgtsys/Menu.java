package com.jdbc.expensemgtsys;

import dao.EmployeesDAO;
import model.Employees;
import daoimpl.EmployeesDAOimpl;

import dao.ExpensesDAO;
import model.Expenses;
import daoimpl.ExpensesDAOimpl;

import dao.VendorDAO;
import model.Vendor;
import daoimpl.VendorDAOimpl;

import model.Expense_Category;
import dao.Expense_CategoryDAO;
import daoimpl.Expense_CategoryDAOimpl;

import model.Expense_type;
import dao.Expense_typeDAO;
import daoimpl.Expense_typeDAOimpl;

import model.Payment_method;
import dao.Payment_methodDAO;
import daoimpl.Payment_methodDAOimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.sql.Date;
import java.util.List;

public class Menu {

	void displayMainMenu() throws NumberFormatException, IOException {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Main Menu :");
			System.out.println("1. Employees :");
			System.out.println("2. Expense_category :");
			System.out.println("3. Expense_type :");
			System.out.println("4. Expenses :");
			System.out.println("5. Payment_method :");
			System.out.println("6. Vendor :");
			System.out.println("7. Exit :");

			System.out.println("Please Enter your Choice :");
			int ch = scan.nextInt();

			switch (ch) {
			case 1:
				displayEmployeesMenu();
				break;
			case 2:
				displayExpense_categoryMenu();
				break;
			case 3:
				displayExpense_typeMenu();
				break;
			case 4:
				displayExpensesMenu();
				break;
			case 5:
				displayPayment_methodMenu();
				break;
			case 6:
				displayVendorMenu();
				break;
			case 7:
				System.exit(0);
				break;
			default: {
				System.out.println("Please enter a valid choice :");
				System.out.println("Please Enter your Choice :");
				ch = scan.nextInt();
			}
			}
		}

	}

	private void displayVendorMenu() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		VendorDAO vendordao = new VendorDAOimpl();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char choice;
		do {
			System.out.println("Vendor Menu :");
			System.out.println("1. Insert Vendor :");
			System.out.println("2. View Vendor :");
			System.out.println("3. View All Vendor :");
			System.out.println("4. Update Vendor :");
			System.out.println("5. Delete Vendor :");

			System.out.println("6. Return to Main Menu   :");

			System.out.println("Please Enter your Choice :");
			int ch = Integer.parseInt(br.readLine());

			switch (ch) {

			case 1: {
				// Employees employees = new Employees(emp_name,contact,department,doj);

				// System.out.println("Enter Employee Id :");
				// int emp_id = Integer.parseInt(br.readLine());
				System.out.println("Enter Vendor Name :");
				String vendor_name = br.readLine();
				System.out.println("Enter Contact :");
				String v_contact = br.readLine();
				System.out.println("Enter Address :");
				String v_address = br.readLine();

				Vendor vendor = new Vendor(vendor_name, v_contact, v_address);

				boolean res = vendordao.insertVendor(vendor);
				if (res)
					System.out.println("Vendor Created");
				else
					System.out.println("Something went wrong");
				break;
			}

			case 2: {
				System.out.println("Enter Vendor Id :");
				int vendor_id = Integer.parseInt(br.readLine());
				Vendor vendor = vendordao.viewVendorById(vendor_id);
				if (vendor == null) {
					System.out.println("Vendor with this id does not exist :");
					break;
				}
				System.out.println(vendor);
				break;
			}
			case 3: {
				List<Vendor> vlist = vendordao.viewAllVendor();
				if (vlist == null) {
					System.out.println("There is no Vendor stored in system :");
					break;
				}
				for (Vendor ven : vlist) {
					System.out.println(ven);
				}
				break;
			}

			case 4: {
				System.out.println("Enter Vendor Id :");
				int vendor_id = Integer.parseInt(br.readLine());
				Vendor vendor = vendordao.viewVendorById(vendor_id);
				if (vendor == null) {
					System.out.println("Vendor with this id does not exist :");
					break;
				}

				System.out.println("Enter Vendor Name :");
				String vendor_name = br.readLine();
				System.out.println("Enter Contact :");
				String v_contact = br.readLine();
				System.out.println("Enter Address :");
				String v_address = br.readLine();

				vendor = new Vendor(vendor_name, v_contact, v_address);
				boolean res = vendordao.updateVendor(vendor);
				if (res)
					System.out.println("Vendor Updated");
				else
					System.out.println("Something went wrong");
				break;

			}
			case 5: {
				System.out.println("Enter Vendor Id :");
				int vendor_id = Integer.parseInt(br.readLine());
				Vendor vendor = vendordao.viewVendorById(vendor_id);
				if (vendor == null) {
					System.out.println("Vendor with this id does not exist :");
					break;
				}
				boolean res = vendordao.deleteVendor(vendor_id);
				if (res)
					System.out.println("Vendor Deleted");
				else
					System.out.println("Something went wrong");
				break;
			}

			case 6: {
				displayMainMenu();
				break;
			}

			default: {
				System.out.println("Please enter a valid choice :");
				System.out.println("Please Enter your Choice :");
				ch = Integer.parseInt(br.readLine());
			}

			}
			System.out.println("Do you want to continue (y/n):");
			choice = br.readLine().charAt(0);
		} while (choice == 'y' || choice == 'Y');

	}

	private void displayPayment_methodMenu() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Payment_methodDAO payment_methoddao = new Payment_methodDAOimpl();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char choice;
		do {
			System.out.println("Expense Type Menu :");
			System.out.println("1. Insert Payment_method :");
			System.out.println("2. View Payment_method :");
			System.out.println("3. View All Payment_method :");

			System.out.println("4. Return to Main Menu   :");

			System.out.println("Please Enter your Choice :");
			int ch = Integer.parseInt(br.readLine());

			switch (ch) {

			case 1: {
				// Employees employees = new Employees(emp_name,contact,department,doj);

				System.out.println("Enter Payment_method Name :");
				String pm_name = br.readLine();

				System.out.println("Enter Payment_method Description :");
				String pm_description = br.readLine();

				Payment_method pmethod = new Payment_method(pm_name, pm_description);

				boolean res = payment_methoddao.insertPayment_method(pmethod);
				if (res)
					System.out.println("Payment_method Created");
				else
					System.out.println("Something went wrong");
				break;
			}

			case 2: {
				System.out.println("Enter Payment_method Id :");
				int pm_id = Integer.parseInt(br.readLine());
				Payment_method pmethod = payment_methoddao.viewPayment_methodById(pm_id);
				if (pmethod == null) {
					System.out.println("Payment_method with this id does not exist :");
					break;
				}
				System.out.println(pmethod);
				break;
			}
			case 3: {
				List<Payment_method> pmlist = payment_methoddao.viewAllPayment_method();
				// List<Expense_Category> viewAllExpense_Category();
				if (pmlist == null) {
					System.out.println("There is no Payment_method stored in system :");
					break;
				}
				for (Payment_method pm : pmlist) {
					System.out.println(pm);
				}
				break;
			}

			case 4: {
				displayMainMenu();
				break;
			}

			default: {
				System.out.println("Please enter a valid choice :");
				System.out.println("Please Enter your Choice :");
				ch = Integer.parseInt(br.readLine());
			}

			}
			System.out.println("Do you want to continue (y/n):");
			choice = br.readLine().charAt(0);
		} while (choice == 'y' || choice == 'Y');

	}

	private void displayExpense_typeMenu() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Expense_typeDAO expense_typedao = new Expense_typeDAOimpl();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char choice;
		do {
			System.out.println("Expense Type Menu :");
			System.out.println("1. Insert Expense Type :");
			System.out.println("2. View Expense Type :");
			System.out.println("3. View All Expense Type :");
			System.out.println("4. Update Expense Type :");
			System.out.println("5. Delete Expense Type :");

			System.out.println("6. Return to Main Menu   :");

			System.out.println("Please Enter your Choice :");
			int ch = Integer.parseInt(br.readLine());

			switch (ch) {

			case 1: {
				// Employees employees = new Employees(emp_name,contact,department,doj);

				System.out.println("Enter Expense Type Name :");
				String type_name = br.readLine();

				System.out.println("Enter Expense Type Description :");
				String t_description = br.readLine();

				Expense_type exptype = new Expense_type(type_name, t_description);

				boolean res = expense_typedao.insertType(exptype);
				if (res)
					System.out.println("Expense type Created");
				else
					System.out.println("Something went wrong");
				break;
			}

			case 2: {
				System.out.println("Enter Exp Type Id :");
				int type_id = Integer.parseInt(br.readLine());
				Expense_type exptype = expense_typedao.viewExpense_typeById(type_id);
				if (exptype == null) {
					System.out.println("Type with this id does not exist :");
					break;
				}
				System.out.println(exptype);
				break;
			}
			case 3: {
				List<Expense_type> typelist = expense_typedao.viewAllExpense_type();
				// List<Expense_Category> viewAllExpense_Category();
				if (typelist == null) {
					System.out.println("There is no type stored in system :");
					break;
				}
				for (Expense_type etype : typelist) {
					System.out.println(etype);
				}
				break;
			}

			case 4: {
				System.out.println("Enter Type Id :");
				int type_id = Integer.parseInt(br.readLine());
				Expense_type exptype = expense_typedao.viewExpense_typeById(type_id);
				if (exptype == null) {
					System.out.println("Type with this id does not exist :");
					break;
				}

				System.out.println("Enter Type Name :");
				String type_name = br.readLine();

				System.out.println("Enter Description :");
				String t_description = br.readLine();

				exptype = new Expense_type(type_name, t_description);
				boolean res = expense_typedao.updateExpense_type(exptype);
				if (res)
					System.out.println("Type Updated");
				else
					System.out.println("Something went wrong");
				break;

			}
			case 5: {
				System.out.println("Enter Type Id :");
				int type_id = Integer.parseInt(br.readLine());
				Expense_type exptype = expense_typedao.viewExpense_typeById(type_id);
				if (exptype == null) {
					System.out.println("Type with this id does not exist :");
					break;
				}
				boolean res = expense_typedao.deleteExpense_type(type_id);
				if (res)
					System.out.println("type Deleted");
				else
					System.out.println("Something went wrong");
				break;
			}

			case 6: {
				displayMainMenu();
				break;
			}

			default: {
				System.out.println("Please enter a valid choice :");
				System.out.println("Please Enter your Choice :");
				ch = Integer.parseInt(br.readLine());
			}

			}
			System.out.println("Do you want to continue (y/n):");
			choice = br.readLine().charAt(0);
		} while (choice == 'y' || choice == 'Y');

	}

	private void displayExpense_categoryMenu() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Expense_CategoryDAO expense_categorydao = new Expense_CategoryDAOimpl();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char choice;
		do {
			System.out.println("Expense Category Menu :");
			System.out.println("1. Insert Expense Category :");
			System.out.println("2. View Expense Category :");
			System.out.println("3. View All Expense Category :");
			System.out.println("4. Update Expense Category :");
			System.out.println("5. Delete Expense Category :");

			System.out.println("6. Return to Main Menu   :");

			System.out.println("Please Enter your Choice :");
			int ch = Integer.parseInt(br.readLine());

			switch (ch) {

			case 1: {
				// Employees employees = new Employees(emp_name,contact,department,doj);

				System.out.println("Enter Expense Category Name :");
				String category_name = br.readLine();

				System.out.println("Enter Expense Category Description :");
				String c_description = br.readLine();

				Expense_Category expcategory = new Expense_Category(category_name, c_description);

				boolean res = expense_categorydao.insertCategory(expcategory);
				if (res)
					System.out.println("Expense category Created");
				else
					System.out.println("Something went wrong");
				break;
			}

			case 2: {
				System.out.println("Enter Exp Category Id :");
				int category_id = Integer.parseInt(br.readLine());
				Expense_Category expcategory = expense_categorydao.viewExpense_CategoryById(category_id);
				if (expcategory == null) {
					System.out.println("Category with this id does not exist :");
					break;
				}
				System.out.println(expcategory);
				break;
			}
			case 3: {
				List<Expense_Category> categorylist = expense_categorydao.viewAllExpense_Category();
				// List<Expense_Category> viewAllExpense_Category();
				if (categorylist == null) {
					System.out.println("There is no category stored in system :");
					break;
				}
				for (Expense_Category ecategory : categorylist) {
					System.out.println(ecategory);
				}
				break;
			}

			case 4: {
				System.out.println("Enter Category Id :");
				int category_id = Integer.parseInt(br.readLine());
				Expense_Category expcategory = expense_categorydao.viewExpense_CategoryById(category_id);
				if (expcategory == null) {
					System.out.println("Category with this id does not exist :");
					break;
				}

				System.out.println("Enter Category Name :");
				String category_name = br.readLine();

				System.out.println("Enter Description :");
				String c_description = br.readLine();

				expcategory = new Expense_Category(category_name, c_description);
				boolean res = expense_categorydao.updateExpense_Category(expcategory);
				if (res)
					System.out.println("Category Updated");
				else
					System.out.println("Something went wrong");
				break;

			}
			case 5: {
				System.out.println("Enter Category Id :");
				int category_id = Integer.parseInt(br.readLine());
				Expense_Category expcategory = expense_categorydao.viewExpense_CategoryById(category_id);
				if (expcategory == null) {
					System.out.println("Category with this id does not exist :");
					break;
				}
				boolean res = expense_categorydao.deleteExpense_Category(category_id);
				if (res)
					System.out.println("Category Deleted");
				else
					System.out.println("Something went wrong");
				break;
			}

			case 6: {
				displayMainMenu();
				break;
			}

			default: {
				System.out.println("Please enter a valid choice :");
				System.out.println("Please Enter your Choice :");
				ch = Integer.parseInt(br.readLine());
			}

			}
			System.out.println("Do you want to continue (y/n):");
			choice = br.readLine().charAt(0);
		} while (choice == 'y' || choice == 'Y');

	}

	private void displayExpensesMenu() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		ExpensesDAO expensesdao = new ExpensesDAOimpl();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char choice;
		do {
			System.out.println("Expenses Menu :");
			System.out.println("1. Insert Expenses :");
			System.out.println("2. View Expenses :");
			System.out.println("3. View All Expenses :");
//			System.out.println("4. Update Expenses :");
//			System.out.println("5. Delete Expenses :");

			System.out.println("4. Return to Main Menu   :");

			System.out.println("Please Enter your Choice :");
			int ch = Integer.parseInt(br.readLine());

			switch (ch) {

			case 1: {
				// Employees employees = new Employees(emp_name,contact,department,doj);

				// System.out.println("Enter Employee Id :");
				// int emp_id = Integer.parseInt(br.readLine());
				System.out.println("Enter Employee Id :");
				int emp_id = Integer.parseInt(br.readLine());
				System.out.println("Enter Category Id :");
				int category_id = Integer.parseInt(br.readLine());
				System.out.println("Enter Type Id :");
				int type_id = Integer.parseInt(br.readLine());
				System.out.println("Enter Vendor Id :");
				int vendor_id = Integer.parseInt(br.readLine());
				System.out.println("Enter Payment Id Id :");
				int pm_id = Integer.parseInt(br.readLine());
				System.out.println("Enter Amount :");
				double amount = Double.parseDouble(br.readLine());
				System.out.println("Enter Date of expense(yyyy-mm-dd) :");
				Date exp_date = Date.valueOf(br.readLine());
				System.out.println("Enter Expense Description :");
				String exp_description = br.readLine();



				Expenses expenses = new Expenses(emp_id, category_id, type_id, vendor_id, pm_id, amount, exp_date,
						exp_description);

				boolean res = expensesdao.insertExpenses(expenses);
				if (res)
					System.out.println("Expenses Created");
				else
					System.out.println("Something went wrong");
				break;
			}

			case 2: {
				System.out.println("Enter Expense Id :");
				int exp_id = Integer.parseInt(br.readLine());
				Expenses expenses = expensesdao.viewExpensesById(exp_id);
				if (expenses == null) {
					System.out.println("Expenses with this id does not exist :");
					break;
				}
				System.out.println(expenses);
				break;
			}
			case 3: {
				List<Expenses> explist = expensesdao.viewAllExpenses();
				if (explist == null) {
					System.out.println("There is no expenses stored in system :");
					break;
				}
				for (Expenses exp : explist) {
					System.out.println(exp);
				}
				break;
			}

			/*
			 * case 4: { System.out.println("Enter expenses Id :"); int exp_id =
			 * Integer.parseInt(br.readLine()); Employees employees =
			 * employeesdao.viewEmployeesById(emp_id); if (employees == null) {
			 * System.out.println("Employee with this id does not exist :"); break; }
			 * 
			 * System.out.println("Enter Employee Name :"); String emp_name = br.readLine();
			 * System.out.println("Enter Contact :"); String contact = br.readLine();
			 * System.out.println("Enter Department :"); String department = br.readLine();
			 * System.out.println("Enter Date of joining :"); Date doj =
			 * Date.valueOf(br.readLine());
			 * 
			 * employees = new Employees(emp_name, contact, department, doj); boolean res =
			 * employeesdao.updateEmployees(employees); if (res)
			 * System.out.println("Employee Updated"); else
			 * System.out.println("Something went wrong"); break;
			 * 
			 * } case 5: { System.out.println("Enter Employee Id :"); int emp_id =
			 * Integer.parseInt(br.readLine()); Employees employees =
			 * employeesdao.viewEmployeesById(emp_id); if (employees == null) {
			 * System.out.println("Employee with this id does not exist :"); break; }
			 * boolean res = employeesdao.deleteEmployees(emp_id); if (res)
			 * System.out.println("Employee Deleted"); else
			 * System.out.println("Something went wrong"); break; }
			 */
			case 4: {
				displayMainMenu();
				break;
			}

			default: {
				System.out.println("Please enter a valid choice :");
				System.out.println("Please Enter your Choice :");
				ch = Integer.parseInt(br.readLine());
			}

			}
			System.out.println("Do you want to continue (y/n):");
			choice = br.readLine().charAt(0);
		} while (choice == 'y' || choice == 'Y');

	}

	private void displayEmployeesMenu() throws NumberFormatException, IOException {

		EmployeesDAO employeesdao = new EmployeesDAOimpl();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char choice;
		do {
			System.out.println("Employees Menu :");
			System.out.println("1. Insert Employee :");
			System.out.println("2. View Employee :");
			System.out.println("3. View All Employees :");
			System.out.println("4. Update Employee :");
			System.out.println("5. Delete Employee :");

			System.out.println("6. Return to Main Menu   :");

			System.out.println("Please Enter your Choice :");
			int ch = Integer.parseInt(br.readLine());

			switch (ch) {

			case 1: {
				// Employees employees = new Employees(emp_name,contact,department,doj);

				// System.out.println("Enter Employee Id :");
				// int emp_id = Integer.parseInt(br.readLine());
				System.out.println("Enter Employee Name :");
				String emp_name = br.readLine();
				System.out.println("Enter Contact :");
				String contact = br.readLine();
				System.out.println("Enter Department :");
				String department = br.readLine();
				System.out.println("Enter Date of joining(yyyy-mm-dd) :");
				Date doj = Date.valueOf(br.readLine());

				Employees employees = new Employees(emp_name, contact, department, doj);

				boolean res = employeesdao.insertEmployees(employees);
				if (res)
					System.out.println("Employees Created");
				else
					System.out.println("Something went wrong");
				break;
			}

			case 2: {
				System.out.println("Enter Employee Id :");
				int emp_id = Integer.parseInt(br.readLine());
				Employees employees = employeesdao.viewEmployeesById(emp_id);
				if (employees == null) {
					System.out.println("Employee with this id does not exist :");
					break;
				}
				System.out.println(employees);
				break;
			}
			case 3: {
				List<Employees> emplist = employeesdao.viewAllEmployees();
				if (emplist == null) {
					System.out.println("There is no employee stored in system :");
					break;
				}
				for (Employees emp : emplist) {
					System.out.println(emp);
				}
				break;
			}

			case 4: {
				System.out.println("Enter Employee Id :");
				int emp_id = Integer.parseInt(br.readLine());
				Employees employees = employeesdao.viewEmployeesById(emp_id);
				if (employees == null) {
					System.out.println("Employee with this id does not exist :");
					break;
				}

				System.out.println("Enter Employee Name :");
				String emp_name = br.readLine();
				System.out.println("Enter Contact :");
				String contact = br.readLine();
				System.out.println("Enter Department :");
				String department = br.readLine();
				System.out.println("Enter Date of joining :");
				Date doj = Date.valueOf(br.readLine());

				employees = new Employees(emp_name, contact, department, doj);
				boolean res = employeesdao.updateEmployees(employees);
				if (res)
					System.out.println("Employee Updated");
				else
					System.out.println("Something went wrong");
				break;

			}
			case 5: {
				System.out.println("Enter Employee Id :");
				int emp_id = Integer.parseInt(br.readLine());
				Employees employees = employeesdao.viewEmployeesById(emp_id);
				if (employees == null) {
					System.out.println("Employee with this id does not exist :");
					break;
				}
				boolean res = employeesdao.deleteEmployees(emp_id);
				if (res)
					System.out.println("Employee Deleted");
				else
					System.out.println("Something went wrong");
				break;
			}

			case 6: {
				displayMainMenu();
				break;
			}

			default: {
				System.out.println("Please enter a valid choice :");
				System.out.println("Please Enter your Choice :");
				ch = Integer.parseInt(br.readLine());
			}

			}
			System.out.println("Do you want to continue (y/n):");
			choice = br.readLine().charAt(0);
		} while (choice == 'y' || choice == 'Y');

	}

}
