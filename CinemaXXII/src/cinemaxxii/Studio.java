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

// Kelas yang mewakili studio di teater
public class Studio extends EntertainmentEntity implements Displayable {
    private int seatCount;
    private List<Boolean> seatStatus;
    private List<Movie> movies;

    // Konstruktor untuk membuat objek Studio dengan nama dan jumlah kursi tertentu
    public Studio(String name, int seatCount) {
        super(name); // Memanggil konstruktor kelas induk untuk menetapkan nama studio
        this.seatCount = seatCount;
        this.seatStatus = new ArrayList<>(seatCount);
        this.movies = new ArrayList<>();
        initializeSeatStatus(); // Metode untuk menginisialisasi status kursi
    }

    // Metode untuk menginisialisasi status kursi
    private void initializeSeatStatus() {
        for (int i = 0; i < seatCount; i++) {
            seatStatus.add(false);
        }
    }

    // Metode dari interface Displayable untuk menampilkan informasi studio
    @Override
    public void displayInfo() {
        System.out.println("======[" + getName() + "]======");
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
            System.out.println("Movie : " + movie.getName());
            System.out.println("Genre : " + movie.getGenre());
            System.out.println("Duration : " + movie.getDuration() + " minutes");
        }
    }

    // Metode untuk menambahkan film ke dalam studio
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // Metode untuk mereservasi kursi di studio
    public void reserveSeat(int seatNumber) {
        if (isValidSeatNumber(seatNumber)) {
            seatStatus.set(seatNumber - 1, true);
        } else {
            System.out.println("Invalid seat number.");
        }
    }

    // Metode private untuk memeriksa apakah nomor kursi valid
    private boolean isValidSeatNumber(int seatNumber) {
        return seatNumber > 0 && seatNumber <= seatCount;
    }

    // Getter and setter for encapsulation
    public int getSeatCount() {
        return seatCount;
    }

    public List<Boolean> getSeatStatus() {
        return seatStatus;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
