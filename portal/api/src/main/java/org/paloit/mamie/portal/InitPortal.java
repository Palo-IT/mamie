package org.paloit.mamie.portal;

import org.paloit.mamie.portal.entities.jpa.ApplicationComponent;
import org.paloit.mamie.portal.entities.jpa.MonitoredApplication;
import org.paloit.mamie.portal.entities.jpa.Organisation;
import org.paloit.mamie.portal.entities.jpa.Project;
import org.paloit.mamie.portal.repository.jpa.IOrganisationRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

@Component
public class InitPortal implements InitializingBean {

    private final IOrganisationRepository organisationRepository;

    public InitPortal(IOrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    @Override
    public void afterPropertiesSet() {
        final Set<Organisation> organisations = Set.of(
                new Organisation("PaloIT FR", Set.of(
                        new Project("Test project", Set.of(
                                new MonitoredApplication("All components application !", Set.of(
                                        new ApplicationComponent("Back Java"),
                                        new ApplicationComponent("Front react")
                                )),
                                new MonitoredApplication("Full Dockerized application", Set.of(
                                        new ApplicationComponent("Docker App 1"),
                                        new ApplicationComponent("Docker App 2"),
                                        new ApplicationComponent("Docker App 3")
                                ))
                        )),
                        new Project("Running Internal App", Collections.emptySet()))
                )
        );
        organisationRepository.saveAll(organisations);
    }
}
