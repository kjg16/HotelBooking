package app.controller;

import java.sql.Connection;
import app.utils.Context;

public class BaseController {
    protected Context context;
    protected Connection conn;
    
    BaseController() {
        context = new Context();
        conn = context.getConnection();

    }
}