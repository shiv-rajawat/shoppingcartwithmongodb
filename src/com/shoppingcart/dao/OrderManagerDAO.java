package com.shoppingcart.dao;

import java.sql.SQLException;
import java.util.*;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.shoppingcart.model.Cart;
import com.shoppingcart.model.Product;

public class OrderManagerDAO {
	
	
	public void insertOrders(Cart cart) throws SQLException {
		
		try {
			MongoClient mongoClient=new MongoClient("localhost",27017);
			 MongoDatabase mongoDatabase = mongoClient.getDatabase("cochin");
			 MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("OrderDetails");
			 FindIterable<Document> docs = mongoCollection.find();
			 Document document=new Document();
			 document.append("OID",  cart.getOID());
			 document.append("PNama",cart.getPNama());
			 document.append("TotalPrice",cart.getTotalPrice());
			 mongoCollection.insertOne(document);     
		} 
	  catch (Exception e) { 	
		System.out.println("cannot insert orders");
		e.printStackTrace();
	}
	}
	
	 public List<Cart> displayOrder() throws SQLException {

		List<Cart> list=new ArrayList<Cart>();
		try {
			
			 MongoClient mongoClient=new MongoClient("localhost",27017);
			 MongoDatabase mongoDatabase = mongoClient.getDatabase("cochin");
			 MongoCollection<Document> coll = mongoDatabase.getCollection("OrderDetails");
			 FindIterable<Document> docs = coll.find();
			 for(Document doc : docs) {
					Cart cart=new Cart();	
					 int oId=(int) doc.get("OID");
						 String pName=(String) doc.get("PNama");
						 int price=(int) doc.get("TotalPrice");
						 cart.setOID(oId);
						 cart.setPNama(pName);
						 cart.setTotalPrice(price); 
				         list.add(cart);				
				  }
			 
		
			
			
		} catch (Exception e) {
			System.out.println("Error in displaying");
			e.printStackTrace();

		} 
		
		return list;
	}
	 
		public void clearOrders() {
			// TODO Auto-generated method stub
			try{  
				MongoClient mongo=new MongoClient("localhost",27017);
				 MongoDatabase mydatabase = mongo.getDatabase("cochin");
				 MongoCollection<Document> coll = mydatabase.getCollection("OrderDetails");
				  coll.drop();		
				}catch(Exception e){
					System.out.println("orders cleared");
				}  
			
		} 
	 



	
}
