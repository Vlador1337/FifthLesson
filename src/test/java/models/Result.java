package models;

import java.util.ArrayList;
import java.util.Date;

public class Result {
    @Override
    public String toString() {
        return "Об персонаже: " + "\n" +
                "ID - " + id + "\n" +
                "Имя персонажа - " + name + "\n" +
                "Статус - " + status + "\n" +
                "Раса - " + species + "\n" +
                "Гендер - " + gender + "\n" +
                "Локация - " + location.getName() + "\n" +
                "Последний эпизод - " + episode.get(episode.size() - 1).split("/")[5] + "\n";
    }

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Location origin;
    private Location location;
    private String image;
    private ArrayList<String> episode;
    private String url;
    private Date created;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public ArrayList<String> getEpisode() {
        return episode;
    }

    public String getUrl() {
        return url;
    }

    public Date getCreated() {
        return created;
    }

    public Result(int id, String name, String status, String species, String type, String gender, Location origin, Location location, String image, ArrayList<String> episode, String url, Date created) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
        this.image = image;
        this.episode = episode;
        this.url = url;
        this.created = created;
    }

    public Result() {
    }
}
