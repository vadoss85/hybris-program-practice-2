<%@ page import="com.vadoss.marketservletsexample.entities.ProductEntity" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title><%= request.getServletContext().getInitParameter("htmlTitleSuffix") %></title>
</head>
<body>
<form action="delete-product" method="post">
  <%
    ProductEntity product = (ProductEntity) request.getAttribute("product");
    if(product == null) {
  %>
  <h1>Delete all products?</h1>
    <br />
    <input name="password" type="password" placeholder="Enter password (pass)" />
  <button type="submit">Delete all</button>
  <%
    } else {
  %>
    <h1>Delete product?</h1>
  <table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
    </tr>
  </table>
    <br />
    <input name="productId" hidden value="<%= product.getId() %>" />
    <input name="password" type="password" placeholder="Enter password (pass)" />
  <button type="submit">Delete product</button>
  <%
    }
  %>
</form>
<br/>
<jsp:include page="layout/footer.jsp" />
</body>
</html>