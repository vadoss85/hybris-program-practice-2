<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title><%= request.getServletContext().getInitParameter("htmlTitlePageProductsList") + " | " + request.getServletContext().getInitParameter("htmlTitleSuffix") %></title>
</head>
<body>
<h1>Ordered products list:</h1>
<br/>
<p>All products, which have been ordered at least once, with total ordered quantity sorted descending by the quantity.</p>
<jsp:include page="products/orderedProducts.jsp" />
<br/>
<jsp:include page="layout/footer.jsp" />
</body>
</html>