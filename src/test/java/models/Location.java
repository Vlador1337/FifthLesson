package models;

public class Location {
    private String name;
    private String url;

    public Location(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Location() {

    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
