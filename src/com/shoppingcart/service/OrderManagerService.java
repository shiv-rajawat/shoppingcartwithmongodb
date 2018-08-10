package com.shoppingcart.service;

import java.sql.SQLException;
import java.util.*;

import com.shoppingcart.dao.OrderManagerDAO;
import com.shoppingcart.model.Cart;

public class OrderManagerService {
	
	
	OrderManagerDAO orderManagerDAO=new OrderManagerDAO();
	public List<Cart> displayOrder() throws SQLException {
		return orderManagerDAO.displayOrder();

	}
	
	public void insertOrder(Cart cart) throws SQLException {
		orderManagerDAO.insertOrders(cart);
	}
	
	public void deleteOrder() {
		   orderManagerDAO.clearOrders();
		}
	
}
