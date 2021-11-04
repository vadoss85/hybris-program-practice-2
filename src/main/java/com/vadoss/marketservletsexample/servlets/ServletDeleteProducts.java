package com.vadoss.marketservletsexample.servlets;

import com.vadoss.marketservletsexample.entities.ProductEntity;
import com.vadoss.marketservletsexample.providers.DataProvider;
import com.vadoss.marketservletsexample.providers.ProductDataProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

public class ServletDeleteProducts extends DBConnectedServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        if (productId == null) {
            request.setAttribute("product", null);
        } else {
            DataProvider<ProductEntity> productDataProvider = new ProductDataProvider(connection);
            try {
                ProductEntity product = productDataProvider.findOne(Integer.parseInt(productId));

                if (product != null) {
                    request.setAttribute("product", product);
                } else {
                    response.sendRedirect(request.getContextPath() + "/jsp/pages/product404.jsp");
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        getServletContext().getRequestDispatcher("/jsp/pages/deleteProductConfirmDialog.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        String password = request.getParameter("password");

        if (!password.equals("pass")) {
            redirectToErrorPage(request, response);
            return;
        }

        DataProvider<ProductEntity> provider = new ProductDataProvider(connection);

        try {
            if (productId != null) {
                if (provider.deleteOne(Integer.parseInt(productId))) {
                    redirectToSuccessPage(request, response);
                    return;
                }

                redirectToErrorPage(request, response);

                return;
            }

            provider.deleteAll();
            redirectToSuccessPage(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void redirectToErrorPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("error");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void redirectToSuccessPage(HttpServletRequest request, HttpServletResponse response) {
        try {
//            response.sendRedirect(request.getContextPath() + "/jsp/pages/successDelete.jsp");
            response.sendRedirect("success-delete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
