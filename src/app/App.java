package app;

import java.util.List;

import app.data.HotelItem;
import app.data.Location;
import app.data.Review;
import app.data.Tag;
import app.utils.Catalog;

public class App {
    public static void main(final String[] args) throws Exception {
        Catalog catalog = new Catalog();

        List<HotelItem> hotels = catalog.find("útsýni Austurland no2");

        for (HotelItem hotel : hotels) {
            System.out.printf("\nnafn: %s\nlýsing: %s\nurl: %s\n", hotel.getName(), hotel.getDescription(), hotel.getUrl());

            System.out.print("Locations:\n");
            for (Location location : hotel.getLocation()) {
                System.out.printf(" %s,", location.getName());
            }
            System.out.print("\n");

            System.out.print("Tags:\n");
            for (Tag tag : hotel.getTags()) {
                System.out.printf(" %s,", tag.getName());
            }
            System.out.print("\n");

            System.out.print("Reviews:\n");
            for (Review review : hotel.getReviews()) {
                System.out.printf(" %s,", review.getText());
            }
            System.out.print("\n");
        }
    }
}