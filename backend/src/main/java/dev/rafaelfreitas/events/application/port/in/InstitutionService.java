package dev.rafaelfreitas.events.application.port.in;

import dev.rafaelfreitas.events.domain.Institution;
import java.util.List;

public interface InstitutionService {
    List<Institution> listInstitutions();
    Institution saveInstitution(Institution institution);
    Institution updateInstitution(Institution institution);
    void deleteInstitution(Integer id);
}
