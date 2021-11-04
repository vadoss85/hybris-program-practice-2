package com.vadoss.marketservletsexample.providers;

import com.vadoss.marketservletsexample.entities.OrderedProductEntity;
import com.vadoss.marketservletsexample.entities.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderedProductDataProvider extends AbstractDataProvider<OrderedProductEntity> {
    public OrderedProductDataProvider(Connection connection) {
        super(connection);
    }

    @Override
    public OrderedProductEntity findOne(int id) throws SQLException {
        return null;
    }

    @Override
    public List get() throws SQLException {
        final String sqlCommand = "SELECT p.id, p.name, SUM(oi.quantity) total FROM order_items oi INNER JOIN products p on p.id = oi.product_id GROUP BY oi.product_id ORDER BY total DESC";
        List<OrderedProductEntity> products = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement(sqlCommand);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            products.add(getEntityFromResult(result));
        }

        return products;
    }

    @Override
    public boolean deleteOne(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteAll() throws SQLException {
        return false;
    }

    private OrderedProductEntity getEntityFromResult(ResultSet result) throws SQLException {
        int id = result.getInt(1);
        String name = result.getString(2);
        int quantity = result.getInt(3);
        return new OrderedProductEntity(id, name, quantity);
    }
}
