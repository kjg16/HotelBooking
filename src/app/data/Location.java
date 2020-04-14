package app.data;

public class Location extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private int no;
    private int type;
    private int hotel;
    private int persons;

    /**
     * @return the no
     */
    public int getNo() {
        return no;
    }
    /**
     * @param no the no to set
     */
    public void setNo(int no) {
        this.no = no;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the hotel
     */
    public int getHotel() {
        return hotel;
    }
    /**
     * @param hotel the hotel to set
     */
    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

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
}