<%@ page import="com.vadoss.marketservletsexample.entities.ProductEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.vadoss.marketservletsexample.entities.OrderedProductEntity" %>
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
    List<OrderedProductEntity> products = (List) request.getAttribute("products");

    out.println("<table class='products' style='border: 1px solid #aaa'>");
    out.println("<thead style='border: 1px solid #aaa'>");
    out.println("<tr>");
    out.println("<th>");
    out.println("Product ID");
    out.println("</th>");
    out.println("<th>");
    out.println("Product Name");
    out.println("</th>");
    out.println("<th>");
    out.println("Total quantity ordered");
    out.println("</th>");
    out.println("</thead>");

    for (OrderedProductEntity product: products) {
        String name = product.getName();
        int quantity = product.getQuantity();
        int id = product.getProductId();

        out.println("<tr style='border: 1px solid #aaa'>");
        out.println("<td>" + id + "</td>");
        out.println("<td><a href='product?id=" + id + "'>" + name + "</a></td>");
        out.println("<td>" + quantity + "</td>");
        out.println("</tr>");
    }
    out.println("</table>");
%>

