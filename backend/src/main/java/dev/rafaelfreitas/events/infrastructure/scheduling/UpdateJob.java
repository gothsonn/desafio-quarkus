package dev.rafaelfreitas.events.infrastructure.scheduling;

import dev.rafaelfreitas.events.application.port.out.EventRepository;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

@ApplicationScoped
public class UpdateJob {

    private final EventRepository eventRepository;

    public UpdateJob(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Transactional
    @Scheduled(cron="1 0 0 * * ?")
    public void performTask() {
        LocalDate dateNow = LocalDate.now();

        eventRepository.activateEntities(dateNow);
        eventRepository.deactivateEntities(dateNow);

    }
}
