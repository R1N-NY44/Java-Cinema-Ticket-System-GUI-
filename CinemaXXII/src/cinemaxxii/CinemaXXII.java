/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinemaxxii;

/**
 *
 * @author Yoga
 */
import java.util.List;
public class CinemaXXII {
    // Kelas utama yang berisi metode main
    public static void main(String[] args) {
        // Membuat objek User
        User user1 = new User("John Doe", "john.doe@example.com");

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
    }
}
