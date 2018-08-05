package com.shoppingcart.service;

import java.sql.SQLException;
import java.util.*;

import com.shoppingcart.dao.ProductManagerDAO;
import com.shoppingcart.model.Product;

public class ProductsService {


	ProductManagerDAO pm=new ProductManagerDAO();

	public List<Product> selectAllProducts() throws SQLException {
		return pm.listProducts();

	}

	
	
}
