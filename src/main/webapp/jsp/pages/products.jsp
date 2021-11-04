<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title><%= request.getServletContext().getInitParameter("htmlTitlePageProductsList") + " | " + request.getServletContext().getInitParameter("htmlTitleSuffix") %></title>
</head>
<body>
<h1>Products list:</h1>
<br/>
<a href="delete-product">Delete all products</a>
<br/>
<br/>
<jsp:include page="products/products.jsp" />
<br/>
<jsp:include page="layout/footer.jsp" />
</body>
</html>