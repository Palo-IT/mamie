package org.paloit.mamie.portal.entities.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "Metrics")
public class Metric {


    @Indexed
    private UUID componentUUID;

    private long cpuLoad;
    private long timeStamp;

    public Metric() {
    }

    public Metric(UUID componentUUID, long cpuLoad, long timeStamp) {
        this.componentUUID = componentUUID;
        this.cpuLoad = cpuLoad;
        this.timeStamp = timeStamp;
    }


    public UUID getComponentUUID() {
        return componentUUID;
    }

    public void setComponentUUID(UUID componentUUID) {
        this.componentUUID = componentUUID;
    }

    public long getCpuLoad() {
        return cpuLoad;
    }

    public void setCpuLoad(long cpuLoad) {
        this.cpuLoad = cpuLoad;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
