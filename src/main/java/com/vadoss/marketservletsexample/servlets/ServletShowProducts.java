package com.vadoss.marketservletsexample.servlets;

import com.vadoss.marketservletsexample.entities.ProductEntity;
import com.vadoss.marketservletsexample.providers.DataProvider;
import com.vadoss.marketservletsexample.providers.ProductDataProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServletShowProducts extends DBConnectedServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DataProvider<ProductEntity> dataProvider = new ProductDataProvider(connection);

            request.setAttribute("products", dataProvider.get());

            getServletContext().getRequestDispatcher("/jsp/pages/products.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
