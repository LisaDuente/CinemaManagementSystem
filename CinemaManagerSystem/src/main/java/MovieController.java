import com.Cinema.CinemaManagerSystem.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/insertMovie")
    public void insertMovie(@RequestParam(value = "name", defaultValue = "noName")String name,@RequestParam(value = "genre", defaultValue = "noGenre")String genre, @RequestParam(value = "duration", defaultValue = "noDuration")String duration, @RequestParam(value = "shortDescription", defaultValue = "noShortDescription")String shortDescription, @RequestParam(value = "movieDescription", defaultValue = "noMovieDescription")String movieDescription){
        movieService.insertMovie(name, genre, duration, shortDescription, movieDescription);
    }

    @GetMapping("/deleteMovieById")
    public void deleteMovie(@RequestParam(value = "movieId", defaultValue = "-1")int id){
        movieService.deleteMovie(id);
    }

    @GetMapping("/downloadOneMovie")
    public String downloadOneMovie(@RequestParam(value = "id", defaultValue = "-1")int id){
        return movieService.downloadOneMovie(id);
    }


    @GetMapping("/downloadAllMovies")
    public String downloadAllMovies(){
        return movieService.downloadAllMovies();
    }
}
