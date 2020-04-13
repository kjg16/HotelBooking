package app.data;

public class Room extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int _roomNumber;
    private int _persons;
    private float _price;
    // private BookingCollection _bookings;
    // private PictureCollection _pictures;



    /**
     * @return the _persons
     */
    public int get_persons() {
        return _persons;
    }
    /**
     * @param _persons the _persons to set
     */
    public void set_persons(int _persons) {
        this._persons = _persons;
    }
    /**
     * @return the _price
     */
    public float get_price() {
        return _price;
    }
    /**
     * @param _price the _price to set
     */
    public void set_price(float _price) {
        this._price = _price;
    }
    /**
     * @return the _roomNumber
     */
    public int get_roomNumber() {
        return _roomNumber;
    }
    /**
     * @param _roomNumber the _roomNumber to set
     */
    public void set_roomNumber(int _roomNumber) {
        this._roomNumber = _roomNumber;
    }
}