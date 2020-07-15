package org.paloit.mamie.portal.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Access(AccessType.FIELD)
public class MonitoredApplication {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID id;

    private String applicationName;

    @OneToMany
    private Set<ApplicationComponent> applicationComponent;
}
