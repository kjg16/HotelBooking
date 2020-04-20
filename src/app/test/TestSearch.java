package app.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import app.data.HotelItem;
import app.data.Review;
import app.utils.*;

public class TestSearch {
    private Catalog underTest;
    private ISearch hotelSearch = mock(ISearch.class);

    @Before
    void setup() {
        underTest = new Catalog();
    }

    @Test
    public void shouldFindSomeHotelItems() throws IOException {
        List<HotelItem> okFindSomeHotelItems = new ArrayList<HotelItem>();
        when(hotelSearch.find("útsýni")).thenReturn(okFindSomeHotelItems);

        final List<HotelItem> findResulList = underTest.find("noresult");
        assertEquals(okFindSomeHotelItems, findResulList);
    }

    @Test
    public void shouldAddReview() throws IOException {
        Review review = new Review();
        boolean created = hotelSearch.addReview(review);
        assert(created == true);
    }
    
}