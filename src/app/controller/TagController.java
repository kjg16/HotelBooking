package app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.data.Tag;
import app.data.TagCollection;

public class TagController extends BaseController {

    private TagCollection executeReadList(final String sql) {
        final TagCollection tags = new TagCollection();

        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                final Tag tag = new Tag();
                tag.setId(result.getInt("id"));
                tag.setName(result.getString("name"));

                tags.add(tag);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return tags;
    }

    private Tag executeRead(final String sql) {
        final Tag tag = new Tag();

        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            result.next();
            tag.setId(result.getInt("id"));
            tag.setName(result.getString("name"));
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return tag;
    }

    public TagCollection getTags(final String text) {
        final String sql = "SELECT * from tag WHERE name like '" + text + "'";

        return executeReadList(sql);
    }

    public TagCollection getTagByHotelId(final int hotelId) {
        final TagCollection tags = new TagCollection();
        final List<Integer> tagIds = new ArrayList<Integer>();
        String sql = "SELECT * from hoteltag WHERE hotel = " + hotelId;

        try {
            final Statement statement = context.getConnection().createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                tagIds.add(result.getInt("tag"));
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        for (final Integer i : tagIds) {
            sql = "SELECT * from tag WHERE id = " + i;
            tags.add(executeRead(sql));
        }

        return tags;
    }
}