package app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.data.Review;
import app.data.ReviewCollection;

public class ReviewController extends BaseController {

    private ReviewCollection executeReadList(String sql) {
        final ReviewCollection reviews = new ReviewCollection();

        try {
            final Statement statement = context.getConnection().createStatement();
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

    public ReviewCollection getReviews(String text) {
        final String sql = "SELECT * from review WHERE text like '%" + text + "%'";
        return executeReadList(sql);
    }

    public ReviewCollection getReviewsByHotelId(int hotelId) {
        final String sql = "SELECT * from review WHERE hotel = " + hotelId;
        return executeReadList(sql);
    }
}
