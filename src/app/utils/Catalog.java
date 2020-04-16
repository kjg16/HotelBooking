package app.utils;

import java.util.ArrayList;
import java.util.List;

import app.controller.HotelController;
import app.controller.LocationController;
import app.controller.ReviewController;
import app.controller.TagController;
import app.data.Hotel;
import app.data.HotelItem;
import app.data.Location;
import app.data.LocationCollection;
import app.data.Review;
import app.data.ReviewCollection;
import app.data.Room;
import app.data.RoomCollection;
import app.data.Tag;
import app.data.TagCollection;

public class Catalog implements IManage, ISearch {

    // #region private methods
    private LocationCollection getLocations(final String text) {
        final LocationCollection locations = new LocationCollection();
        final LocationController locationController = new LocationController();

        final LocationCollection l = locationController.getLocations(text);

        if (!l.isEmpty()) {
            for (final Location location : l) {
                locations.add(location);
            }
        }

        return locations;
    }

    private TagCollection getTags(final String text) {
        final TagCollection tags = new TagCollection();
        final TagController tagController = new TagController();

        final TagCollection t = tagController.getTags(text);

        if (!t.isEmpty()) {
            for (final Tag tag : t) {
                tags.add(tag);
            }
        }

        return tags;
    }

    private ReviewCollection getReviews(final String text) {
        final ReviewCollection reviews = new ReviewCollection();
        final ReviewController reviewController = new ReviewController();

        final ReviewCollection r = reviewController.getReviews(text);

        if (!r.isEmpty()) {
            for (final Review review : r) {
                reviews.add(review);
            }
        }

        return reviews;
    }

    private boolean isListed(List<HotelItem> hotels, int id) {
        for (Hotel hotel : hotels) {
            if (hotel.getId() == id)
                return true;
        }

        return false;
    }
    // #endregion

    // #region override methods
    @Override
    public List<HotelItem> find(final String searchString) {
        ReviewCollection reviews;
        TagCollection tags;
        LocationCollection locations;
        final RoomCollection rooms;
        final List<HotelItem> hotelitems = new ArrayList<HotelItem>();
        final HotelController hotelController = new HotelController();

        final String[] arrOfStr = searchString.split(" ");
        for (final String text : arrOfStr) {
            reviews = getReviews(text);
            tags = getTags(text);
            locations = getLocations(text);

            for (final Review review : reviews) {
                if (!isListed(hotelitems, review.getHotel()))
                    hotelitems.add(hotelController.get(review.getHotel()));
            }
            for (final Tag tag : tags) {
                final List<Integer> t = hotelController.getHotelByTagId(tag.getId());
                for (final Integer i : t) {
                    if (!isListed(hotelitems, i))
                        hotelitems.add(hotelController.get(i));
                }
            }
            for (final Location location : locations) {
                final List<Integer> h = hotelController.getHotelByLocationId(location.getId());
                for (final Integer i : h) {
                    if (!isListed(hotelitems, i))
                        hotelitems.add(hotelController.get(i));
                }
            }
        }

        return hotelitems;
    }

    // add
    @Override
    public boolean addReview(final Review Review) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addReservation(final Room room) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addReservation(final RoomCollection rooms) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addHotel(final Hotel hotel) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addUser(final User user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addLocation(final Location location) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addTag(final Tag tag) {
        // TODO Auto-generated method stub
        return false;
    }

    // delete
    @Override
    public boolean deleteReview(final int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteReservation(final int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteHotel(final int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteUser(final int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteLocation(final int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteTag(final int id) {
        // TODO Auto-generated method stub
        return false;
    }

    // update
    @Override
    public boolean updateReview(final int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateReservation(final int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateHotel(final int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateUser(final int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateLocation(final int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateTag(final int id) {
        // TODO Auto-generated method stub
        return false;
    }
    //#endregion
}
