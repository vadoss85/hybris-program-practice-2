package com.vadoss.marketservletsexample.servlets;

import com.vadoss.marketservletsexample.entities.ProductEntity;
import com.vadoss.marketservletsexample.providers.DataProvider;
import com.vadoss.marketservletsexample.providers.ProductDataProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Random;

public class ServletCreateOrder extends DBConnectedServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        try {
            DataProvider<ProductEntity> provider = new ProductDataProvider(connection);
//            PreparedStatement statement =  connection.prepareStatement("select * from products where id=?");

//            statement.setInt(1, Integer.parseInt(productId));

//            ResultSet result = statement.executeQuery();

            ProductEntity product = provider.findOne(Integer.parseInt(productId));

            if (product != null) {
                request.setAttribute("product", product);
                getServletContext().getRequestDispatcher("/jsp/pages/order.jsp").forward(request, response);

                return;
            }

//            if (result.next()) {
//                ProductEntity product = new ProductEntity(
//                        result.getInt(1),
//                        result.getString(2),
//                        result.getInt(3)
//                );
//
//                request.setAttribute("product", product);
//                getServletContext().getRequestDispatcher("/jsp/pages/order.jsp").forward(request, response);
//                return;
//            }
            response.sendRedirect("error");
//            getServletContext().getRequestDispatcher("/jsp/pages/error.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String status = "some status";
            Random rand = new Random();
            int userId = rand.nextInt() & Integer.MAX_VALUE;

            System.out.println(productId + ", " + quantity + ", " + userId);

            PreparedStatement orderStatement = connection.prepareStatement(
                    "INSERT orders(user_id, status, created_at) VALUES(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            orderStatement.setInt(1, userId);
            orderStatement.setString(2, status);
            orderStatement.setString(3, this.getCurrentTime());

            orderStatement.executeUpdate();

            ResultSet result = orderStatement.getGeneratedKeys();

            if (result.next()) {
                int orderId = result.getInt(1);

                int orderItemCreationResult = crateOrderItem(
                        orderId,
                        productId,
                        quantity
                );

                if (orderItemCreationResult > 0) {
                    response.sendRedirect( request.getContextPath() + "/orders");
                }

            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect( request.getContextPath() + "/jsp/pages/error.jsp");
        }
    }

    private int crateOrderItem(int orderId, int productId, int quantity) throws SQLException {
        PreparedStatement orderItemStatement = connection.prepareStatement(
                "INSERT order_items (order_id, product_id, quantity) VALUES(?, ?, ?)"
        );
        orderItemStatement.setInt(1, orderId);
        orderItemStatement.setInt(2, productId);
        orderItemStatement.setInt(3, quantity);

        return orderItemStatement.executeUpdate();
    }
}
