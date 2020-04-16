package app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.data.Booking;
import app.data.BookingCollection;

public class BookingController extends BaseController {

    public BookingCollection getBookings(int roomNumber) {

        final BookingCollection bookings = new BookingCollection();
        final String sql = "SELECT * from booking WHERE nr = " + roomNumber;

        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Booking booking = new Booking();
                booking.setRoomnumber(result.getInt("nr"));
                booking.setFrom(result.getDate("from"));
                booking.setTo(result.getDate("to"));
    
                bookings.add(booking);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }
}