package app.data;

public class UrlString {
    private String str;

    // ctor
    UrlString(String s) {
        this.str = s;
    }

    // props
    public String get() {
        return str;
    }
    public void set(String s) {
        this.str = s;
    }
}