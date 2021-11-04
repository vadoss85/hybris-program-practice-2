package com.vadoss.marketservletsexample.providers;

import com.vadoss.marketservletsexample.entities.ProductEntity;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDataProvider extends AbstractDataProvider<ProductEntity>{
    public ProductDataProvider(Connection connection) {
        super(connection);
    }

    private ProductEntity getEntityFromResult(ResultSet result) throws SQLException {
        int id = result.getInt(1);
        String name = result.getString(2);
        int price = result.getInt(3);
        String status = result.getString(4);
        String date = result.getString(5);

        return new ProductEntity(id, name, price, status, date);
    }

    @Override
    public ProductEntity findOne(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from products where id = ?");
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();
        if (!result.next()) {
            return null;
        }

        return getEntityFromResult(result);
    }

    @Override
    public List<ProductEntity> get() throws SQLException {
        List<ProductEntity> products = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement("select * from products");
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            products.add(getEntityFromResult(result));
        }

        return products;
    }

    @Override
    public boolean deleteOne(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id=? LIMIT 1");

        statement.setInt(1, id);

        int result = statement.executeUpdate();

        return result > 0;
    }

    @Override
    public boolean deleteAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM products");

        int result = statement.executeUpdate();

        return result > 0;
    }
}
