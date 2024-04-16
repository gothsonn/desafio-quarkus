package dev.rafaelfreitas.events.application.service;

import dev.rafaelfreitas.events.application.port.in.EventService;
import dev.rafaelfreitas.events.application.port.out.EventRepository;
import dev.rafaelfreitas.events.domain.Event;

import dev.rafaelfreitas.events.domain.Institution;
import dev.rafaelfreitas.events.infrastructure.adapter.EventEntity;
import dev.rafaelfreitas.events.infrastructure.adapter.InstitutionEntity;
import dev.rafaelfreitas.events.infrastructure.utils.DateTimeUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class EventServiceImpl implements EventService {

    EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listEvents() {
        return eventRepository.listEvents().stream()
                .map(this::convertEntityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Event createEvent(Event event) {
        EventEntity savedEntity = eventRepository.createEvent(convertDomainToEntity(event));
        event.setId(savedEntity.getId());
        return event;
    }

    @Override
    public Event findEventById(Integer id) {
        EventEntity eventEntity = eventRepository.findEventById(id);
        return convertEntityToDomain(eventEntity);
    }

    @Override
    @Transactional
    public void deleteEvent(Integer id) {
        eventRepository.deleteEvent(id);
    }

    @Override
    @Transactional
    public Event updateEvent(Event event) {
        EventEntity updatedEntity = eventRepository.updateEvent(convertDomainToEntity(event));
        return convertEntityToDomain(updatedEntity);
    }

    private Event convertEntityToDomain(EventEntity entity) {
        Event event = new Event();
        event.setId(entity.getId());
        event.setName(entity.getName());
        event.setStartDate(DateTimeUtil.toLocalDate(entity.getStartDate()));
        event.setEndDate(DateTimeUtil.toLocalDate(entity.getEndDate()));
        event.setIsActive(entity.isActive());
        Institution institution = new Institution();
        institution.setId(entity.getInstitution().getId());
        institution.setName(entity.getInstitution().getName());
        institution.setType(entity.getInstitution().getType());
        event.setInstitution(institution);
        return event;
    }

    private EventEntity convertDomainToEntity(Event event) {
        EventEntity entity = new EventEntity();
        entity.setId(event.getId());
        entity.setName(event.getName());
        entity.setStartDate(DateTimeUtil.toLocalDateTime(event.getStartDate()));
        entity.setEndDate(DateTimeUtil.toLocalDateTime(event.getEndDate()));
        entity.setActive(event.isActive());
        InstitutionEntity institutionEntity = new InstitutionEntity();
        institutionEntity.setId(event.getInstitution().getId());
        institutionEntity.setName(event.getInstitution().getName());
        institutionEntity.setType(event.getInstitution().getType());
        entity.setInstitution(institutionEntity);
        return entity;
    }
}