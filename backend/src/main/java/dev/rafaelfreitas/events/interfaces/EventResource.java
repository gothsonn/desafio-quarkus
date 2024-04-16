package dev.rafaelfreitas.events.interfaces;

import dev.rafaelfreitas.events.application.service.EventServiceImpl;
import dev.rafaelfreitas.events.domain.Event;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/events")
@Tag(name = "Event Resource", description = "CRUD de eventos para instituições")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource {

    private final EventServiceImpl eventService;

    public EventResource(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @POST
    @APIResponse(responseCode = "201", description = "Event Created", content = @Content(mediaType = "application/json"))
    public Response createEvent(@NotNull @Valid Event event) {
        event.validate();
        eventService.createEvent(event);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Response getEvent(@PathParam("id") Integer id) {
        Event event = eventService.findEventById(id);
        return event != null
                ? Response.ok(event).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public List<Event> listEvents() {
        return eventService.listEvents();
    }

    @PUT
    @Path("/{id}")
    public Response updateEvent(@PathParam("id") Integer id, Event event) {
        event.setId(id);
        eventService.updateEvent(event);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEvent(@PathParam("id") Integer id) {
        eventService.deleteEvent(id);
        return Response.noContent().build();
    }
}