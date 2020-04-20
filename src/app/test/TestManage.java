package app.test;

import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import app.data.Hotel;
import app.data.Tag;
import app.utils.*;

public class TestManage {
    private Catalog underTest;
    private IManage manager = mock(IManage.class);

    @Before
    void setup() {
        underTest = new Catalog();
    }

    @Test
    public void shouldAddHotel() throws IOException {
        Hotel hotel = new Hotel();
        when(manager.addHotel(hotel)).thenReturn(true);
        assert(underTest.addHotel(hotel));
    }

    @Test
    public void shouldAddTag() throws IOException {
        Tag tag = new Tag();
        when(manager.addTag(tag)).thenReturn(true);
        assert(underTest.addTag(tag));
    }
    
}