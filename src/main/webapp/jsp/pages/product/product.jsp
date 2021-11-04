<%@ page import="com.vadoss.marketservletsexample.entities.ProductStatuses" %>
<%
    String id = (String) request.getAttribute("id");
    String name = (String) request.getAttribute("name");
    String price = (String) request.getAttribute("price");
    String status = (String) request.getAttribute("status");
    boolean isEditAction = id.length() > 0;
%>
<%!
    public static boolean isSelectedStatus(String current, String target) {
        return current.equals(target);
    }
%>


<form action="product" method="post">
    <%
        if (isEditAction) {
    %>
    <strong><%= id %></strong>
    <input hidden name="id" value="<%= id %>" />
    <%
        }
    %>
    <input name="name" placeholder="Enter product name" value="<%= name %>" />
    <input name="price" placeholder="Enter product price" value="<%= price %>" />
    <select name="status">
        <%
            if(isSelectedStatus(status, ProductStatuses.IN_STOCK.status)) {
        %>
        <option selected value="<%= ProductStatuses.IN_STOCK %>">In Stock</option>
        <%
            } else {
        %>
        <option value="<%= ProductStatuses.IN_STOCK %>">In Stock</option>
        <%
            }
        %>

        <%
            if(isSelectedStatus(status, ProductStatuses.RUNNING_LOW.status)) {
        %>
        <option selected value="<%= ProductStatuses.RUNNING_LOW %>">Running low</option>
        <%
        } else {
        %>
        <option value="<%= ProductStatuses.RUNNING_LOW %>">Running low</option>
        <%
            }
        %>

        <%
            if(isSelectedStatus(status, ProductStatuses.OUT_OF_STOCK.status)) {
        %>
        <option selected value="<%= ProductStatuses.OUT_OF_STOCK %>">Out of stock</option>
        <%
        } else {
        %>
        <option value="<%= ProductStatuses.OUT_OF_STOCK %>">Out of stock</option>
        <%
            }
        %>
    </select>
    <%
        if (isEditAction) {
    %>
    <button type="submit">Apply changes</button>
    <%
        } else {
    %>
    <button type="submit">Create</button>
    <%
        }
    %>
</form>
