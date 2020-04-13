package app.data;

import java.io.Serializable;
//import java.lang.reflect.Type;
//import java.util.List;

enum Language {
    Icelandic,
    English,
    Polish
}

enum AccountState {
    Closed, 
    Active,
    Admin
}

enum Payments {
    Visa,
    MasterCard,
    PayPal
}

public class BaseEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int id;

    public BaseEntity()
    {
    }
    public BaseEntity(int i)
    {
        id = i;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }
    public void setId(int i) {
        id = i;
    }
}
