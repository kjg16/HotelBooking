package app.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseEntityCollection<T> extends ArrayList<T> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<T> list;

    BaseEntityCollection() {
        list = new ArrayList<T>();
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        return super.get(index);
    }

    @Override
    public T set(int index, T element) {
        // TODO Auto-generated method stub
        return super.set(index, element);
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(this.list);
    }
}
