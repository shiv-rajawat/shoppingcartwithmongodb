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

	
	Cart c=new Cart();
	
	
	public void insertOrders(Cart c) throws SQLException {
		
		try {
			MongoClient mongo=new MongoClient("localhost",27017);
			 MongoDatabase mydatabase = mongo.getDatabase("cochin");
			 MongoCollection<Document> coll = mydatabase.getCollection("OrderDetails");
			 FindIterable<Document> docs = coll.find();
			 Document document=new Document();
			 document.append("OID",  c.getOID());
			 document.append("PNama",c.getPNama());
			 document.append("TotalPrice",c.getTotalPrice());
			 coll.insertOne(document);
			 /*
			 BasicDBObject docu = new BasicDBObject();
			 docu.put("OID", c.getOID());*/
		         
		} 
	  catch (Exception e) { 	
		System.out.println("cannot insert orders");
		e.printStackTrace();
	}
	}
	
	
	 public List<Cart> displayOrder() throws SQLException {

		List<Cart> arrC=new ArrayList<Cart>();
		try {
			
			MongoClient mongo=new MongoClient("localhost",27017);
			 MongoDatabase mydatabase = mongo.getDatabase("cochin");
			 MongoCollection<Document> coll = mydatabase.getCollection("OrderDetails");
			 FindIterable<Document> docs = coll.find();
			 for(Document doc : docs) {
					Cart cart=new Cart();	
					 int OID=(int) doc.get("OID");
						 String PName=(String) doc.get("PNama");
						 int Price=(int) doc.get("TotalPrice");
						 cart.setOID(OID);
						 cart.setPNama(PName);
						 cart.setTotalPrice(Price); 
				         arrC.add(cart);				
				  }
			 
		
			
			
		} catch (Exception e) {
			System.out.println("Error in displaying");
			e.printStackTrace();

		} 
		
		return arrC;
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
