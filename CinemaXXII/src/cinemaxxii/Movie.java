/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaxxii;

/**
 *
 * @author Yoga
 */
public class Movie {
    private int movieId;
    private String title;
    private String cover;
    private String synopsis;
    private String genre;
    private String duration;
    private String showDate;
    private String theater;

    public Movie(int movieId, String title, String cover, String synopsis, String genre, String duration, String showDate, String theater) {
        this.movieId = movieId;
        this.title = title;
        this.cover = cover;
        this.synopsis = synopsis;
        this.genre = genre;
        this.duration = duration;
        this.showDate = showDate;
        this.theater = theater;
    }

    // Getter methods
    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getShowDate() {
        return showDate;
    }

    public String getTheater() {
        return theater;
    }

    // Setter methods
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    @Override
    public String toString() {
        return String.format("Movie ID: %d, Title: %s, Genre: %s, Duration: %s, Show Date: %s, Theater: %s",
                movieId, title, genre, duration, showDate, theater);
    }
}
