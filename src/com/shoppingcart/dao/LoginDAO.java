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

	public boolean validateUser(Customer c){  
		boolean status=false; 
			
		try{  
			 MongoClient mongo=new MongoClient("localhost",27017);
			 MongoDatabase mydatabase = mongo.getDatabase("cochin");
			 MongoCollection<Document> coll = mydatabase.getCollection("UserDetail");
			 FindIterable<Document> docs = coll.find();
			 
			 
			 for(Document doc : docs) {
				    //access documents e.g. doc.get()
				
				 String name=(String) doc.get("userName");
				 String password=(String) doc.get("userPassword");
				 System.out.println(c.getName());
				 System.out.println(name);
		         System.out.println(password);
		            if(name.equalsIgnoreCase(c.getName())& password.equalsIgnoreCase(c.getPassword()))
		                status=true;
				     
		       
		            }
		        /* while (cursor.hasNext()) {
		            DBObject obj = cursor.next();
		            String name=(String) obj.get("userName");
		            String password=(String) obj.get("userPassword");
		            System.out.println(name);
		            System.out.println(password);
		            if(name!=null)
		            	status=true;
		         }*/
		}
		catch(Exception e){
			System.out.println(e);
		}

		return status;  
}

	
}
