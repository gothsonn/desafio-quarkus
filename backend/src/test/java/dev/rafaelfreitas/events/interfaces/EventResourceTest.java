package dev.rafaelfreitas.events.interfaces;

import dev.rafaelfreitas.events.application.service.EventServiceImpl;
import dev.rafaelfreitas.events.domain.Event;
import dev.rafaelfreitas.events.interfaces.EventResource;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class EventResourceTest {

    private final EventServiceImpl eventService = Mockito.mock(EventServiceImpl.class);
    private final EventResource eventResource = new EventResource(eventService);

    @Test
    void testCreateEvent_Succeeds_When_EventIsValid() {
        Event event = new Event();
        event.setId(1);
        event.setName("Test Event");
        event.setStartDate(LocalDate.now());
        event.setEndDate(LocalDate.now().plusDays(2));
        event.setIsActive(true);
        

        Response response = eventResource.createEvent(event);
        
        verify(eventService).createEvent(event);
        assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
    }

}