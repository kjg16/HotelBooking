package app.utils;

import java.util.ArrayList;
import java.util.List;

import app.controller.HotelController;
import app.controller.LocationController;
import app.controller.ReviewController;
import app.controller.TagController;
import app.data.Hotel;
import app.data.Location;
import app.data.LocationCollection;
import app.data.Review;
import app.data.ReviewCollection;
import app.data.Room;
import app.data.RoomCollection;
import app.data.Tag;
import app.data.TagCollection;

public class Catalog implements IManage, ISearch {

    @Override
    public List<Hotel> find(String searchString) {
        ReviewCollection reviews;
        TagCollection tags;
        LocationCollection locations;
        RoomCollection rooms;
        List<Hotel> hotels = new ArrayList<Hotel>();
        HotelController hotelController = new HotelController();

        String[] arrOfStr = searchString.split(" ");

        for (String text : arrOfStr) {
            reviews = getReviews(text);
            tags = getTags(text);
            locations = getLocations(text);

            for (Review review : reviews) {
                hotels.add(hotelController.get(review.getHotel()));
            }
            for (Tag tag : tags) {
                List<Integer> t = hotelController.getHotelByTagId(tag.getId());
                for (Integer i : t) {
                    Hotel cnd = hotelController.get(i);
                    if (!hotels.contains(cnd)) hotels.add(cnd);
                }
            }
            for (Location location : locations) {
                List<Integer> h = hotelController.getHotelByLocationId(location.getId());
                for (Integer i : h) {
                    Hotel cnd = hotelController.get(i);
                    if (!hotels.contains(cnd)) hotels.add(cnd);
                }
            }
        }

        return hotels;
    }

    private LocationCollection getLocations(String text) {
        LocationCollection locations = new LocationCollection();
        LocationController locationController = new LocationController();

        LocationCollection l = locationController.getLocations(text);

        if (!l.isEmpty()) {
            for (Location location : l) {
                locations.add(location);
            }
        }

        return locations;
    }

    private TagCollection getTags(String text) {
        TagCollection tags = new TagCollection();
        TagController tagController = new TagController();

        TagCollection t = tagController.getTags(text);

        if (!t.isEmpty()) {
            for (Tag tag : t) {
                tags.add(tag);
            }
        }

        return tags;
    }

    private ReviewCollection getReviews(String text) {
        ReviewCollection reviews = new ReviewCollection();
        ReviewController reviewController = new ReviewController();
        
        ReviewCollection r = reviewController.getReviews(text);

        if (!r.isEmpty()) {
            for (Review review : r) {
                reviews.add(review);
            }
        }

        return reviews;
    }

    @Override
    public boolean addReview(Review Review) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addReservation(Room room) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addReservation(RoomCollection rooms) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteReservation(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateReservation(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addHotel(Hotel hotel) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addLocation(Location location) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addTag(Tag tag) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addUser(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteReview(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteHotel(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteLocation(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteTag(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateReview(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateHotel(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateUser(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateLocation(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateTag(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    // private methods (public for dev)

    public ReviewCollection findReviews(String searchstring) {

        return null;
    }

    public TagCollection findTag(String searchString) {

        return null;
    }

    public LocationCollection findLocation(String searchString) {

        return null;
    }

    public RoomCollection findRoom(int hotelId) {

        return null;
    }

}