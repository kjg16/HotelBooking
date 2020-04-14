package app.data;

public class Hotel extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    private NameString name;
    private TextString description;
    private UrlString url;

    // ctor
    public Hotel() {
    }
    public Hotel(String name) {
        this.name.set(name);
    }

    // props
    public int getId() {
        return super.getId();
    }
    public void setId(int id) {
        super.setId(id);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name.get();
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = new NameString(name);
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description.get();
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = new TextString(description);
    }
    /**
     * @return the url
     */
    public String getUrl() {
        return url.get();
    }
    /**
     * @param url the _url to set
     */
    public void setUrl(String url) {
        this.url = new UrlString(url);
    }

    public String GetInfo() {
        return "Nafn: " + getName() + ", Lýsing: " + getDescription() + ", Heimasíða:" + getUrl();
    }
}
