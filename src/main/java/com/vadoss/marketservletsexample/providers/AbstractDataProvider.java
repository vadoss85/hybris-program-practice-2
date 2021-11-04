package com.vadoss.marketservletsexample.providers;

import java.sql.Connection;

public abstract class AbstractDataProvider<T> implements DataProvider<T> {
    Connection connection;

    public AbstractDataProvider(Connection connection) {
        this.connection = connection;
    }
}
