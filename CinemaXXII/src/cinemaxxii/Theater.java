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

public class Theater {
    private List<Studio> studios;

    public Theater(List<Studio> studios) {
        this.studios = studios;
    }

    public void displayInfo() {
        for (Studio studio : studios) {
            studio.displayInfo();
            System.out.println();
        }
    }
}
