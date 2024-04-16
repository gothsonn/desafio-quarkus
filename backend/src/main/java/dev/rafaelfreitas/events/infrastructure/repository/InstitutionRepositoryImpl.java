package dev.rafaelfreitas.events.infrastructure.repository;

import dev.rafaelfreitas.events.application.port.out.InstitutionRepository;
import dev.rafaelfreitas.events.domain.Institution;
import dev.rafaelfreitas.events.infrastructure.adapter.InstitutionEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class InstitutionRepositoryImpl implements PanacheRepositoryBase<InstitutionEntity, Integer>, InstitutionRepository {

    @Override
    public List<InstitutionEntity> listInstitutions() {
        return listAll();
    }

    @Override
    public InstitutionEntity saveInstitution(InstitutionEntity institution) {
        persist(institution);
        return institution;
    }

    @Override
    public InstitutionEntity updateInstitution(InstitutionEntity institution) {
        persist(institution);
        return institution;
    }

    @Override
    public void deleteInstitution(Integer id) {
        deleteById(id);
    }
}