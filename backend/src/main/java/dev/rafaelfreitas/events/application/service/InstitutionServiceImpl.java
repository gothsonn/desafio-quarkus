package dev.rafaelfreitas.events.application.service;

import dev.rafaelfreitas.events.application.port.out.InstitutionRepository;
import dev.rafaelfreitas.events.application.port.in.InstitutionService;
import dev.rafaelfreitas.events.domain.Institution;

import dev.rafaelfreitas.events.domain.InstitutionType;
import dev.rafaelfreitas.events.infrastructure.adapter.InstitutionEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class InstitutionServiceImpl implements InstitutionService {

    InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> listInstitutions() {
        return institutionRepository.listInstitutions().stream()
                .map(this::convertEntityToDomain)
                .toList();
    }

    @Override
    @Transactional
    public Institution saveInstitution(Institution institution) {
        InstitutionEntity savedEntity = institutionRepository.saveInstitution(convertDomainToEntity(institution));
        copyIdFromEntityToDomain(savedEntity, institution);
        return institution;
    }

    @Override
    @Transactional
    public Institution updateInstitution(Institution institution) {
        InstitutionEntity updatedEntity = institutionRepository.updateInstitution(convertDomainToEntity(institution));
        copyIdFromEntityToDomain(updatedEntity, institution);
        return institution;
    }

    @Override
    @Transactional
    public void deleteInstitution(Integer id) {
        institutionRepository.deleteInstitution(id);
    }

    protected Institution convertEntityToDomain(InstitutionEntity entity) {
        Institution institution = new Institution();
        institution.setId(entity.getId());
        institution.setName(entity.getName());
        institution.setType(convertAndSetType(entity.getType()));
        return institution;
    }

    protected InstitutionEntity convertDomainToEntity(Institution institution) {
        InstitutionEntity entity = new InstitutionEntity();
        entity.setName(institution.getName());
        entity.setType(institution.getType().name());
        return entity;
    }

    private InstitutionType convertAndSetType(String type) {
        try {
            return InstitutionType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid institution type: " + type);
        }
    }

    private void copyIdFromEntityToDomain(InstitutionEntity entity, Institution institution) {
        institution.setId(entity.getId());
    }

}