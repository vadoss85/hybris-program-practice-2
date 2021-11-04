<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title><%= request.getServletContext().getInitParameter("htmlTitlePageProductsList") + " | " + request.getServletContext().getInitParameter("htmlTitleSuffix") %></title>
</head>
<body>
<h1>Orders list:</h1>
<br/>
<jsp:include page="orders/orders.jsp" />
<br/>
<jsp:include page="layout/footer.jsp" />
</body>
</html>