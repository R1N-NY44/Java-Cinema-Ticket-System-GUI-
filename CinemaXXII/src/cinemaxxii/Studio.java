/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaxxii;

/**
 *
 * @author Yoga
 */
import java.util.ArrayList;
import java.util.List;

public class Studio {
    private String name;
    private int seatCount;
    private List<Boolean> seatStatus;
    private List<Movie> movies;

    public Studio(String name, int seatCount) {
        this.name = name;
        this.seatCount = seatCount;
        this.seatStatus = new ArrayList<>(seatCount);
        this.movies = new ArrayList<>();
        initializeSeatStatus();
    }

    private void initializeSeatStatus() {
        for (int i = 0; i < seatCount; i++) {
            seatStatus.add(false);
        }
    }

    public void displayInfo() {
        System.out.println("======[" + name + "]======");
        System.out.println("Total Seat : " + seatCount);
        System.out.print("Seat Status : ");
        for (int i = 0; i < seatCount; i++) {
            if (seatStatus.get(i)) {
                System.out.print("[" + (i + 1) + "] ");
            } else {
                System.out.print((i + 1) + ", ");
            }
        }
        System.out.println();
        if (!movies.isEmpty()) {
            Movie movie = movies.get(0); // Ambil film pertama (asumsi satu studio satu film)
            System.out.println("Movie : " + movie.getTitle());
            System.out.println("Genre : " + movie.getGenre());
            System.out.println("Duration : " + movie.getDuration() + " minutes");
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void reserveSeat(int seatNumber) {
        if (seatNumber > 0 && seatNumber <= seatCount) {
            seatStatus.set(seatNumber - 1, true);
        } else {
            System.out.println("Invalid seat number.");
        }
    }
}
