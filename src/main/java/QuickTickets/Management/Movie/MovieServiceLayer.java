package QuickTickets.Management.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuickTickets.Management.EnumConfiguration.MovieStatus;
import QuickTickets.Management.EnumConfiguration.MovieType;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieServiceLayer {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private castRepository castRepo;

    public MovieServiceLayer(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Helper method to convert Movie to MovieDTO
    public MovieDTO convertToDTO(Movies movie) {
        List<CastDTO> castDTOs = movie.getCast().stream().map(c ->
            new CastDTO(c.getCastId(), c.getName(), c.getImage())
        ).collect(Collectors.toList());

        return new MovieDTO(
            movie.getMovieId(),
            movie.getMovieName(),
            movie.getMovieStatus().toString(),
            movie.getMovieType().toString(),
            movie.getDescription(),
            movie.getPrice(),
            movie.getImage(),
            movie.getBannerImage(),
            movie.getRating(),
            movie.getDuration(),
            castDTOs
        );
    }

    // Helper method to convert MovieDTO to Movie
    public Movies convertToEntity(MovieDTO dto) {
        Movies movie = new Movies();
        movie.setMovieId(dto.getMovieId());
        movie.setMovieName(dto.getMovieName());
        movie.setMovieStatus(dto.getMovieStatus() != null ?
        	    MovieStatus.valueOf(dto.getMovieStatus()) :
        	    MovieStatus.Available); // Default
        movie.setMovieType(dto.getMovieType() != null ?
        		  MovieType.valueOf(dto.getMovieType()) :
        	      MovieType.Hindi);
        movie.setDescription(dto.getDescription());
        movie.setPrice(dto.getPrice());
        movie.setImage(dto.getImage());
        movie.setBannerImage(dto.getBannerImage());
        movie.setRating(dto.getRating());
        movie.setDuration(dto.getDuration());

        if (dto.getCast() != null) {
            List<Cast> castList = dto.getCast().stream().map(cdto -> {
                Cast cast = new Cast();
                cast.setCastId(cdto.getCastId());
                cast.setName(cdto.getName());
                cast.setImage(cdto.getImage());
                cast.setMovie(movie);
                return cast;
            }).collect(Collectors.toList());

            movie.setCast(castList);
        }

        return movie;
    }

    @Transactional
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public MovieDTO getMovieById(int movieId) {
        Movies movie = movieRepository.findById(movieId).orElse(null);
        return movie != null ? convertToDTO(movie) : null;
    }

    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movies movie = convertToEntity(movieDTO);

        if (movie.getCast() != null) {
            for (Cast castMember : movie.getCast()) {
                castMember.setMovie(movie);
            }
        }

        Movies savedMovie = movieRepository.save(movie);
        return convertToDTO(savedMovie);
    }

    public MovieDTO updateMovieById(int id, MovieDTO updatedDTO) {
        Movies movie = movieRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Movie not found"));

        movie.setMovieStatus(MovieStatus.valueOf(updatedDTO.getMovieStatus()));
        movie.setMovieType(MovieType.valueOf(updatedDTO.getMovieType()));
        movie.setDescription(updatedDTO.getDescription());
        movie.setPrice(updatedDTO.getPrice());
        movie.setImage(updatedDTO.getImage());
        movie.setBannerImage(updatedDTO.getBannerImage());
        movie.setRating(updatedDTO.getRating());
        movie.setDuration(updatedDTO.getDuration());

        if (updatedDTO.getCast() != null) {
            List<Cast> castArray = new ArrayList<>();
            for (CastDTO cdto : updatedDTO.getCast()) {
                Cast existingCast = castRepo.findById(cdto.getCastId())
                    .orElseThrow(() -> new RuntimeException("Cast Not Found"));

                existingCast.setMovie(movie);
                castArray.add(existingCast);
            }
            movie.setCast(castArray);
        }

        Movies updatedMovie = movieRepository.save(movie);
        return convertToDTO(updatedMovie);
    }

    public String deleteMovieById(int id) {
        if (!movieRepository.existsById(id)) {
            throw new RuntimeException("Movie not found with ID: " + id);
        }
        movieRepository.deleteById(id);
        return "Deleted Successfully Movie of Id:" + id;
    }

    public List<MovieDTO> getAvailableMovie(MovieStatus movieStatus) {
        return movieRepository.findByMovieStatus(movieStatus).stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public boolean checkMovieByName(String movieName) {
        return movieRepository.existsBymovieName(movieName);
    }

    public List<MovieDTO> getMovieByName(String movieName) {
        return movieRepository.findBymovieName(movieName).stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
}
