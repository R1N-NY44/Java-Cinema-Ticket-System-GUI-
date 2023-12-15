/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinemaxxii;

/**
 *
 * @author Yoga
 */
<<<<<<< Updated upstream
=======
import cinemaxxii.view.Display;
import java.util.List;
>>>>>>> Stashed changes
public class CinemaXXII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
<<<<<<< Updated upstream
        // TODO code application logic here
=======
        // Membuat objek User
        User user1 = new User("John Doe", "john.doe@example.com");
        
        //Frame login & register
        Display gateFrame = new Display();
        
        gateFrame.setVisible(true);

        // Membuat objek Movie
        Movie movie1 = new Movie("Inception", "Sci-Fi", 150);

        // Membuat objek Studio
        Studio studio1 = new Studio("Studio A", 15);
        Studio studio2 = new Studio("Studio B", 10);

        // Menambahkan film ke studio
        studio1.addMovie(movie1);

        // Reservasi kursi dengan informasi pengguna
        studio1.reserveSeat(6, user1);

        // Menampilkan informasi reservasi
        studio1.getReservationInfo(6);

        // Menampilkan informasi teater
        Theater theater = new Theater(List.of(studio1, studio2));
        theater.displayInfo();
>>>>>>> Stashed changes
    }
    
}
