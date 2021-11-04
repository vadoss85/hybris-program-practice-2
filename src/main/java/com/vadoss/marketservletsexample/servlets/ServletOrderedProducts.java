package com.vadoss.marketservletsexample.servlets;

import com.vadoss.marketservletsexample.entities.OrderedProductEntity;
import com.vadoss.marketservletsexample.providers.DataProvider;
import com.vadoss.marketservletsexample.providers.OrderedProductDataProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet(name = "ServletOrderedProducts", value = "/ServletOrderedProducts")
public class ServletOrderedProducts extends DBConnectedServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().print("show ordered products");
        DataProvider<OrderedProductEntity> provider = new OrderedProductDataProvider(connection);

        try {
            List<OrderedProductEntity> products = provider.get();
            request.setAttribute("products", products);
            getServletContext().getRequestDispatcher("/jsp/pages/orderedProducts.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
