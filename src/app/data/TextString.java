package app.data;

public class TextString {
    private String str;

    // ctor
    TextString(String s) {
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