<%@ page import="com.vadoss.marketservletsexample.entities.ProductEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product editor</title>
  </head>
  <body>
    <form>
    <%
      ProductEntity product = (ProductEntity) request.getAttribute("product");
      if(!product) {

      }
    %>
    </form>
  </body>
</html>
