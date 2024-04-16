package dev.rafaelfreitas.events.application.port.in;

import dev.rafaelfreitas.events.domain.Event;
import dev.rafaelfreitas.events.domain.Institution;

import java.util.List;

public interface EventService {
    List<Event> listEvents();
    Event findEventById(Integer id);
    void deleteEvent(Integer id);
    Event createEvent(Event event);
    Event updateEvent(Event event);
}
