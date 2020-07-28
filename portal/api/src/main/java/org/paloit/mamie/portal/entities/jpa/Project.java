package org.paloit.mamie.portal.entities.jpa;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Access(AccessType.FIELD)
public class Project {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID id;

    @NotNull
    private String projectName;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<MonitoredApplication> monitoredApplicationSet;

    public Project() {
    }

    public Project(String projectName, Set<MonitoredApplication> monitoredApplicationSet) {
        this.projectName = projectName;
        this.monitoredApplicationSet = monitoredApplicationSet;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<MonitoredApplication> getMonitoredApplicationSet() {
        return monitoredApplicationSet;
    }

    public void setMonitoredApplicationSet(Set<MonitoredApplication> monitoredApplicationSet) {
        this.monitoredApplicationSet = monitoredApplicationSet;
    }
}