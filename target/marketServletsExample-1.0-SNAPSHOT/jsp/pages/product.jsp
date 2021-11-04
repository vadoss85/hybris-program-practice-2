<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title><%= request.getServletContext().getInitParameter("htmlTitleSuffix") %></title>
</head>
<body>
<h1>Products list:</h1>
<br/>
<jsp:include page="product/product.jsp" />
<br/>
<jsp:include page="layout/footer.jsp" />
</body>
</html>