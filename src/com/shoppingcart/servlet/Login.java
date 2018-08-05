package com.shoppingcart.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoppingcart.model.Customer;
import com.shoppingcart.service.ValidationService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher rd=request.getRequestDispatcher("Product.jsp");  
	        rd.forward(request,response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    
	    String name=request.getParameter("username");  
	    String password=request.getParameter("userpass");  
	    
	    Customer customer=new Customer();
	    customer.setName(name);
	    customer.setPassword(password);
	   
	    
	   
	    ValidationService validationService=new ValidationService();
	  
	     
	    if(validationService.validation(customer)){  
	    	HttpSession session=request.getSession();
	    	session.setAttribute("user", name);
	    	session.setMaxInactiveInterval(10);
	    	
	        RequestDispatcher requestDispatcher=request.getRequestDispatcher("ProductServlet");  
	        requestDispatcher.forward(request,response);  
	    }  
	    else{
	    	
	        out.print("Sorry username or password error");
	        RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");  
	        requestDispatcher.include(request,response);  
	    }
	}

}
