package app.controller;

import java.sql.Connection;
import app.utils.Context;

public class BaseController {
    private Context c = new Context();
    private Connection connection = c.getConnection();
    
    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }
}