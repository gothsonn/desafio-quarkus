package dev.rafaelfreitas.events.application.port.out;

import dev.rafaelfreitas.events.infrastructure.adapter.EventEntity;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository {

    List<EventEntity> listEvents();
    EventEntity findEventById(Integer id);
    void deleteEvent(Integer id);
    EventEntity createEvent(EventEntity event);
    void activateEntities(LocalDate dateNow);
    void deactivateEntities(LocalDate dateNow);
}
