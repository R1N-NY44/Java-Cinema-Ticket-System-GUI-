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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Kelas yang mewakili studio di teater
public class Studio extends EntertainmentEntity implements Displayable {
    private int seatCount;
    private List<Boolean> seatStatus;
    private List<Movie> movies;

    // Map untuk menyimpan informasi reservasi (nomor kursi dan User)
    private Map<Integer, User> reservations;

    // Konstruktor untuk membuat objek Studio dengan nama dan jumlah kursi tertentu
    public Studio(String name, int seatCount) {
        super(name); // Memanggil konstruktor kelas induk untuk menetapkan nama studio
        this.seatCount = seatCount;
        this.seatStatus = new ArrayList<>(seatCount);
        this.movies = new ArrayList<>();
        this.reservations = new HashMap<>();
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

    // Metode untuk mereservasi kursi di studio dengan informasi pengguna
    public void reserveSeat(int seatNumber, User user) {
        if (isValidSeatNumber(seatNumber)) {
            seatStatus.set(seatNumber - 1, true);
            reservations.put(seatNumber, user);
        } else {
            System.out.println("Invalid seat number.");
        }
    }

    // Metode private untuk memeriksa apakah nomor kursi valid
    private boolean isValidSeatNumber(int seatNumber) {
        return seatNumber > 0 && seatNumber <= seatCount;
    }

    // Metode untuk mendapatkan informasi reservasi berdasarkan nomor kursi
    public void getReservationInfo(int seatNumber) {
        User user = reservations.get(seatNumber);
        if (user != null) {
            System.out.println("======[Reservation Info]======");
            System.out.println("Reservation Info for Seat " + seatNumber + ":");
            System.out.println("User Name: " + user.getName());
            System.out.println("User Email: " + user.getEmail());
        } else {
            System.out.println("No reservation found for Seat " + seatNumber);
        }
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
