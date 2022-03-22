import com.Cinema.CinemaManagerSystem.Movie;
import com.Cinema.CinemaManagerSystem.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {
    @Autowired
    MovieDAO dao;
    Movie movie;
    ArrayList<Movie> movies;

    public void insertMovie(Movie movie){dao.insertNewMovie(movie.getName(), movie.getGenre(), movie.getDuration(), movie.getMovieDescription());}

    public void deleteMovie(Movie deleteMovie){dao.deleteMovie(deleteMovie.getId());}

    public Movie downloadOneMovie(int id){
        movie = dao.downloadOneMovie(id);
        return movie;
    }

    public ArrayList<Movie> downloadAllMovies(){
        movies = dao.downloadAllMovies();
        return movies;
    }

}