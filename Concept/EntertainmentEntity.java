/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaxxii;

/**
 *
 * @author Yoga
 */
// Abstrak kelas yang mewakili entitas hiburan
public abstract class EntertainmentEntity {
    private String name;

    // Konstruktor untuk menetapkan nama entitas
    public EntertainmentEntity(String name) {
        this.name = name;
    }

    // Metode getter untuk mendapatkan nama entitas
    public String getName() {
        return name;
    }
}
