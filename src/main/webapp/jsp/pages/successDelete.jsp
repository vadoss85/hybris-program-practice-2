<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title><%= request.getServletContext().getInitParameter("htmlTitleSuffix") %></title>
  </head>
  <body>
    <h1>Product was successfully deleted!</h1>
    <jsp:include page="layout/footer.jsp" />
  </body>
</html>
