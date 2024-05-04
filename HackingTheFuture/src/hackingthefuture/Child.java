/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hackingthefuture;

/**
 *
 * @author weiqi
 */

import java.util.ArrayList;
import java.util.List;

public class Child {
    private String name;
    private List<Event> registeredEvents;

    public Child(String name) {
        this.name = name;
        this.registeredEvents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Event> getRegisteredEvents() {
        return registeredEvents;
    }

    public void addEvent(Event event) {
        registeredEvents.add(event);
    }
}