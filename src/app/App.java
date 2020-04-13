package app;

import app.controller.HotelController;
import app.data.Hotel;

public class App {
    public static void main(final String[] args) throws Exception {
        System.out.println("Hello Java");

        HotelController hotelCtrl = new HotelController();
        Hotel hotel = hotelCtrl.get(1);

        int i = hotel.getId();
        String n = hotel.getName();
        String d = hotel.getDescription();
        String u = hotel.getUrl();

        System.out.printf("\nnafn: %s\nlýsing: %s\nurl: %s\n", n, d, u);
    
    }
}