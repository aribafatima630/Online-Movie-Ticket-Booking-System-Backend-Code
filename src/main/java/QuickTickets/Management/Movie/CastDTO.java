package QuickTickets.Management.Movie;

public class CastDTO {

    private int castId;
    private String name;
    private String image;

    public CastDTO() {}

    public CastDTO(int castId, String name, String image) {
        this.castId = castId;
        this.name = name;
        this.image = image;
    }

    // Getters and Setters

    public int getCastId() {
        return castId;
    }

    public void setCastId(int castId) {
        this.castId = castId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
