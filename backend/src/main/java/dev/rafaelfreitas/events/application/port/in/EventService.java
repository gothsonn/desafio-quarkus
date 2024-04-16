package dev.rafaelfreitas.events.application.port.in;

import dev.rafaelfreitas.events.domain.Event;

import java.util.List;

public interface EventService {
    List<Event> listEvents();
    Event findEventById(Integer id);
    void deleteEvent(Integer id);
    void createEvent(Event event);
    void updateEvent(Event event);
}
