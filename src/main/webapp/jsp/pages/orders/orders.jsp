<%@ page import="com.vadoss.marketservletsexample.entities.ProductEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.vadoss.marketservletsexample.entities.OrderEntity" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style>
    table.products {
        border: 1px solid #aaa;
        border-collapse: collapse
    }
    table.products td, table.products th {
        border-bottom: 1px solid #aaa;
        border-right: 1px solid #aaa;
        padding: 10px 15px;
    }
</style>
<%
    List<OrderEntity> orders = (List) request.getAttribute("orders");

    out.println("<table class='products' style='border: 1px solid #aaa'>");
    out.println("<thead style='border: 1px solid #aaa'>");
    out.println("<tr>");
    out.println("<th>");
    out.println("ID");
    out.println("</th>");
    out.println("<th>");
    out.println("Name");
    out.println("</th>");
    out.println("<th>");
    out.println("Total price");
    out.println("</th>");
    out.println("<th>");
    out.println("Quantity");
    out.println("</th>");
    out.println("<th>");
    out.println("Date crated");
    out.println("</th>");
    out.println("</tr>");
    out.println("</thead>");

    for (OrderEntity order: orders) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM, yyyy, hh:mm");
        String name = order.getName();
        int total = order.getTotal();
        int quantity = order.getQuantity();
        int id = order.getId();
        String date = dtf.format(order.getCreationDate());

        out.println("<tr style='border: 1px solid #aaa'>");
        out.println("<td><a href='orders?id=" + id + "'>" + id + "</a></td>");
        out.println("<td>" + name + "</td>");
        out.println("<td>" + total + "$</td>");
        out.println("<td>" + quantity + "</td>");
        out.println("<td>" + date + "</td>");
        out.println("</tr>");
    }
    out.println("</table>");
%>
