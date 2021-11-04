package com.vadoss.marketservletsexample.servlets;

import com.vadoss.marketservletsexample.entities.OrderEntity;
import com.vadoss.marketservletsexample.providers.DataProvider;
import com.vadoss.marketservletsexample.providers.OrderDataProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletShowOrder", value = "/ServletShowOrder")
public class ServletShowOrder extends DBConnectedServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("id");
        DataProvider<OrderEntity> provider = new OrderDataProvider(connection);

        try {
            OrderEntity order = provider.findOne(Integer.parseInt(orderId));

            if (order != null) {
                request.setAttribute("order", order);
                getServletContext().getRequestDispatcher("/jsp/pages/orderView.jsp").forward(request, response);
                return;
            }

            redirectToErrorPage(request, response);
        } catch (NumberFormatException | SQLException e) {
            redirectToErrorPage(request, response);
            e.printStackTrace();
        }
    }

    private void redirectToErrorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/pages/error.jsp").forward(request, response);
    }
}
