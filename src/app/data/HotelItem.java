package app.data;

public class HotelItem extends Hotel {

    private static final long serialVersionUID = 1L;

    LocationCollection location;
    TagCollection tags;
    PictureCollection pictures;
    VideoCollection  videos;
    ReviewCollection reviews;

    /**
     * @return the location
     */
    public LocationCollection getLocation() {
        return location;
    }

    /**
     * @return the tags
     */
    public TagCollection getTags() {
        return tags;
    }

    /**
     * @return the pictures
     */
    public PictureCollection getPictures() {
        return pictures;
    }

    /**
     * @return the videos
     */
    public VideoCollection getVideos() {
        return videos;
    }

    /**
     * @return the reviews
     */
    public ReviewCollection getReviews() {
        return reviews;
    }
}