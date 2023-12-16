/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinemaxxii;

/**
 *
 * @author Yoga
 */


import cinemaxxii.display.DisplayFrame;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.UIManager;

public class CinemaXXII {
    private final DBConnection k = new DBConnection();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        try { //Design
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        
        DisplayFrame display = new DisplayFrame();
        display.setVisible(true);
        
        //inputData displayInput = new inputData();
        //displayInput.setVisible(true);
        
        CinemaXXII cinema = new CinemaXXII();
        cinema.displayMovies();
    }
    
        public void displayMovies() {
            try (Connection conn = k.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM film WHERE `Show Date` >= CURRENT_DATE;");
                ResultSet rs = ps.executeQuery()) {

                ArrayList<Movie> movies = new ArrayList<>();

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

                // Sekarang, 'movies' adalah ArrayList yang berisi objek Movie dari database.

                // Misalnya, mencetak detail film ke konsol:
                for (Movie movie : movies) {
                    System.out.println(movie);   
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
