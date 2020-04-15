package app;

import java.util.List;

import app.data.Hotel;
import app.utils.Catalog;

public class App {
    public static void main(final String[] args) throws Exception {
        Catalog catalog = new Catalog();

        List<Hotel> hotels = catalog.find("útsýni Austurland no2");

        for (Hotel hotel : hotels) {
            System.out.printf("\nnafn: %s\nlýsing: %s\nurl: %s\n", hotel.getName(), hotel.getDescription(), hotel.getUrl());
        }
    }
}