package app;

import java.util.List;

import app.controller.HotelController;
import app.data.Hotel;
import app.utils.Catalog;

public class App {
    public static void main(final String[] args) throws Exception {
        System.out.println("Hello Java");

        HotelController hotelCtrl = new HotelController();
        Hotel hotel = hotelCtrl.get(1);

        int i = hotel.getId();
        String n = hotel.getName();
        String d = hotel.getDescription();
        String u = hotel.getUrl();

        System.out.println(i);
        System.out.printf("\nnafn: %s\nlýsing: %s\nurl: %s\n", n, d, u);


        Catalog catalog = new Catalog();
        List<Hotel> hotels = catalog.find("útsýni Austurland blah");

        for (Hotel hotel2 : hotels) {
            System.out.printf("\nnafn: %s\nlýsing: %s\nurl: %s\n", hotel2.getName(), hotel2.getDescription(), hotel2.getUrl());
        }
    }
}