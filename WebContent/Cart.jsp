
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
    <%@page import="com.shoppingcart.servlet.*"%>
    <%@page import="com.shoppingcart.model.*"%>
    <%@page import="com.shoppingcart.service.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>

	 <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
    <input type="submit" value="Logout" />
</form>  

 <h1>Your Shopping Cart</h1>
        
        <%
        
        OrderManagerService oms=new OrderManagerService();
        List<Cart> arrC = oms.displayOrder();
        	int totalprice=0;
        %>
        
        <table border="1">
            <thead>
                <tr>
                    <th>OrderID</th>
                    <th>Price</th>
                    
                </tr>
            </thead>
            <tbody>
            
                <%  if (arrC != null) {
                	for (int i = 0; i < arrC.size(); i++){
                %>  
                <tr>
                    <td><%= arrC.get(i).getPNama() %></td>
                    <td><%= arrC.get(i).getTotalPrice()%></td>
                </tr>
                
             <% totalprice+=arrC.get(i).getTotalPrice(); %>
               
            <%
                }
                }
            %>
              
        </tbody>
    </table>
    <br>
    <br>
<h1>TotalPrice:<%= totalprice%></h1>
    <!-- <p><input type="submit" value="Confirm" value ="confirm" /></p> -->
    
     <p><a href="Login">go to product list</a></p>
     
     <form action="ConfirmationServlet" method="post">
    <input type="submit" value="Confirm" />
    </form>
     
     
</body>
</html>