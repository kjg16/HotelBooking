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

    private Hotel executeRead(String sql) {
        final Hotel hotel = new Hotel();

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

    private List<Hotel> executeReadList(String sql) {
        final List<Hotel> hotels = new ArrayList<Hotel>();

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

    public boolean save(final Hotel h) {
        final String sql = "UPDATE hotel SET name = " + h.getName() +
                            ", description = " + h.getDescription() + 
                            ", url = " + h.getUrl() + " WHERE id = " + h.getId();

        return executeUpdate(sql);
    }

    public boolean delete(final int id) {
        final String sql = "DELETE from hotel WHERE id = " + id;

        return executeDelete(sql);
   }

    public Hotel get(final int id) {
        final String sql = "SELECT * from hotel WHERE id = " + id;

        return executeRead(sql);
    }

    public List<Hotel> getAll() {
        final String sql = "SELECT * from hotel";

        return executeReadList(sql);
    }

    public List<Integer> getHotelByLocationId(int locationId) {
        List<Integer> hotels = new ArrayList<Integer>();
        final String sql = "Select hotel from HotelLocation where location = " + locationId;

        try {
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int i = result.getInt("hotel");

                hotels.add(i);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return hotels;
    }

	public List<Integer> getHotelByTagId(int tagId) {
        List<Integer> tags = new ArrayList<Integer>();
        final String sql = "Select hotel from HotelTag where tag = " + tagId;

        try {
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int i = result.getInt("hotel");

                tags.add(i);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return tags;
	}
    
}