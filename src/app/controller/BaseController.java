package app.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import app.utils.Context;

public class BaseController {
    
    protected Context context;
    protected Connection conn;
    
    BaseController() {
        context = new Context();
        conn = context.getConnection();
    }

    public boolean executeUpdate(String sql) {
        try {
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            return result.rowUpdated();

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean executeDelete(String sql) {
        try {
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            return result.rowDeleted();

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}