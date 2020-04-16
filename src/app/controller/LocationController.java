package app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.data.Location;
import app.data.LocationCollection;

public class LocationController extends BaseController {

    private LocationCollection executeReadList(final String sql) {
        final LocationCollection locations = new LocationCollection();

        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                final Location location = new Location();
                location.setId(result.getInt("id"));
                location.setName(result.getString("name"));

                locations.add(location);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }

    private Location executeRead(final String sql) {
        final Location location = new Location();

        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            result.next();
            location.setId(result.getInt("id"));
            location.setName(result.getString("name"));
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return location;
    }

    public LocationCollection getLocations(final String name) {
        final String sql = "SELECT * from location WHERE name like '%" + name + "%'";

        return executeReadList(sql);
    }

    public LocationCollection getLocationsByHotelId(final int hotelId) {
        final LocationCollection locations = new LocationCollection();
        final List<Integer> locationIds = new ArrayList<Integer>();
        String sql = "SELECT * from hotellocation WHERE hotel = " + hotelId;

        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                locationIds.add(result.getInt("location"));
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        for (final Integer i : locationIds) {
            sql = "SELECT * from location WHERE id = " + i;
            locations.add(executeRead(sql));
        }

        return locations;
    }
}
