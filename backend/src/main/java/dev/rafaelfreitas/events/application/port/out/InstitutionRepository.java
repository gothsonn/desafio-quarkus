package dev.rafaelfreitas.events.application.port.out;

import dev.rafaelfreitas.events.infrastructure.adapter.InstitutionEntity;

import java.util.List;

public interface InstitutionRepository {
    List<InstitutionEntity> listInstitutions();
    InstitutionEntity saveInstitution(InstitutionEntity institution);
    InstitutionEntity updateInstitution(InstitutionEntity institution);
    void deleteInstitution(Integer id);
}