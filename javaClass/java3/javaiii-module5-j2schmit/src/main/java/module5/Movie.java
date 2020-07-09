package module5;

public class Movie {

    private int id;
    private int rating;
    private String name;
    private String description;

    public Movie () {
        this(-1, "", -1, "");
    }

    public Movie(int id, String name, int rating, String description) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRating() {
        return String.valueOf(rating);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

