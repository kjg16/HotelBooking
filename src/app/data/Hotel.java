package app.data;

public class Hotel extends BaseEntity 
{
    private static final long serialVersionUID = 1L;
    private NameString name;
    private TextString description;
    private UrlString url;

    public int getId() {
        return super.getId();
    }
    public void setId(int i) {
        super.setId(i);
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
    public void setName(String s) {
        this.name = new NameString(s);
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
    public void setDescription(String s) {
        this.description = new TextString(s);
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
    public void setUrl(String s) {
        this.url = new UrlString(s);
    }

    public String GetInfo() {
        return "Nafn: " + getName() + ", Lýsing: " + getDescription() + ", Heimasíða:" + getUrl();
    }
}
