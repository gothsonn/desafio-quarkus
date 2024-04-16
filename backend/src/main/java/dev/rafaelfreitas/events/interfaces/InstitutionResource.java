package dev.rafaelfreitas.events.interfaces;

import dev.rafaelfreitas.events.application.port.in.InstitutionService;
import dev.rafaelfreitas.events.domain.Institution;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/institutions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InstitutionResource {


    public final InstitutionService instituionService;

    public InstitutionResource(InstitutionService instituionService) {
        this.instituionService = instituionService;
    }

    @GET
    public List<Institution> getAllInstitutions() {
        return instituionService.listInstitutions();
    }

    @POST
    public Institution createInstitution(Institution institution) {
        return instituionService.saveInstitution(institution);
    }

    @PUT
    @Path("/{id}")
    public Institution updateInstitution(@PathParam("id") Integer id, Institution institution) {
        institution.setId(id);
        return instituionService.updateInstitution(institution);
    }

    @DELETE
    @Path("/{id}")
    public void deleteInstitution(@PathParam("id") Integer id) {
        instituionService.deleteInstitution(id);
    }
}