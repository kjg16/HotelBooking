package app.data;

public class Review extends BaseEntity {

    private static final long serialVersionUID = 1L;
    int user;
    int hotel;
    String text;

    /**
     * @return the user
     */
    public int getUser() {
        return user;
    }
    /**
     * @param user the user to set
     */
    public void setUser(int user) {
        this.user = user;
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
     * @return the text
     */
    public String getText() {
        return text;
    }
    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
}