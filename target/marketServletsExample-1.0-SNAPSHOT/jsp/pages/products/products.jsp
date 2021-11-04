<%@ page import="com.vadoss.marketservletsexample.entities.ProductEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style>
    table.products {
        border: 1px solid #aaa;
        border-collapse: collapse
    }
    table.products td {
        border-bottom: 1px solid #aaa;
        border-right: 1px solid #aaa;
        padding: 10px 15px;
    }
</style>
<%
    List<ProductEntity> products = (List) request.getAttribute("products");

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
    out.println("Price");
    out.println("</th>");
    out.println("<th>");
    out.println("Status");
    out.println("</th>");
    out.println("<th>");
    out.println("Date crated");
    out.println("</th>");
    out.println("<th>");
    out.println("</th>");
    out.println("<th>");
    out.println("</th>");
    out.println("</tr>");
    out.println("</thead>");

    for (ProductEntity product: products) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM, yyyy, hh:mm");
        String name = product.getName();
        int price = product.getPrice();
        int id = product.getId();
        String status = product.getStatus().toString();
        String date = dtf.format(product.getCreationDate());

        out.println("<tr style='border: 1px solid #aaa'>");
        out.println("<td>" + id + "</td>");
        out.println("<td><a href='product?id=" + id + "'>" + name + "</a></td>");
        out.println("<td>" + price + "$</td>");
        out.println("<td>" + status + "</td>");
        out.println("<td>" + date + "</td>");
        out.println("<td><a href='create-order?productId=" + id + "'>Buy<a/></td>");
        out.println("<td><a href='delete-product?productId=" + id + "'>Delete<a/></td>");
        out.println("</tr>");
    }
    out.println("</table>");
%>
