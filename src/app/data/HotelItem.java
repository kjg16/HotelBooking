package app.data;

import app.controller.LocationController;
import app.controller.ReviewController;
import app.controller.TagController;

public class HotelItem extends Hotel {

    private static final long serialVersionUID = 1L;
    private LocationCollection locations;
    private TagCollection tags;
    private PictureCollection pictures;
    private VideoCollection videos;
    private ReviewCollection reviews;

    public HotelItem() {
    }

    /**
     * @return the location
     */
    public LocationCollection getLocation() {
        if (locations == null) {
            LocationController locationController = new LocationController();
            locations = locationController.getLocationsByHotelId(getId());
        }

        return locations;
    }

    /**
     * @return the tags
     */
    public TagCollection getTags() {
        if (tags == null) {
            TagController tagController = new TagController();
            tags = tagController.getTagByHotelId(getId());
        }
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
        if (reviews == null) {
            ReviewController reviewController = new ReviewController();
            reviews = reviewController.getReviewsByHotelId(getId());
        }
        
        return reviews;
    }
}