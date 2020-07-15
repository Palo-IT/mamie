package org.paloit.mamie.portal.model;

import com.sun.istack.NotNull;
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

    @NotNull
    private String applicationName;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ApplicationComponent> applicationComponent;

    public MonitoredApplication() {
    }

    public MonitoredApplication(String applicationName, Set<ApplicationComponent> applicationComponent) {
        this.applicationName = applicationName;
        this.applicationComponent = applicationComponent;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Set<ApplicationComponent> getApplicationComponent() {
        return applicationComponent;
    }

    public void setApplicationComponent(Set<ApplicationComponent> applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
