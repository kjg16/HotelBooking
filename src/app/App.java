package app;

import app.data.Hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(final String[] args) throws Exception {
        System.out.println("Hello Java");
        final String dbURL = "jdbc:mysql://localhost:3306/HotelBookingDB";
        final String username = "root";
        final String password = "GmDm7Add9";

        System.out.printf("%s, %s, %s\n", username, dbURL, password);

        Hotel h = new Hotel();
        h.setName("Hótel Höfn");
        h.setId(11);
        h.setDescription("æði");
        h.setUrl("http://ruv.is");
        System.out.println(h.GetInfo());
        
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            final Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (final SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}