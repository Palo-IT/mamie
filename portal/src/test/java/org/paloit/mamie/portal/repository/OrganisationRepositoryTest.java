package org.paloit.mamie.portal.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.paloit.mamie.portal.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class OrganisationRepositoryTest {

    public static final String ORGANISATION_NAME = "PaloIT";
    @Autowired
    private IOrganisationRepository organisationRepository;

    @Test
    public void testSaveOrganisation() {
        final Organisation organisation = new Organisation(ORGANISATION_NAME, Collections.emptySet());
        organisationRepository.save(organisation);

        final Iterable<Organisation> organisationRepositoryAll = organisationRepository.findAll();
        Assertions.assertThat(organisationRepositoryAll.iterator().hasNext()).isTrue();
        final Organisation savedOrganisation = organisationRepositoryAll.iterator().next();

        Assertions.assertThat(savedOrganisation)
                .extracting(Organisation::getId)
                .isNotNull();
        Assertions.assertThat(savedOrganisation)
                .extracting(Organisation::getOrganisationName)
                .isEqualTo(ORGANISATION_NAME);
        
    }
}