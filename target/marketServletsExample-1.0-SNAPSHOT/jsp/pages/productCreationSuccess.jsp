<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title><%= request.getServletContext().getInitParameter("htmlTitleSuffix") %></title>
</head>
<body>
<h1>Product was succesfully crated!</h1>
<br/>

<jsp:include page="layout/footer.jsp" />
</body>
</html>