package com.shoppingcart.dao;
import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.shoppingcart.model.Customer;

public class LoginDAO {

	public boolean validateUser(Customer customer){  
		boolean status=false; 
			
		try{  
				
			 MongoClient mongoClient=new MongoClient();
			 
			 MongoDatabase mongoDatabase = mongoClient.getDatabase("cochin");
			 MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("UserDetail");
			 FindIterable<Document> docs = mongoCollection.find();
			 
			 
			 for(Document doc : docs) {
				    //access documents e.g. doc.get()
				
				 String name=(String) doc.get("userName");
				 String password=(String) doc.get("userPassword");

				 
				 
            if(name.equalsIgnoreCase(customer.getName())& password.equalsIgnoreCase(customer.getPassword()))
		                status=true;
		            }
		  
		}
		catch(Exception e){
			System.out.println(e);
		}

		return status;  
}
}
