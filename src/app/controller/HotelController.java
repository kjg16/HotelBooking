package app.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.data.*;
import app.utils.Context;

public class HotelController extends BaseController {
    public HotelController() {
    }

    public void save(final Hotel h) {
    }

    public void delete(final int id) {
    }

    public Hotel get(final int id) {
        final Context context = new Context();
        final Hotel hotel = new Hotel();
        final String sql = "SELECT * from hotel WHERE id = " + id;

        try {
            final Connection conn = context.getConnection();
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            hotel.setId(result.getInt("id"));
            hotel.setDescription(result.getString("description"));
            hotel.setName(result.getString("name"));
            hotel.setUrl(result.getString("url"));

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return hotel;
    }

    public List<Hotel> getAll() {
        final List<Hotel> hotels = new ArrayList<Hotel>();
        final Context context = new Context();
        final String sql = "SELECT * from hotel";

        try {
            final Connection conn = context.getConnection();
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                final Hotel hotel = new Hotel();
                hotel.setId(result.getInt("id"));
                hotel.setDescription(result.getString("description"));
                hotel.setName(result.getString("name"));
                hotel.setUrl(result.getString("url"));

                hotels.add(hotel);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return hotels;
    }
    
}