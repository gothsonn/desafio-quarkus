package dev.rafaelfreitas.events.interfaces;

import dev.rafaelfreitas.events.infrastructure.scheduling.UpdateJob;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/tasks")
public class TaskResource {
    private final UpdateJob updateJob;

    public TaskResource(UpdateJob updateJob) {
        this.updateJob = updateJob;
    }

    @POST
    @Path("/execute")
    public void executeTask() {
        updateJob.performTask();
    }
}
