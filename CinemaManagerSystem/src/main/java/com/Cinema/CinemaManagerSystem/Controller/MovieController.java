package com.Cinema.CinemaManagerSystem.Controller;

import com.Cinema.CinemaManagerSystem.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {


    @Autowired
    MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    /**
     * Sends request to insert a new movie to database
     * @param name int for movieID of movie we want to insert
     * @param genre what genre the movie is
     * @param duration how long the movie is
     * @param shortDescription short describe the movie
     * @param movieDescription longer version of the description
     * @param path picture of the movie
     */
    @PostMapping("/insertMovie")
    public void insertMovie(@RequestParam(value = "name", defaultValue = "noName")String name,
                            @RequestParam(value = "genre", defaultValue = "noGenre")String genre,
                            @RequestParam(value = "duration", defaultValue = "noDuration")String duration,
                            @RequestParam(value = "shortDescription", defaultValue = "noShortDescription")String shortDescription,
                            @RequestParam(value = "movieDescription", defaultValue = "noMovieDescription")String movieDescription,
                            @RequestParam(value = "path",defaultValue = "empty")String path){
        movieService.insertMovie(name, genre, duration, movieDescription, shortDescription, path);
    }
    /**
     * Sends request to update a new movie in the database, specify ID
     * @param id int for movieID of movie
     * @param name int for movieID of movie we want to update, specify ID you want to update
     * @param genre what genre the movie is
     * @param duration how long the movie is
     * @param shortDescription short describe the movie
     * @param movieDescription longer version of the description
     * @param path picture of the movie
     */
    @PostMapping("/updateMovie")
    public void updateMovie(@RequestParam(value = "id", defaultValue = "0")int id,
                            @RequestParam(value = "name", defaultValue = "noName")String name,
                            @RequestParam(value = "genre", defaultValue = "noGenre")String genre,
                            @RequestParam(value = "duration", defaultValue = "noDuration")String duration,
                            @RequestParam(value = "shortDescription", defaultValue = "noShortDescription")String shortDescription,
                            @RequestParam(value = "movieDescription", defaultValue = "noMovieDescription")String movieDescription,
                            @RequestParam(value = "path",defaultValue = "empty")String path){
        movieService.updateMovie(id, name, genre, duration, movieDescription, shortDescription, path);
    }
    /**
     * Sends request to delete a movie from database by ID
     * @param id int for movieID of movie
     */
    @PostMapping("/deleteMovieById")
    public void deleteMovie(@RequestParam(value = "movieId", defaultValue = "-1")int id){
        movieService.deleteMovie(id);
    }
    /**
     * Sends request to download one movie from database by ID
     * @param id int for movieID of movie
     */
    @GetMapping("/downloadOneMovie")
    public String downloadOneMovie(@RequestParam(value = "id", defaultValue = "-1")int id){
        return movieService.downloadOneMovie(id);
    }
    /**
     * Sends request to download all movies from database by ID
     */
    @GetMapping("/downloadAllMovies")
    public String downloadAllMovies(){
        return movieService.downloadAllMovies();
    }
    /**
     * Sends request to download a recent movie that were
     * inserted into the database
     */
    @GetMapping("/downloadMostRecentMovie")
    public String downloadMostRecent(){
        return movieService.downloadMostRecent();
    }

    @GetMapping("/downloadMovieByName")
    public String downloadMovieByName(@RequestParam(value = "name", defaultValue = "")String name){
        return movieService.downloadMovieByName(name);
    }
}
