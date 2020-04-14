package app.data;

public class Room extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private int roomNumber;
    private int persons;
    private float price;
    // private BookingCollection bookings;
    // private PictureCollection pictures;

    /**
     * @return the persons
     */
    public int getPersons() {
        return persons;
    }
    /**
     * @param persons the persons to set
     */
    public void setPersons(int persons) {
        this.persons = persons;
    }
    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
    /**
     * @return the roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }
    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return the bookings
     */
    public BookingCollection getBookings(int roomNumber) {
        return getBookings(roomNumber);
    }
}