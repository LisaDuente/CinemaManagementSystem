package com.Cinema.CinemaManagerSystem.Models;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MovieSchedule {

    private int salonId;
    private String movieTime;
    private String movieDate;
    private int movieId;
    private int [][]seatOfArrayForMovie;
    private boolean isAvailable;

    public MovieSchedule(int salonId, String movieTime, String movieDate, int movieId, String array, boolean isAvailable) {
        Gson gson = new Gson();
        this.salonId = salonId;
        this.movieTime = movieTime;
        this.movieDate = movieDate;
        this.movieId = movieId;
        this.seatOfArrayForMovie = gson.fromJson(array, int[][].class);
        this.isAvailable = isAvailable;
    }

    public MovieSchedule(){}

    public int getSalonId() {
        return salonId;
    }

    public void setSalonId(int salonId) {
        this.salonId = salonId;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int[][] getSeatOfArrayForMovie() {
        return seatOfArrayForMovie;
    }

    public void setSeatOfArrayForMovie(int[][] seatOfArrayForMovie) {
        this.seatOfArrayForMovie = seatOfArrayForMovie;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "MovieSchedule{" +
                "salonId=" + salonId +
                ", movieTime='" + movieTime + '\'' +
                ", movieDate='" + movieDate + '\'' +
                ", movieId=" + movieId +
                ", seatOfArrayForMovie=" + Arrays.toString(seatOfArrayForMovie) +
                ", isAvailable=" + isAvailable +
                '}';
    }

}
