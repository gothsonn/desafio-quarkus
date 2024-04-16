package dev.rafaelfreitas.events.infrastructure.repository;

import dev.rafaelfreitas.events.application.port.out.EventRepository;
import dev.rafaelfreitas.events.domain.Event;
import dev.rafaelfreitas.events.infrastructure.adapter.EventEntity;
import dev.rafaelfreitas.events.infrastructure.adapter.InstitutionEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EventRepositoryImpl implements PanacheRepositoryBase<EventEntity, Integer>, EventRepository {

    @Override
    public List<EventEntity> listEvents() {
        return listAll();
    }

    @Override
    public EventEntity findEventById(Integer id) {
        return findById(id);
    }

    @Override
    public EventEntity createEvent(EventEntity event) {
        persist(event);
        return event;
    }

    @Override
    public EventEntity updateEvent(EventEntity event) {
        persist(event);
        return event;
    }

    @Override
    public void deleteEvent(Integer id) {
        deleteById(id);
    }


}

