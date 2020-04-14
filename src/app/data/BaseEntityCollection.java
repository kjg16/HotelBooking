package app.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseEntityCollection<T> extends ArrayList<T> {

    private static final long serialVersionUID = 1L;
    private List<T> list;

    // ctor
    BaseEntityCollection() {
        list = new ArrayList<T>();
    }

    // props
    @Override
    public T get(int index) {
        return super.get(index);
    }

    @Override
    public T set(int index, T element) {
        return super.set(index, element);
    }

    // methods
    public List<T> getAll() {
        return Collections.unmodifiableList(this.list);
    }
}
