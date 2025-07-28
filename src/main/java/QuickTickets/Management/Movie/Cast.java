package QuickTickets.Management.Movie;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cast")
public class Cast {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cast_id")
	private int castId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="image")
	private String image;
	
	@ManyToOne
	@JoinColumn(name="movie_id",nullable=false)
	@JsonIgnore
	private Movies movie;
	
	public Cast() {}

	public Cast(int castId, String name, String image,Movies movie) {
		super();
		this.castId = castId;
		this.name = name;
		this.image = image;
		this.movie=movie;
	}

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
	
	@JsonIgnore
	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Cast [castId=" + castId + ", name=" + name + ", image=" + image +", Movie=" +movie+ "]";
	}
	

}
