package org.paloit.mamie.portal.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.paloit.mamie.portal.model.ApplicationComponent;
import org.paloit.mamie.portal.model.MonitoredApplication;
import org.paloit.mamie.portal.model.Organisation;
import org.paloit.mamie.portal.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collections;
import java.util.List;
import java.util.Set;


@DataJpaTest
class ModelRepositoryTest {

    public static final String ORGANISATION_NAME = "PaloIT";

    @Autowired
    private IOrganisationRepository organisationRepository;

    @Test
    public void testSaveOrganisation() {

        final Organisation organisation = new Organisation(ORGANISATION_NAME, Collections.emptySet());
        organisationRepository.save(organisation);

        final List<Organisation> organisationRepositoryAll = organisationRepository.findAll();
        Assertions.assertThat(organisationRepositoryAll).hasSize(1);

        final Organisation savedOrganisation = organisationRepositoryAll.iterator().next();

        Assertions.assertThat(savedOrganisation)
                .extracting(Organisation::getId)
                .isNotNull();

        Assertions.assertThat(savedOrganisation)
                .extracting(Organisation::getOrganisationName)
                .isEqualTo(ORGANISATION_NAME);

    }

    @Test
    public void testSaveFullModel() {

        final Set<Organisation> organisations = Set.of(
                new Organisation("Org 1", Set.of(
                        new Project("First project", Set.of(
                                new MonitoredApplication("My first App", Set.of(
                                        new ApplicationComponent("Back Java"),
                                        new ApplicationComponent("Front react"),
                                        new ApplicationComponent("Front Android")
                                )),
                                new MonitoredApplication("My second App", Set.of(
                                        new ApplicationComponent("Docker App")
                                ))
                        )),
                        new Project("Empty project", Collections.emptySet())
                )),
                new Organisation("Org 2", Set.of(
                        new Project("First project", Set.of(
                                new MonitoredApplication("My App", Set.of(
                                        new ApplicationComponent("Back Java")
                                )),
                                new MonitoredApplication("My second App", Set.of(
                                        new ApplicationComponent("Docker App")
                                ))
                        ))
                ))
        );

        organisationRepository.saveAll(organisations);

        final List<Organisation> organisationRepositoryAll = organisationRepository.findAll();

        Assertions.assertThat(organisationRepositoryAll)
                .hasSize(2);

    }
}