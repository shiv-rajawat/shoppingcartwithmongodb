package com.shoppingcart.service;

import java.sql.SQLException;
import java.util.*;

import com.shoppingcart.dao.OrderManagerDAO;
import com.shoppingcart.model.Cart;

public class OrderManagerService {
	
	
	OrderManagerDAO OD=new OrderManagerDAO();
	public List<Cart> displayOrder() throws SQLException {
		return OD.displayOrder();

	}
	
	public void insertOrder(Cart c) throws SQLException {
		OD.insertOrders(c);
	}
	
	public void deleteOrder() {
		   OD.clearOrders();
		}
	
}
