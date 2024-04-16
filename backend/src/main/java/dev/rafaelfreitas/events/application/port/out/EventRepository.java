package dev.rafaelfreitas.events.application.port.out;

import dev.rafaelfreitas.events.domain.Event;
import dev.rafaelfreitas.events.infrastructure.adapter.EventEntity;
import dev.rafaelfreitas.events.infrastructure.adapter.InstitutionEntity;

import java.util.List;

public interface EventRepository {

    List<EventEntity> listEvents();
    EventEntity findEventById(Integer id);
    void deleteEvent(Integer id);
    EventEntity createEvent(EventEntity event);
    EventEntity updateEvent(EventEntity event);
}
