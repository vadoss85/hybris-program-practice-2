<%@ page import="com.vadoss.marketservletsexample.entities.ProductEntity" %>
<%
  ProductEntity product = (ProductEntity) request.getAttribute("product");
%>
<form method="post" action="create-order">
    <p><strong>Id:</strong> <%= product.getId()%></p>
    <p><strong>Product name:</strong> <%= product.getName()%></p>
    <p><strong>Product price:</strong> <%= product.getPrice()%></p>
    <p>
      <input name="quantity" placeholder="Enter quantity" value="" />
    </p>
  <input name="productId" value="<%= product.getId()%>" hidden />
  <button type="submit">Order</button>
</form>
