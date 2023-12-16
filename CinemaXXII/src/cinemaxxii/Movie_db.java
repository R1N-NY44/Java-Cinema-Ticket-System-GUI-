/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaxxii;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Yoga
 */
public class Movie_db {
    
    // private Connection conn;
    private final DBConnection c = new DBConnection();

    //Get the movie data
    public ArrayList<Movie> dbMovies() throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
    
            Connection conn = c.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM film WHERE `Show Date` >= CURRENT_DATE;");
            ResultSet rs = ps.executeQuery();
    
            while (rs.next()) {
                int movieId = rs.getInt("MovieId");
                String title = rs.getString("Title");
                String cover = rs.getString("Cover");
                String banner = rs.getString("Banner");
                String synopsis = rs.getString("Synopsis");
                String genre = rs.getString("Genre");
                String duration = rs.getString("Duration");
                String showDate = rs.getString("Show Date");
                String theater = rs.getString("Theater");
    
                Movie movie = new Movie(movieId, title, cover, banner, synopsis, genre, duration, showDate, theater);
                movies.add(movie);
            }
            
        rs.close();
        ps.close();
        conn.close();
        return movies;
    }
    
}
