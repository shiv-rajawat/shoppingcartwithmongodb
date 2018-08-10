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
		List<Product> list = new ArrayList<>();
		try {
			 MongoClient mongoClient=new MongoClient("localhost",27017);
			 MongoDatabase mongoDatabase = mongoClient.getDatabase("cochin");
			 MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
			 FindIterable<Document> docs = mongoCollection.find();
			 
			 for(Document doc : docs) {
			 Product product=new Product();	
			     int pId=Integer.parseInt((String) doc.get("PID"));
				 String pName=(String) doc.get("PName");
				 int price=Integer.parseInt((String) doc.get("Price"));
				 product.setpName(pName);
				 product.setpPrice(price);
				 product.setpId(pId);
		         list.add(product);				
		         }
		} catch (Exception e) {
			System.out.println("failed to load products list");
			e.printStackTrace();
		} 
		return list;
	}
}
