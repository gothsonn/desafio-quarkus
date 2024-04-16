package dev.rafaelfreitas.events.infrastructure.repository;

import dev.rafaelfreitas.events.application.port.out.EventRepository;
import dev.rafaelfreitas.events.infrastructure.adapter.EventEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
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
    public void deleteEvent(Integer id) {
        deleteById(id);
    }

    @Override
    @Transactional
    public void activateEntities(LocalDate dateNow) {
        update("is_active = true where start_date <= ?1 and end_date >= ?1 and is_active = false", dateNow);
    }

    @Override
    @Transactional
    public  void deactivateEntities(LocalDate dateNow) {
        update("is_active = false where end_date < ?1 and is_active = true", dateNow);
    }


}

