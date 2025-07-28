package QuickTickets.Management.Shows;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QuickTickets.Management.Movie.MovieRepository;
import QuickTickets.Management.Movie.MovieServiceLayer;
import QuickTickets.Management.Movie.Movies;
import QuickTickets.Management.Screens.Screens;
import QuickTickets.Management.Screens.ScreensRepository;
import QuickTickets.Management.TimeSlot.TimeSlot;
import QuickTickets.Management.TimeSlot.TimeSlotRepository;
import jakarta.transaction.Transactional;

@Service
public class ShowsServiceLayer {
	
	@Autowired
	private ShowsRepository showsRepository;
	
	@Autowired
	private ScreensRepository screenRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MovieServiceLayer movieService;
	
	@Autowired
	private TimeSlotRepository timeSlotRepository;
	
	public List<Shows> getAllShows(){
		return showsRepository.findAll();
	}
	
	public Shows getShowById(int id){
		return showsRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Show not found with this id:"+id));
	}
	
	public Shows addShow(int screenId,Shows show) {
		
		if(movieService.checkMovieByName(show.getMovie().getMovieName())) {
			List<Movies> movie = movieService.getMovieByName(show.getMovie().getMovieName());
			show.setMovie(movie.get(0));
			
		}
		
		Screens screens = screenRepository.findById(screenId)
				.orElseThrow(()-> new RuntimeException("Screen Not Found"));
		
		show.setScreens(screens);
		
		if(show.getTime_slot()!=null) {
			for(TimeSlot timeSlot: show.getTime_slot()) {
				timeSlot.setShows(show);
			}				
		}
		
		return showsRepository.save(show);
		
	}
	
	@Transactional
	public Shows updateShow(int id,Shows updatedShow) {
		
		Shows show = showsRepository.findById(id)
					.orElseThrow(()-> new RuntimeException("Show Not Found"));
		
		show.setMovie(updatedShow.getMovie());
		show.setScreens(updatedShow.getScreens());
		
		if(updatedShow.getTime_slot()!=null) {
			
			List<TimeSlot> timeSlot = new ArrayList<>();
			for(TimeSlot slot: updatedShow.getTime_slot()) {
				TimeSlot existingSlot = timeSlotRepository.findById(slot.getTime_slot_id())
										.orElseThrow(()-> new RuntimeException("TimeSLot Not Found"));
				timeSlot.add(existingSlot);
			}
			
			show.setTime_slot(timeSlot);
			
		}
		
		return showsRepository.save(show);
		
	}
	
	public String deleteShow(int id) {
		
		if(!showsRepository.existsById(id)) {
			return "Show Not Found With Id:"+id;
		}
		
		 showsRepository.deleteById(id);
		 
		 return "Deleted Successfully Id:"+id;
	}
	
	public Shows getShowByScreenId(int screenId) {
		return showsRepository.findByScreensScreenId(screenId);
	}

}
