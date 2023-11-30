/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaxxii;

/**
 *
 * @author Yoga
 */
import java.util.List;

// Kelas yang mewakili teater yang terdiri dari beberapa studio
public class Theater implements Displayable {
    private List<Studio> studios;

    // Konstruktor untuk membuat objek Theater dengan daftar studio
    public Theater(List<Studio> studios) {
        this.studios = studios;
    }

    // Metode dari interface Displayable untuk menampilkan informasi teater
    @Override
    public void displayInfo() {
        for (Studio studio : studios) {
            studio.displayInfo();
            System.out.println();
        }
    }
}
