package app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.data.*;

public class HotelController extends BaseController {

    public HotelController() {
    }

    public boolean save(final Hotel h) {
        final String sql = "UPDATE hotel SET name = " + h.getName() +
                            ", description = " + h.getDescription() + 
                            ", url = " + h.getUrl() + " WHERE id = " + h.getId();
        try {
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            return result.rowUpdated();

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(final int id) {
        final String sql = "DELETE from hotel WHERE id = " + id;

        try {
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            return result.rowDeleted();

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return false;
   }

    public Hotel get(final int id) {
        final Hotel hotel = new Hotel();
        final String sql = "SELECT * from hotel WHERE id = " + id;

        try {
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            result.next();
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
        final String sql = "SELECT * from hotel";

        try {
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