package app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.data.*;

public class HotelController extends BaseController {

    // ctor
    public HotelController() {
    }

    //#region private methods
    private HotelItem executeRead(final String sql) {
        final HotelItem hotelItem = new HotelItem();

        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            result.next();
            hotelItem.setId(result.getInt("id"));
            hotelItem.setDescription(result.getString("description"));
            hotelItem.setName(result.getString("name"));
            hotelItem.setUrl(result.getString("url"));
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return hotelItem;
    }

    private List<HotelItem> executeReadList(final String sql) {
        final List<HotelItem> hotelItems = new ArrayList<HotelItem>();

        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                final HotelItem hotelItem = new HotelItem();
                hotelItem.setId(result.getInt("id"));
                hotelItem.setDescription(result.getString("description"));
                hotelItem.setName(result.getString("name"));
                hotelItem.setUrl(result.getString("url"));

                hotelItems.add(hotelItem);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return hotelItems;
    }
    //#endregion

    // public methods
    public boolean save(final Hotel h) {
        final String sql = "UPDATE hotel SET name = " + h.getName() + ", description = " + h.getDescription()
                + ", url = " + h.getUrl() + " WHERE id = " + h.getId();

        return executeUpdate(sql);
    }

    public boolean delete(final int id) {
        final String sql = "DELETE FROM hotel WHERE id = " + id;

        return executeDelete(sql);
    }

    public HotelItem get(final int id) {
        final String sql = "SELECT * FROM hotel WHERE id = " + id;

        return executeRead(sql);
    }

    public List<HotelItem> getAll() {
        final String sql = "SELECT * FROM hotel";

        return executeReadList(sql);
    }

    public List<HotelItem> FindHotel(String description) {
        final String sql = "SELECT * FROM hotel where description like '%" + description + "%'";

        return executeReadList(sql);
    }

    public List<Integer> getHotelByLocationId(final int locationId) {
        final List<Integer> hotels = new ArrayList<Integer>();
        final String sql = "SELECT hotel FROM HotelLocation WHERE location = " + locationId;

        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                final int i = result.getInt("hotel");

                hotels.add(i);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return hotels;
    }

    public List<Integer> getHotelByTagId(final int tagId) {
        final List<Integer> tags = new ArrayList<Integer>();
        final String sql = "SELECT hotel FROM HotelTag WHERE tag = " + tagId;

        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                final int i = result.getInt("hotel");

                tags.add(i);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return tags;
	}
    
}