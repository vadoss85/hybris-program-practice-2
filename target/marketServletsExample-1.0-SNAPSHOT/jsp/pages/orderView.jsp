<%@ page import="com.vadoss.marketservletsexample.entities.OrderEntity" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title><%= request.getServletContext().getInitParameter("htmlTitleSuffix") %></title>
</head>
<body>
<h1>Show order:</h1>
<br/>
<%
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM, yyyy, hh:mm");
  OrderEntity order = (OrderEntity) request.getAttribute("order");
  String date = dtf.format(order.getCreationDate());
%>
<p><strong>Order id: </strong><%= order.getId()%></p>
<p><strong>Product name: </strong><%= order.getName()%></p>
<p><strong>Total price: </strong><%= order.getTotal()%>$</p>
<p><strong>Quantity: </strong><%= order.getQuantity()%></p>
<p><strong>Creation date: </strong><%= date%></p>
<jsp:include page="layout/footer.jsp" />
</body>
</html>