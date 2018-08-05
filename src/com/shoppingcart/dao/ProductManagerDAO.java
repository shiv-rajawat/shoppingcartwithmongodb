package com.shoppingcart.dao;

import java.sql.SQLException;
import java.util.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.shoppingcart.model.Product;

public class ProductManagerDAO {
	
	
	public List<Product> listProducts() throws SQLException {

		List<Product> pArrList = new ArrayList<>();

		try {
			
			 MongoClient mongo=new MongoClient("localhost",27017);
			 MongoDatabase mydatabase = mongo.getDatabase("cochin");
			 MongoCollection<Document> coll = mydatabase.getCollection("products");
			 FindIterable<Document> docs = coll.find();
			 
			 for(Document doc : docs) {
			Product product=new Product();	
			     int PID=Integer.parseInt((String) doc.get("PID"));
				 String PName=(String) doc.get("PName");
				 int Price=Integer.parseInt((String) doc.get("Price"));
				 product.setpName(PName);
				 product.setpPrice(Price);
				 product.setpId(PID);
		         pArrList.add(product);				
		         }
			 
		} catch (Exception e) {
			
			System.out.println("failed to load products list");
			e.printStackTrace();
		} 
		return pArrList;
	}
}
