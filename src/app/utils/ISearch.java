package app.utils;

import java.util.List;
import app.data.Hotel;
import app.data.Review;
import app.data.Room;
import app.data.RoomCollection;

public interface ISearch {
    public List<Hotel> find(String searchString);
    public boolean addReview(Review Review);
    public boolean addReservation(Room room);
    public boolean addReservation(RoomCollection rooms);

    public boolean deleteReservation(int id);

    public boolean updateReservation(int id);
    public boolean updateReview(int id);
}