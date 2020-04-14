package app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.data.Location;
import app.data.LocationCollection;

public class LocationController extends BaseController {

    public LocationCollection getLocations(String text) {

        final LocationCollection locations = new LocationCollection();
        final String sql = "SELECT * from locations WHERE text like '" + text + "'";

        try {
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Location location = new Location();
                location.setId(result.getInt("id"));
                location.setNo(result.getInt("no"));
                location.setHotel(result.getInt("hotel"));
                location.setType(result.getInt("type"));
                location.setPersons(result.getInt("persons"));
    
                locations.add(location);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }
}
