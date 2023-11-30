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
        Movie movie1 = new Movie("Inception", "Sci-Fi", 150);
        Movie movie2 = new Movie("The Shawshank Redemption", "Drama", 142);

        Studio studio1 = new Studio("Studio A", 15);
        Studio studio2 = new Studio("Studio B", 10);

        studio1.addMovie(movie1);
        studio2.addMovie(movie2);

        studio1.reserveSeat(6);
        studio1.reserveSeat(8);
        studio1.reserveSeat(11);

        studio2.reserveSeat(4);
        studio2.reserveSeat(8);

        Theater theater = new Theater(List.of(studio1, studio2));
        theater.displayInfo();
    }
}
