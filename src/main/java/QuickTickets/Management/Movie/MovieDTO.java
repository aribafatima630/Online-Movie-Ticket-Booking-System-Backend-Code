package QuickTickets.Management.Movie;

import java.util.List;

public class MovieDTO {
    
    private int movieId;
    private String movieName;
    private String movieStatus;
    private String movieType;
    private String description;
    private int price;
    private String image;
    private String bannerImage;
    private Integer rating;
    private String duration;
    private List<CastDTO> cast;

    public MovieDTO() {}

    public MovieDTO(int movieId, String movieName, String movieStatus, String movieType, String description,
                    int price, String image, String bannerImage, Integer rating, String duration, List<CastDTO> cast) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieStatus = movieStatus;
        this.movieType = movieType;
        this.description = description;
        this.price = price;
        this.image = image;
        this.bannerImage = bannerImage;
        this.rating = rating;
        this.duration = duration;
        this.cast = cast;
    }

    // Getters and Setters

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<CastDTO> getCast() {
        return cast;
    }

    public void setCast(List<CastDTO> cast) {
        this.cast = cast;
    }
}