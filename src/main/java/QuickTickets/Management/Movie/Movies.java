package QuickTickets.Management.Movie;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import QuickTickets.Management.EnumConfiguration.MovieStatus;
import QuickTickets.Management.EnumConfiguration.MovieType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class Movies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movie_id")
	private int movieId;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="movie_status")
	private MovieStatus movieStatus;
	
	@Column(name="movie_type")
	private MovieType movieType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private int price;
	
	@Column(name="image")
	private String image;
	
	@Column(name="banner_image")
	private String bannerImage;
	
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="duration")
	private String duration;
	
	@OneToMany(mappedBy="movie",cascade=CascadeType.ALL)
	private List<Cast> cast;

	public Movies() {}

	public Movies(int movieId, String movieName, MovieStatus movieStatus, MovieType movieType, String description,
			int price, String image, String bannerImage, Integer rating, String duration, List<Cast> cast) {
		super();
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

	public MovieStatus getMovieStatus() {
		return movieStatus;
	}

	public void setMovieStatus(MovieStatus movieStatus) {
		this.movieStatus = movieStatus;
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
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

	public List<Cast> getCast() {
		return cast;
	}

	public void setCast(List<Cast> cast) {
		this.cast = cast;
		 if (cast != null) {
	            for (Cast c : cast) {
	                c.setMovie(this);  // Ensure each cast is associated with this movie
	            }
	        }
	}

	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", movieStatus=" + movieStatus
				+ ", movieType=" + movieType + ", description=" + description + ", price=" + price + ", image=" + image
				+ ", bannerImage=" + bannerImage + ", rating=" + rating + ", duration=" + duration + ", cast=" + cast
				+ "]";
	}

	
}
