package com.vadoss.marketservletsexample.providers;

import java.sql.SQLException;
import java.util.List;

public interface DataProvider<T> {
    T findOne(int id) throws SQLException;
    List<T> get() throws SQLException;
    boolean deleteOne(int id) throws SQLException;
    boolean deleteAll() throws SQLException;
}
