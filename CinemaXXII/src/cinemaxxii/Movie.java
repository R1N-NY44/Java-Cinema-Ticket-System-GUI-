/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaxxii;

/**
 *
 * @author Yoga
 */
// Kelas yang mewakili film
public class Movie extends EntertainmentEntity {
    private String genre;
    private int duration;

    // Konstruktor untuk membuat objek Movie dengan judul, genre, dan durasi tertentu
    public Movie(String title, String genre, int duration) {
        super(title); // Memanggil konstruktor kelas induk untuk menetapkan nama film
        this.genre = genre;
        this.duration = duration;
    }

    // Metode getter untuk mendapatkan genre film
    public String getGenre() {
        return genre;
    }

    // Metode getter untuk mendapatkan durasi film
    public int getDuration() {
        return duration;
    }
}
