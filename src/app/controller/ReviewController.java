package app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.data.Review;
import app.data.ReviewCollection;

public class ReviewController extends BaseController {

    public ReviewCollection getReviews(String text) {

        final ReviewCollection reviews = new ReviewCollection();
        final String sql = "SELECT * from review WHERE text like '%" + text + "%'";

        try {
            final Statement statement = conn.createStatement();
            final ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Review review = new Review();
                review.setId(result.getInt("id"));
                review.setHotel(result.getInt("hotel"));
                review.setUser(result.getInt("user"));
                review.setText(result.getString("text"));
    
                reviews.add(review);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }
}
