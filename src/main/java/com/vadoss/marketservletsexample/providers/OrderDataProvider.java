package com.vadoss.marketservletsexample.providers;

import com.vadoss.marketservletsexample.entities.OrderEntity;
import com.vadoss.marketservletsexample.entities.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDataProvider extends AbstractDataProvider<OrderEntity> {
    String baseGetQuery = "SELECT o.id, (p.price * oi.quantity) total, p.name, oi.quantity, o.created_at FROM orders o LEFT JOIN order_items oi ON oi.order_id = o.id LEFT JOIN products p ON oi.product_id = p.id";
    public OrderDataProvider(Connection connection) {
        super(connection);
    }

    private OrderEntity getEntityFromResult(ResultSet result) throws SQLException {
        int id = result.getInt(1);
        int total = result.getInt(2);
        String name = result.getString(3);
        int quantity = result.getInt(4);
        String createdAt = result.getString(5);

        return new OrderEntity(id, total, name, quantity, createdAt);
    }

    @Override
    public OrderEntity findOne(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(baseGetQuery + " WHERE o.id=?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();


        if (!result.next()) {
            return null;
        }

        return getEntityFromResult(result);
    }

    @Override
    public List<OrderEntity> get() throws SQLException {
        List<OrderEntity> orders = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement(baseGetQuery + " ORDER BY o.id ASC");
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            orders.add(getEntityFromResult(result));
        }

        System.out.println(orders);

        return orders;
    }

    @Override
    public boolean deleteOne(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteAll() throws SQLException {
        return false;
    }
}
