
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
<title>Insert title here</title>
</head>
<body>
	<%
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String userName = (String) session.getAttribute("user");
				out.print("Welcome " + userName );
			} else {
				out.print("session timeout");
				response.sendRedirect("index.jsp");
			}
		}
	%> 
	
 <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
    <input type="submit" value="Logout" />
</form>  
    
<form action="CartServlet" method="post">  

	   <%
  	   	ProductsService productsService = new ProductsService();
  	    List<Product> list = productsService.selectAllProducts();
  	              
  	   %>

        <h1>Available products</h1>
        <table border="1" align="center"> 
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                     <th>Action</th>
                </tr>
            </thead>
             <tbody>
                <%  if (list != null) {
                	for (int i = 0; i < list.size(); i++){
                %>
                <tr>
                    <td><%= list.get(i).getpId()%></td>
                    <td><%= list.get(i).getpName()%></td>
                    <td><%= list.get(i).getpPrice()%></td>
                    <td onclick="myFunction()"><a href="ProductServlet?oid=<%= list.get(i).getpId()%>&Pname=<%=list.get(i).getpName()%>&price=<%= list.get(i).getpPrice()%>">Buy</a></td>
                   
                </tr>
                
   
                <% }
                	
                    }%>
                    
            </tbody>
        </table>


<script>
function myFunction() {
  alert("done");
}
</script>

<input type="submit" value="GO TO CART"/>  
</form> 


</body>
</html>


