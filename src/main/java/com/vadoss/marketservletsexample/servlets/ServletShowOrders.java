package com.vadoss.marketservletsexample.servlets;

import com.vadoss.marketservletsexample.entities.OrderEntity;
import com.vadoss.marketservletsexample.providers.DataProvider;
import com.vadoss.marketservletsexample.providers.OrderDataProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServletShowOrders extends DBConnectedServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataProvider<OrderEntity> provider = new OrderDataProvider(connection);
        String orderId = request.getParameter("id");

        if (orderId != null) {
            getServletContext().getRequestDispatcher("/order").forward(request, response);
            return;
        }

        try {
            request.setAttribute("orders", provider.get());
            getServletContext().getRequestDispatcher("/jsp/pages/orders.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
