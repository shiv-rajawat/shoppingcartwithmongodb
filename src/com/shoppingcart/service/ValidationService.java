package com.shoppingcart.service;
import com.shoppingcart.dao.LoginDAO;
import com.shoppingcart.model.Customer;

public class ValidationService {

	
	LoginDAO loginDAO = new LoginDAO();

	public boolean validation(Customer customer) {
		boolean status = false;
		status = loginDAO.validateUser(customer);
		return status;
	}
	
}
