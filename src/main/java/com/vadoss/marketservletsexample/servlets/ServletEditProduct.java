package com.vadoss.marketservletsexample.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ServletEditProduct extends DBConnectedServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String id = request.getParameter("id");

        if (id == null) {
            request.setAttribute("id", "");
            request.setAttribute("name", "");
            request.setAttribute("price", "");
            request.setAttribute("status", "");
            getServletContext().getRequestDispatcher("/jsp/pages/product.jsp").forward(request, response);
            return;
        }

        try {
            PreparedStatement statement = connection.prepareStatement("select * from products where id = ?");

            statement.setInt(1, Integer.parseInt(id));

            ResultSet result = statement.executeQuery();
            if (!result.next()) {
                getServletContext().getRequestDispatcher("/jsp/pages/product404.jsp").forward(request, response);

                return;
            }

            request.setAttribute("id", result.getString(1));
            request.setAttribute("name", result.getString(2));
            request.setAttribute("price", result.getString(3));
            request.setAttribute("status", result.getString(4));
            getServletContext().getRequestDispatcher("/jsp/pages/product.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String id = request.getParameter("id");

        try {
            if (id == null) {
                createProduct(request, response);

                return;
            }

            updateProduct(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
//            getServletContext().getRequestDispatcher("/jsp/pages/error.jsp").forward(request, response);
            response.sendRedirect("error");
        }
    }

    private PreparedStatement prepare(String name, int price, String status) throws SQLException {
        final String date = getCurrentTime();
        PreparedStatement statement = connection.prepareStatement("insert into products (name, price, status, created_at) values(?,?,?,?)");
        statement.setString(1, name);
        statement.setInt(2, price);
        statement.setString(3, status);
        statement.setString(4, date);

        return statement;
    }
    private PreparedStatement prepare(String name, int price, String status, String id) throws SQLException {
        final String date = getCurrentTime();
        PreparedStatement statement = connection.prepareStatement("update products set name=?, price=?, status=?, created_at=? where id=? limit 1");
        statement.setString(1, name);
        statement.setInt(2, price);
        statement.setString(3, status);
        statement.setString(4, date);
        statement.setString(5, id);

        return statement;
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        final String name = request.getParameter("name");
        final String price = request.getParameter("price");
        final String status = request.getParameter("status");

        PreparedStatement statement = prepare(name, Integer.parseInt(price), status);

        int result = statement.executeUpdate();
        if (result > 0) {
            getServletContext().getRequestDispatcher("/jsp/pages/productCreationSuccess.jsp").forward(request, response);
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        final String id = request.getParameter("id");
        final String name = request.getParameter("name");
        final String price = request.getParameter("price");
        final String status = request.getParameter("status");

        PreparedStatement statement = prepare(name, Integer.parseInt(price), status, id);

        int result = statement.executeUpdate();
        if (result > 0) {
            getServletContext().getRequestDispatcher("/jsp/pages/productCreationSuccess.jsp").forward(request, response);
        }
    }
}
