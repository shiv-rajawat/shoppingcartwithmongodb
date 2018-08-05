package com.shoppingcart.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingcart.model.Cart;
import com.shoppingcart.service.OrderManagerService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			
			OrderManagerService oms=new OrderManagerService();
		    
	        try {
	        	List<Cart> arrC = new ArrayList<Cart>();
	        	arrC=oms.displayOrder();
				RequestDispatcher rd=request.getRequestDispatcher("Cart.jsp");
				rd.include(request,response);
			} catch (SQLException e) {
				System.out.println("cannot insert order");
				
				e.printStackTrace();
			} 
	        
		}

}
