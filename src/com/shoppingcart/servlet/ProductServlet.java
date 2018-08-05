package com.shoppingcart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingcart.model.Cart;
import com.shoppingcart.model.Product;
import com.shoppingcart.service.OrderManagerService;
import com.shoppingcart.service.ProductsService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int OID = Integer.parseInt(request.getParameter("oid"));
		 String PNama =request.getParameter("Pname");
		 
	        int TotalPrice = Integer.parseInt(request.getParameter("price"));
	        
	        Cart c=new Cart();
	        c.setOID(OID);
	        c.setPNama(PNama);
	        c.setTotalPrice(TotalPrice);
	        OrderManagerService oms=new OrderManagerService();
	        
		    try {
				oms.insertOrder(c);
				RequestDispatcher rd=request.getRequestDispatcher("Product.jsp");
				rd.include(request,response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		    
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	    processRequest(request, response);
	}

	 public void processRequest(HttpServletRequest request, HttpServletResponse response)  
			    throws ServletException, IOException {  
			ProductsService ss=new ProductsService();   
	        try {
	        	List<Product> arrPro = new ArrayList<Product>();
				arrPro=ss.selectAllProducts();
				RequestDispatcher rd=request.getRequestDispatcher("Product.jsp");
				RequestDispatcher rd2=request.getRequestDispatcher("CartServlet");
				rd.include(request,response);
				
			} catch (SQLException e) {
				System.out.println("cannot list products");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
		}
}
