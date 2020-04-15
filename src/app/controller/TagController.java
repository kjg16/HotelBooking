package app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.data.Tag;
import app.data.TagCollection;

public class TagController extends BaseController {
    public TagCollection getTags(String text) {

        final TagCollection tags = new TagCollection();
        final String sql = "SELECT * from tag WHERE name like '" + text + "'";

        try {
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Tag tag = new Tag();
                tag.setId(result.getInt("id"));
                tag.setName(result.getString("name"));
    
                tags.add(tag);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return tags;
    }
}