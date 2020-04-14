package app.utils;

import app.data.Hotel;
import app.data.Location;
import app.data.Tag;

public interface IManage {
    public boolean addHotel(Hotel hotel);
    public boolean addLocation(Location location);
    public boolean addTag(Tag tag);
    public boolean addUser(User user);

    public boolean deleteReview(int id);
    public boolean deleteHotel(int id);
    public boolean deleteUser(int id);
    public boolean deleteLocation(int id);
    public boolean deleteTag(int id);

    public boolean updateReview(int id);
    public boolean updateHotel(int id);
    public boolean updateUser(int id);
    public boolean updateLocation(int id);
    public boolean updateTag(int id);
}