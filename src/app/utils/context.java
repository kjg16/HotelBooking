package app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class Context {
    // private final String CONST_USERSESSION = "HotelBooking.UserSession";
    // private final String CONST_USERSESSIONCOOKIE = "HotelBooking.UserSessionGUIDCookie";
    // private final String CONST_SESSIONRESET = "HotelBooking.SessionReset";
    private final String dbURL = "jdbc:mysql://localhost:3306/HotelBookingDB";
    private final String username = "root";
    private final String password = "GmDm7Add9";


//    private User currentUser;
//    private HttpContext context = HttpContext.Current;
    private Connection conn;
    // static private String _query;
    // static private Map<String, Boolean> _searchFilter;
    // static private Boolean _showFilters;
    // static private int _currentSafn;

    public Connection getConnection() {

        System.out.printf("%s, %s, %s\n", username, dbURL, password);

        if (conn == null) {
            try {
                conn = DriverManager.getConnection(dbURL, username, password);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }

}