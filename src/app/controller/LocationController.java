package app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.data.Location;
import app.data.LocationCollection;

public class LocationController extends BaseController {

    public LocationCollection getLocations(String name) {

        final LocationCollection locations = new LocationCollection();
        final String sql = "SELECT * from location WHERE name like '%" + name + "%'";

        try {
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Location location = new Location();
                location.setId(result.getInt("id"));
                location.setName(result.getString("name"));
    
                locations.add(location);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }
}
