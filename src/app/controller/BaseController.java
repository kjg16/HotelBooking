package app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import app.utils.Context;

public class BaseController {
    
    protected Context context;
    
    BaseController() {
        context = new Context();
    }

    public boolean executeUpdate(String sql) {
        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            return result.rowUpdated();

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean executeDelete(String sql) {
        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            return result.rowDeleted();

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}