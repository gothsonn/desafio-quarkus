package dev.rafaelfreitas.events.application.service;

import dev.rafaelfreitas.events.infrastructure.adapter.InstitutionEntity;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import dev.rafaelfreitas.events.application.port.out.InstitutionRepository;
import dev.rafaelfreitas.events.domain.Institution;

public class InstitutionServiceImplTest {

    Mockery context = new Mockery();
    InstitutionRepository institutionRepository = context.mock(InstitutionRepository.class);

    @Test
    public void testListInstitutions() {
        InstitutionServiceImpl service = new InstitutionServiceImpl(institutionRepository);

        Institution institution1 = new Institution();
        institution1.setId(1);
        institution1.setName("Institution 1");
        institution1.setType("Type 1");

        Institution institution2 = new Institution();
        institution2.setId(2);
        institution2.setName("Institution 2");
        institution2.setType("Type 2");

        List<Institution> institutions = Arrays.asList(institution1, institution2);

        List<InstitutionEntity> entityList = institutions.stream()
                .map(service::convertDomainToEntity)
                .toList();

        context.checking(new Expectations() {{
            oneOf(institutionRepository).listInstitutions();
            will(returnValue(entityList));
        }});

        assert(service.listInstitutions().size() == 2);

        context.assertIsSatisfied();
    }
}