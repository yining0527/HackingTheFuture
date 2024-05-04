/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hackingthefuture;

/**
 *
 * @author weiqi
 */
import java.time.LocalDate;

public class Event {
    private LocalDate date;

    public Event(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
