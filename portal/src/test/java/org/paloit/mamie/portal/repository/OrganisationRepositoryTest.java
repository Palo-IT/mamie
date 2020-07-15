package org.paloit.mamie.portal.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.paloit.mamie.portal.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class OrganisationRepositoryTest {

    @Autowired
    private IOrganisationRepository organisationRepository;

    @Test
    public void testSaveOrganisation() {
        final Organisation organisation = new Organisation("PaloIT", Collections.emptySet());
        organisationRepository.save(organisation);

        final Iterable<Organisation> organisationRepositoryAll = organisationRepository.findAll();
        Assertions.assertThat(organisationRepositoryAll.iterator().hasNext());
    }
}