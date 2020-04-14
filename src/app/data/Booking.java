package app.data;

import java.util.Date;

public class Booking extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private int Roomnumber;
    private Date from;
    private Date to;

    // ctor
    public Booking () {}

    // props
    /**
     * @return the roomnumber
     */
    public int getRoomnumber() {
        return Roomnumber;
    }
    /**
     * @param roomnumber the roomnumber to set
     */
    public void setRoomnumber(int roomnumber) {
        Roomnumber = roomnumber;
    }

    /**
     * @return the from
     */
    public Date getFrom() {
        return from;
    }
    /**
     * @param from the from to set
     */
    public void setFrom(Date from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public Date getTo() {
        return to;
    }
    /**
     * @param to the to to set
     */
    public void setTo(Date to) {
        this.to = to;
    }
}
